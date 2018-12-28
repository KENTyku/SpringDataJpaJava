package com.ardecs.SpringDataJpaJava.controller.restful;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsRESTFulController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody

    public List<Product> getProducts(
            @ApiParam(value = "Number page", example = "0", required = true)
            @RequestParam("offset")
                    int offset,
            @ApiParam(value = "Quality rows in page", example = "10", required = true)
            @RequestParam("limit")
                    int limit,
            @ApiParam(value = "Property for sort. It's column name", example = "price", required = true)
            @RequestParam("propertySort")
                    String propertySort,
            HttpServletResponse response) throws IOException {
        try {
            Page<Product> page = productRepository.findAll(PageRequest.of(offset, limit, Sort.by(new Sort.Order(Sort.Direction.ASC, propertySort))));
            return page.getContent();
        } catch (PropertyReferenceException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "PropertySort=" + propertySort + " no found ");
            return null;
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "PropertySotr=" + propertySort + " must not null or empty, " +
                    "or limit=" + limit + "  must not be less than one!");
            return null;
        }
    }
}
