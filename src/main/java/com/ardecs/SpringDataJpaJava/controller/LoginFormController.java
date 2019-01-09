package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginFormController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/loginPage"}, method = RequestMethod.GET)
    public String showLoginForm() {
        return "loginPage";
    }
}
