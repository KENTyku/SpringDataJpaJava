package com.ardecs.SpringDataJpaJava.controller.restful;

import java.util.ArrayList;

import com.ardecs.SpringDataJpaJava.Entity.Product;
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

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getProduct(@PathVariable long id) {
        Product product = productRepository.findById(Long.valueOf(id)).orElseThrow(IllegalStateException::new);
        return product;
    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product putProduct(@PathVariable long id, Product product) {
        product.setId(id);
        productRepository.save(product);
        return null;
    }

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product deleteProduct(@PathVariable long id) {
        productRepository.deleteById(id);
        return null;
    }

    @RequestMapping(value = {"/product"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(Product product, HttpServletResponse response) {
        productRepository.save(product);
        response.setHeader("Location","/product/"+product.getId());
        return null;
    }
}
