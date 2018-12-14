package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.*;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SessionAttributes("positions")
@Controller
public class SaveOrder {
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

        Client client = clientRepository.findByName("Yuri");
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
