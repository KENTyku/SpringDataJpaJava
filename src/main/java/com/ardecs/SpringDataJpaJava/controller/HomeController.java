package com.ardecs.SpringDataJpaJava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showProducts(Model model) {
        List<Product> productsList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productsList);
        return "index";
    }
}
