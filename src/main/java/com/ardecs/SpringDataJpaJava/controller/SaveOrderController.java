package com.ardecs.SpringDataJpaJava.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;

@Controller
public class SaveOrderController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
    public String saveOrder(SessionStatus sessionStatus, HttpSession httpSession) {
        Map<Long, Pair<Product, Long>> positions = (Map<Long, Pair<Product, Long>>) httpSession.getAttribute("positions");
        if (positions == null) {
            return "redirect:cart";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String clientLogin = user.getUsername();
        Client client = clientRepository.findByLogin(clientLogin);
        Order order = new Order(LocalDateTime.now(), client);
        List<OrderPosition> list = new ArrayList<>();
        if (positions == null || positions.isEmpty()) return "redirect:cart";
        for (Map.Entry<Long, Pair<Product, Long>> position : positions.entrySet()) {
            Product product = position.getValue().getFirst();
            long quantity = position.getValue().getSecond();
            OrderPositionId id = new OrderPositionId(order, product);
            OrderPosition orderPosition = new OrderPosition(id, quantity);
            list.add(orderPosition);
        }
        order.setOrderPositions(list);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:orders";
    }
}
