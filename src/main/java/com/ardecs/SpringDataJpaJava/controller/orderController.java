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
//                                  OrderPosition orderPosition,
                                  ArrayList<Product> productList,

//                                  OrderPositionId orderPositionId,
//                                  Product product,
                                  Model model) {


        productList = (ArrayList<Product>) productRepository.findAll();
        model.addAttribute(productList);
//        model.addAttribute(orderPositionId);
//        model.addAttribute(product);
//        model.addAttribute(client);
//        model.addAttribute(order);
        return "productListForOrder";
//        return "productList";
    }

    @RequestMapping(value = "/listOrder", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("orderModel") OrderModel orderModel, Order order, Model model) {

        if (orderModel.getClient() == null) {
            Client client = new Client("Yuri", "9051111111");
            orderModel.setClient(client);
            clientRepository.save(client);
        }
        if (orderModel.getOrder() == null) {
            LocalDateTime date;
            date = LocalDateTime.now();
            order = new Order(date, orderModel.getClient());
            orderModel.setOrder(order);
        }
        Optional<Product> productOptional = productRepository.findById(orderModel.getIdProduct());
        Product product = productOptional.get();
        OrderPositionId id = new OrderPositionId(order, product);
        OrderPosition orderPosition = new OrderPosition(id, orderModel.getQuantity());

        List<OrderPosition> list = orderModel.getList();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(orderPosition);
        orderModel.setList(list);


        order.setOrderPositions(list);
        orderRepository.save(order);
//        Long idOrder = order.getId();

        return "listOrder";
    }

}

class OrderModel {
    private long idProduct;
    private long quantity;
    private Client client;
    private Order order;
    private List<OrderPosition> list;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderPosition> getList() {
        return list;
    }

    public void setList(List<OrderPosition> list) {
        this.list = list;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}