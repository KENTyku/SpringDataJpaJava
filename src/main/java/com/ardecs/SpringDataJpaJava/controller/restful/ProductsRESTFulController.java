package com.ardecs.SpringDataJpaJava.controller.restful;

import java.util.ArrayList;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsRESTFulController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<Product> getProducts() {
        ArrayList<Product> productsList = (ArrayList<Product>) productRepository.findAll();
        return productsList;
    }
}
