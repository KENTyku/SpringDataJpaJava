package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.TreeMap;

@SessionAttributes("positions")
@Controller
public class EditCartProduct {
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
    private OrderPositionId id;
    @Autowired
    private ReportRepository reportRepository;
    final Random random = new Random();

    @RequestMapping(value = "/editCartProduct", method = RequestMethod.POST)
    public String deleteCartProduct(@RequestParam("productId") long id,
                                    @RequestParam("quantity") long quantity,
                                    @ModelAttribute("positions")TreeMap<Long,Position> positions,
                                    HttpSession httpSession) {
        Position position=positions.get(id);
        position.setQuantity(quantity);
        positions.put(id,position);
        httpSession.setAttribute("positions",positions);
        return "redirect:cart";
    }
}
