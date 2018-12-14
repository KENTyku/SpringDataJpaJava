package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.TreeMap;

@SessionAttributes("positions")
@Controller
public class EditCartProduct {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/editCartProduct", method = RequestMethod.POST)
    public String deleteCartProduct(@RequestParam("productId") long id,
                                    @RequestParam("quantity") long quantity,
                                    @ModelAttribute("positions") TreeMap<Product, Long> positions,
                                    HttpSession httpSession) {
        Product product = productRepository.findById(id).get();
        positions.put(product, quantity);
        httpSession.setAttribute("positions", positions);
        return "redirect:cart";
    }
}
