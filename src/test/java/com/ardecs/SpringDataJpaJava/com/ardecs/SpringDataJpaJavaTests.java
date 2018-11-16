package com.ardecs.SpringDataJpaJava.com.ardecs;

import com.ardecs.SpringDataJpaJava.config.ConfigTest;
import com.ardecs.SpringDataJpaJava.Entity.*;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//специальный класс JUnit,требуется для поддержки контекста в JUnit
@ContextConfiguration(classes = ConfigTest.class)
//указываем конфиг для работы автокофигурации контекста в тесте
public class SpringDataJpaJavaTests {
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

    @Test
    public void testCrud() {

        //registration
        Client client = new Client("Yuri", "9051111111");
        clientRepository.save(client);
        Long idClient = client.getId();
        System.out.println(idClient);
        client = null;

        //Sign in
        client = clientRepository.findById(idClient).get();

        //create order
        Date date = new Date();
        Order order = new Order(date.toString(), client);


        //find Products
        String name = "Sony";
        //select Category
        List<Category> categoriesList = (ArrayList<Category>) categoryRepository.findAll();
        for (Category item : categoriesList) {
            System.out.println(item.getCategoryName());
        }
        //doing request
        List<Product> products = productRepository.findByCategoryAndNameLike(categoriesList.get(1), name);
        //show results
        for (Product product : products) {
            System.out.println(product);
        }
        //select product and quantity
        id = new OrderPositionId(order, products.get(0));
        OrderPosition orderPosition = new OrderPosition(id, 5);
        List<OrderPosition> list = new ArrayList<>();
        list.add(orderPosition);

        //select product and quantity
        id = new OrderPositionId(order, products.get(1));
        orderPosition = new OrderPosition(id, 2);
        list.add(orderPosition);

        //add to order and save order
        order.setOrderPositions(list);
        orderRepository.save(order);

        //show all orders for client
        List<Order> ordersList = orderRepository.findAllOrder(idClient);
        for (Order item : ordersList) {
            System.out.println(item.getId());

        }

    }

}
