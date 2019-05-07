package com.ardecs.SpringDataJpaJava.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;

@Controller
public class OrdersController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = {"/orders"}, method = RequestMethod.GET)
    public String showOrders(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String clientLogin = user.getUsername();
        Client client = clientRepository.findByLogin(clientLogin);
        List<Order> orderList = orderRepository.findAllByClientOrderByDateDesc(client);
        model.addAttribute(orderList);
        HashMap ordersMap = new HashMap();
        float coastOrder = 0;
        for (Order order : orderList) {
            for (OrderPosition position : order.getOrderPositions()) {
                coastOrder = coastOrder + position.getId().getProduct().getPrice() * position.getQuantity();
            }
            ordersMap.put(order, coastOrder);

        }
        model.addAttribute("ordersMap", ordersMap);
        return "orders";
    }
}
