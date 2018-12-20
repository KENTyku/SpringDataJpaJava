package com.ardecs.SpringDataJpaJava.controller.restful;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = { "propertySort" })
@RestController
public class ProductsRESTFulController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> getProducts(int offset, int limit, String propertySort, HttpServletResponse response) throws IOException {
        try {
            Page<Product> page = productRepository.findAll(PageRequest.of(offset, limit, Sort.by(new Sort.Order(Sort.Direction.ASC, propertySort))));
            List<Product> productsList = page.getContent();
            return productsList;
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
