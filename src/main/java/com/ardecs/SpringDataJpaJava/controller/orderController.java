package com.ardecs.SpringDataJpaJava.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import com.ardecs.SpringDataJpaJava.controller.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class orderController {
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

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET, params = "newOrder")
    public String createOrderForm(@ModelAttribute("orderModel") OrderModel orderModel,
                                  ArrayList<Product> productList,
                                  Model model) {
        productList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productList);
        return "productListForOrder";
    }

    @RequestMapping(value = "/listOrder", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("orderModel") OrderModel orderModel, Model model) {
        Order order = null;
        List<OrderPosition> list;
        if (orderModel.getOrderId() == 0) {
            Client client = new Client("Yuri", "9051111111");
            orderModel.setClient(client);
            clientRepository.save(client);
            LocalDateTime date;
            date = LocalDateTime.now();
            order = new Order(date, orderModel.getClient());
            orderModel.setOrder(order);
        } else {
            order = orderRepository.findById(Long.valueOf(orderModel.getOrderId())).get();
        }
        Optional<Product> productOptional = productRepository.findById(orderModel.getIdProduct());
        Product product = productOptional.get();

        OrderPositionId id = new OrderPositionId(order, product);
        OrderPosition orderPosition = new OrderPosition(id, orderModel.getQuantity());
        if (orderModel.getOrderId() == 0) {
            list = new ArrayList<>();
            list.add(orderPosition);
            order.setOrderPositions(list);
            orderRepository.save(order);
        } else {
            orderPositionRepository.save(orderPosition);
            list = (List<OrderPosition>) orderPositionRepository.findAll();
        }
        model.addAttribute(list);
        model.addAttribute(order);
        return "listOrder";
    }

    @RequestMapping(value = "/addOrderItem", method = RequestMethod.POST)
    public String addOrderItem(@ModelAttribute("orderModel") OrderModel orderModel, Model model) {
        ArrayList<Product> productList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productList);
        return "productListForOrder";
    }


}

