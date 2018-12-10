package com.ardecs.SpringDataJpaJava.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping({"/createProduct"})
public class editController {
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

    @RequestMapping(value = "/createProduct", method = RequestMethod.GET, params = "new")
    public String createProduct(@ModelAttribute("product") Product product) {
        if (!categoryRepository.existsByName("Computer")) {
            Category category = new Category("Computer");
            categoryRepository.save(category);
        }
        if (!categoryRepository.existsByName("Mobile")) {
            Category category = new Category("Mobile");
            categoryRepository.save(category);
        }
        if (!categoryRepository.existsByName("Audio")) {
            Category category = new Category("Audio");
            categoryRepository.save(category);
        }
        if (!countryRepository.existsByName("USA")) {
            Country country = new Country("USA");
            countryRepository.save(country);
        }
        if (!countryRepository.existsByName("Russia")) {
            Country country = new Country("Russia");
            countryRepository.save(country);
        }
        if (!countryRepository.existsByName("Japan")) {
            Country country = new Country("Japan");
            countryRepository.save(country);
        }
        return "editProduct"; // Вернуть имя представления
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String saveProduct(Product product, Model model) {
        String name = product.getName();
        System.out.println(name);
        model.addAttribute(product);
        productRepository.save(product);
        return "productList";

    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public String showProductList() {
        return "productList";
    }

    @RequestMapping(value = "/listOrder", method = RequestMethod.GET)
    public String showListOrder() {
        return "listOrder";
    }
}