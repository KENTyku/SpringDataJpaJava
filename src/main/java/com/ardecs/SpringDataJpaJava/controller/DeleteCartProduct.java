package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.TreeMap;

@SessionAttributes("positions")
@Controller
public class DeleteCartProduct {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/deleteCartProduct", method = RequestMethod.GET)
    public String deleteCartProduct(@RequestParam("productId") long id,
                                    @ModelAttribute("positions") TreeMap<Product, Long> positions,
                                    HttpSession httpSession) {
        System.out.println("TESTTTTTTTTTTTTTT" + positions.size());
        Product product = productRepository.findById(id).get();
        positions.remove(product);
        httpSession.setAttribute("positions", positions);
        return "redirect:cart";
    }
}
