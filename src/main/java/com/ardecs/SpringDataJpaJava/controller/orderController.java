package com.ardecs.SpringDataJpaJava.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
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
public class orderController {
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

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET, params = "newOrder")
    public String createOrder(@ModelAttribute("orderPosition") OrderPosition orderPosition,
                              ArrayList<Product> productList,
                              Client client,
                              Order order,
                              OrderPositionId orderPositionId,
                              Product product,
                              Model model) {
        client = new Client("Yuri", "9051111111");
        clientRepository.save(client);
        LocalDateTime date;
        date = LocalDateTime.now();
        order = new Order(date, client);

        productList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productList);
        model.addAttribute(client);
        model.addAttribute(order);
        model.addAttribute(orderPositionId);
        model.addAttribute(product);
        return "productListForOrder";
    }
}
