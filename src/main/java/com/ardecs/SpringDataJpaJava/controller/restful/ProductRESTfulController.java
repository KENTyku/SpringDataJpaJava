package com.ardecs.SpringDataJpaJava.controller.restful;

import java.util.ArrayList;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRESTfulController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/product/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getProcuct(@PathVariable long id) {
       Product product = productRepository.findById(Long.valueOf(id)).orElseThrow(IllegalStateException::new);
        return product;
    }
}
