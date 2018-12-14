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
import java.util.Map;

@SessionAttributes("positions")
@Controller
public class EditCartProduct {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/editCartProduct", method = RequestMethod.POST)
    public String deleteCartProduct(@RequestParam("productId") long productId,
                                    @RequestParam("quantity") long quantity,
                                    HttpSession httpSession) {
        Map<Long, Pair<Product, Long>> positions = (Map<Long, Pair<Product, Long>>) httpSession.getAttribute("positions");
        if (positions == null) {
            return "redirect:cart";
        }
        Product product = positions.get(productId).getFirst();
        positions.put(product.getId(), Pair.of(product, quantity));
        httpSession.setAttribute("positions", positions);
        return "redirect:cart";
    }
}
