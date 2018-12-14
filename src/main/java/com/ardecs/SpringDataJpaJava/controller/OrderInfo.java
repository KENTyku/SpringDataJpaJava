package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderInfo {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = {"/orderInfo"}, method = RequestMethod.GET)
    public String showOrders(@RequestParam("id") long id, Model model) {
        Order order = orderRepository.findById(id).get();
        List<OrderPosition> orderPositionList = order.getOrderPositions();
        for (OrderPosition orderPosition : orderPositionList) {
            long ProductId = orderPosition.getId().getProduct().getId();
            Product product = productRepository.findById(ProductId).get();
            OrderPositionId orderPositionId = orderPosition.getId();
            orderPositionId.setProduct(product);
            orderPosition.setId(orderPositionId);
        }
        model.addAttribute(orderPositionList);
        return "OrderInfo";
    }
}
