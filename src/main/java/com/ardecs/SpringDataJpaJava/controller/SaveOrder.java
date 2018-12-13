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
    private CountryRepository countryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderPositionRepository orderPositionRepository;
    @Autowired
    private ReportRepository reportRepository;
    final Random random = new Random();

    @RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
    public String deleteCartProduct(@ModelAttribute("positions") TreeMap<Long, Position> positions, SessionStatus sessionStatus) {
        Client client = clientRepository.findByName("Yuri");
        LocalDateTime date;
        date = LocalDateTime.now();
        Order order = new Order(date, client);
        List<OrderPosition> list = new ArrayList<>();


        for (Map.Entry<Long, Position> position : positions.entrySet()) {
            Product product = position.getValue().getProduct();
            long quantity = position.getValue().getQuantity();
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
