package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.TreeMap;

@SessionAttributes("positions")
@Controller
public class DeleteCartProduct {
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

    @RequestMapping(value = "/deleteCartProduct", method = RequestMethod.GET)
    public String deleteCartProduct(@RequestParam("productId") long id,
                                    @ModelAttribute("positions")TreeMap<Long,Position> positions,
                                    HttpSession httpSession) {
        System.out.println("TESTTTTTTTTTTTTTT"+positions.size());
        positions.remove(id);
        httpSession.setAttribute("positions",positions);
        return "redirect:cart";
    }
}
