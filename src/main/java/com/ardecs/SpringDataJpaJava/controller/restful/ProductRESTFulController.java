package com.ardecs.SpringDataJpaJava.controller.restful;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
            Product product = productRepository.findById(Long.valueOf(id)).get();
            return product;
        } catch (NoSuchElementException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Product with ID=" + id + " no found");
            return null;
        }

    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.PUT)
    public void updateProduct(@PathVariable Long id, String name, Long countryId, Long categoryId, String comment, Float price, HttpServletResponse response) throws IOException {
        try {
            productRepository.findById(id);
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
        if (null != categoryId) {
            try {
                categoryRepository.findById(categoryId);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Category with ID=" + id + " no found");
            }
            Category category = categoryRepository.findById(categoryId).get();
            product.setCategory(category);
        }
        if (null != countryId) {
            try {
                countryRepository.findById(countryId);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found");
            }
            Country country = countryRepository.findById(countryId).get();
            product.setCountry(country);
        }
        productRepository.save(product);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        productRepository.deleteById(id);

    }

    @RequestMapping(value = {"/product"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(Product product, HttpServletResponse response) {
        productRepository.save(product);
        response.setHeader("Location", "/product/" + product.getId());

    }
}
