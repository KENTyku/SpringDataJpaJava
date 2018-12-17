package com.ardecs.SpringDataJpaJava.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ardecs.SpringDataJpaJava.Entity.Category;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveProductController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    final Random random = new Random();
    private float price;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("comment") String comment,
            @RequestParam("price") String priceString,
            @RequestParam("countryId") long countryId,
            @RequestParam("categoryId") long categoryId


    ) {
        try {
            price = Float.parseFloat(priceString);
        } catch (NumberFormatException ex) {
            return "redirect:home";
        }

        if (name == null || name.isEmpty()) {
            name = String.valueOf(random.nextInt(10000000) + 1);
        }
        if (comment == null || comment.isEmpty()) {
            comment = String.valueOf(random.nextInt(10000000) + 1);
        }
        Country country = countryRepository.findById(countryId).get();
        Category category = categoryRepository.findById(categoryId).get();
        Product product = new Product(price, name, comment, country, category);

        if (id != 0) {
            product = productRepository.findById(id).get();
            product.setName(name);
            product.setComment(comment);
            product.setCountry(country);
            product.setCategory(category);
            product.setPrice(price);
        }
        productRepository.save(product);
        return "redirect:/";
    }
}
