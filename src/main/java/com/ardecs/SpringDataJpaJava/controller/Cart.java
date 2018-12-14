package com.ardecs.SpringDataJpaJava.controller;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("positions")
@Controller
public class Cart {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model, HttpSession httpSession) {
        TreeMap<Product, Long> positions = (TreeMap<Product, Long>) httpSession.getAttribute("positions");
        if (positions == null) {
            positions = new TreeMap<>();
            httpSession.setAttribute("positions", positions);
        }
        model.addAttribute(positions);
        return "Cart";
    }
}
