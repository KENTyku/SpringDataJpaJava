package com.ardecs.SpringDataJpaJava.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Products {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showProducts(Model model) {
        List<Product> productsList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productsList);
        return "Products";
    }
}
