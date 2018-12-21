package com.ardecs.SpringDataJpaJava.controller.restful;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
public class ProductRESTFulController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getProduct(@PathVariable long id, HttpServletResponse response) throws IOException {
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Product with ID=" + id + " no found");
            return null;
        }

    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.PUT)
    public void updateProduct(@PathVariable Long id,
                              String name,
                              Long countryId,
                              Long categoryId,
                              @ApiParam(value = "Product description")
                              @RequestParam("comment")
                                      String comment,
                              Float price,
                              HttpServletResponse response
    ) throws IOException {
        try {
            productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Product with ID=" + id + " no found");
        }
        Product product = productRepository.findById(id).get();
        if (null != name) {
            product.setName(name);
        }
        if (null != price) {
            product.setPrice(price);
        }
        if (null != comment) {
            product.setComment(comment);
        }
        if (null != categoryId) {
            try {
                Category category = categoryRepository.findById(categoryId).get();
                product.setCategory(category);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Category with ID=" + categoryId + " no found");
            }
        }
        if (null != countryId) {
            try {
                Country country = countryRepository.findById(countryId).get();
                product.setCountry(country);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + countryId + " no found");
            }
        }
        productRepository.save(product);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id,HttpServletResponse response) throws IOException {
        try {
            productRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Product with ID=" + id + " no found");
        }
    }
//TODO сделать проверку, передавать только необходимые параметры(не объекты целиком)
    @RequestMapping(value = {"/product"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(Product product, HttpServletResponse response) {
        productRepository.save(product);
        response.setHeader("Location", "/product/" + product.getId());

    }
}
