package com.ardecs.SpringDataJpaJava.controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("positions")
@Controller
public class AddProductToCart {
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
    final Random random = new Random();

    @RequestMapping(value = "/addProductToCart", method = RequestMethod.POST)
    public String addProductToCart(@RequestParam("productId") long id, @RequestParam("quantity") long quantity, HttpSession httpSession) {
        if (httpSession.getAttribute("positions") == null) {
            TreeMap<Long, Position> positions = new TreeMap<>();
            httpSession.setAttribute("positions", positions);
        }
        Product product = productRepository.findById(id).get();
        Position position = new Position(quantity, product);
        TreeMap<Long, Position> positions = (TreeMap<Long, Position>) httpSession.getAttribute("positions");
        if (positions.isEmpty() || !positions.containsKey(id)) {
            positions.put(id, position);
        }
        httpSession.setAttribute("positions", positions);
        return "redirect:/";
    }
}
