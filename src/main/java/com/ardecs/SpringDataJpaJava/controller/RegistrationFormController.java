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

@Controller
public class RegistrationFormController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String addClientAcount() {
        return "registration";
    }
}
