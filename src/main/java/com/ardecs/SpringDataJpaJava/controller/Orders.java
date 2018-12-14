package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Orders {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = {"/orders"}, method = RequestMethod.GET)
    public String showOrders(Model model) {
        long clientId = clientRepository.findByName("Yuri").getId();
        List<Order> orderList = orderRepository.findAllOrderByClient_IdLikeOrderByIdAsc(clientId);
        model.addAttribute(orderList);
        return "Orders";
    }
}
