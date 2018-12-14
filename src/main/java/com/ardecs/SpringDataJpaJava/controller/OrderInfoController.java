package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderInfoController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = {"/orderInfo"}, method = RequestMethod.GET)
    public String showOrders(@RequestParam("id") long orderId, Model model) {
        Order order = orderRepository.getOrderWithPositions(orderId);
        if (order == null) {
            return "redirect:orders";
        }

        model.addAttribute(order.getOrderPositions());
        return "orderInfo";
    }
}
