package com.ardecs.SpringDataJpaJava.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveProduct {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderPositionRepository orderPositionRepository;
    private OrderPositionId id;
    @Autowired
    private ReportRepository reportRepository;
    final Random random=new Random();

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("comment") String comment,
            @RequestParam("price") float price,
            @RequestParam("countryId") long countryId,
            @RequestParam("categoryId") long categoryId
    ) {
        if ((name=="")||(name==null)){
            name=String.valueOf(random.nextInt(10000000)+1);
        }
        if ((comment=="")||(comment==null)){
            comment=String.valueOf(random.nextInt(10000000)+1);
        }
        System.out.println( "TESTTTTTTTTTTTTTTTTTTTTTTT"+id+" " + name+" " + comment +" "+ price+" "+categoryId);
        Country country = countryRepository.findById(countryId).get();
        Category category = categoryRepository.findById(categoryId).get();
        Product product = new Product(price, name, comment, country, category);
        if (id!=0){
            product=productRepository.findById(id).get();
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
