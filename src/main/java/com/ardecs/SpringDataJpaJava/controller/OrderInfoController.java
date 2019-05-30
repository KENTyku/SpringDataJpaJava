package com.ardecs.SpringDataJpaJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;

@Controller
public class OrderInfoController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = {"/orderInfo"}, method = RequestMethod.GET)
    public String showOrders(@RequestParam("id") Long orderId, Model model) {
        Order order = orderRepository.findById(orderId).get();

        if (order.getOrderPositions() == null || order.getOrderPositions().isEmpty()) {
            return "redirect:orders";
        }
        float cost=0;
        for (OrderPosition orderPosition : order.getOrderPositions()) {
            cost = cost+orderPosition.getId().getProduct().getPrice() * orderPosition.getQuantity();
        }
        model.addAttribute(order.getOrderPositions());
//        Float fl=Float.valueOf(cost);

        model.addAttribute("cost", cost);
        return "orderInfo";
    }
}
