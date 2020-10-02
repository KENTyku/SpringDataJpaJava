package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Product;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model, HttpSession httpSession) {
        Map<Long, Pair<Product, Long>> positions = (Map<Long, Pair<Product, Long>>) httpSession.getAttribute("positions");
        if (positions == null) {
            positions = new HashMap<>();
        }
        model.addAttribute("positionList",positions);
        if (positions.size()!=0) {
            float totalCost = 0;
            Set<Map.Entry<Long, Pair<Product, Long>>> setList = positions.entrySet();
            for (Map.Entry<Long, Pair<Product, Long>> item : setList) {
                totalCost = totalCost + item.getValue().getFirst().getPrice() * item.getValue().getSecond();
            }
            Cost cost=new Cost();
            cost.setCost(totalCost);
            model.addAttribute(cost);
        }
        return "cart";
    }
}
