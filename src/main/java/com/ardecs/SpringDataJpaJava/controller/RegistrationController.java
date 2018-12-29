package com.ardecs.SpringDataJpaJava.controller;

import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/registrationClient"}, method = RequestMethod.POST)
    public String addClientAccount(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String passwordConfirm,
            Model model
    ) {
        List<Product> productsList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productsList);
        return "products";
    }
}
