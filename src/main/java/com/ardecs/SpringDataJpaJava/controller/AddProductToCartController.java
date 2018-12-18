package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("positions")
@Controller
public class AddProductToCartController {
    @Autowired
    private ProductRepository productRepository;
    long quantity;


    @RequestMapping(value = "/addProductToCart", method = RequestMethod.POST)
    public String addProductToCart(@RequestParam("productId") long productId, @RequestParam("quantity") String quantityString, HttpSession httpSession) {
        try {
            quantity = Long.parseLong(quantityString);
        } catch (NumberFormatException ex) {
            return "redirect:home";
        }
        Product product = productRepository.findById(productId).get();
        Map<Long, Pair<Product, Long>> positions = (Map<Long, Pair<Product, Long>>) httpSession.getAttribute("positions");
        if (positions == null) {
            positions = new HashMap<>();
        }
        Pair<Product, Long> productWithQuantity = positions.get(productId);
        if (productWithQuantity != null) {
            quantity = quantity + productWithQuantity.getSecond();
        }
        positions.put(product.getId(), Pair.of(product, quantity));

        httpSession.setAttribute("positions", positions);
        return "redirect:/";
    }
}
