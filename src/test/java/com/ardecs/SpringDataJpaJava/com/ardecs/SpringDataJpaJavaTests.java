package com.ardecs.SpringDataJpaJava.com.ardecs;

import com.ardecs.SpringDataJpaJava.config.ConfigTest;
import com.ardecs.SpringDataJpaJava.Entity.*;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.ardecs.SpringDataJpaJava.Repository.specification.ProductSpecificaton.productFindByName;

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


        //Sign in
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        client = clientOptional.get();

        //create order
        LocalDateTime date;
        date = LocalDateTime.now();
        System.out.println(date.toString());
        Order order = new Order(date, client);


        //find Products
        String name = "Sony";
        //select Category
        List<Category> categoriesList = (ArrayList<Category>) categoryRepository.findAll();
        for (Category item : categoriesList) {
            System.out.println(item.getCategoryName());
        }
        //doing request
        List<Product> products = productRepository.findByCategoryAndProductNamePart(categoriesList.get(0), name);
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
        List<Order> ordersList = orderRepository.findAllOrderByClient_IdLikeOrderByIdAsc(idClient);
        for (Order item : ordersList) {
            System.out.println(item.getId());

        }
        Page<Product> page = productRepository.findAll(new PageRequest(0, 5, new Sort(new Sort.Order(Sort.Direction.ASC, "price"))));
        products = page.getContent();
        //show results
        System.out.println("*****************");
        for (Product product : products) {
            System.out.println(product);
        }
        productRepository.findAll(productFindByName("Sony")).forEach(System.out::println);

    }

}
