package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.*;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@SessionAttributes("positions")
@Controller
public class SaveOrder {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
    public String savaOrder(@ModelAttribute("positions") TreeMap<Product, Long> positions, SessionStatus sessionStatus) {
        Client client = clientRepository.findByName("Yuri");
        LocalDateTime date;
        date = LocalDateTime.now();
        Order order = new Order(date, client);
        List<OrderPosition> list = new ArrayList<>();
        if (positions.isEmpty()) return "redirect:cart";
        for (Map.Entry<Product, Long> position : positions.entrySet()) {
            Product product = position.getKey();
            long quantity = position.getValue();
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
