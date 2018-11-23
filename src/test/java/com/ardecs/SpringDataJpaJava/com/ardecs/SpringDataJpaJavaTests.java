package com.ardecs.SpringDataJpaJava.com.ardecs;

import com.ardecs.SpringDataJpaJava.config.ConfigTest;
import com.ardecs.SpringDataJpaJava.Entity.*;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.junit.Before;
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
import static com.ardecs.SpringDataJpaJava.Repository.specification.ClientSpecificaton.*;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.springframework.data.jpa.domain.Specification.where;

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

    @Before
    //Create data
    public void initDataBase() {
        Category category = new Category("Computer");
        categoryRepository.save(category);
        category = new Category("Mobile");
        categoryRepository.save(category);
        category = new Category("Audio");
        categoryRepository.save(category);

        Country country = new Country("USA");
        countryRepository.save(country);
        country = new Country("Russia");
        countryRepository.save(country);
        country = new Country("Japan");
        countryRepository.save(country);

        Product product = new Product(1000, "IPhone", "mobile comment IPhone",
                countryRepository.findByName("USA"), categoryRepository.findByName("Mobile"));
        productRepository.save(product);
        product = new Product(500, "Sony", "mobile comment Sony",
                countryRepository.findByName("Japan"), categoryRepository.findByName("Mobile"));
        productRepository.save(product);
        product = new Product(550, "Sony next", "mobile comment Sony next",
                countryRepository.findByName("Japan"), categoryRepository.findByName("Mobile"));
        productRepository.save(product);
    }

    @Test
    public void clientRegistration() {
        Client client = new Client("Yuri", "9051111111");
        clientRepository.save(client);
        Long idClient = client.getId();
        assertTrue(!idClient.equals(null));
    }
    @Test
    public void clientSign() {


        //Sign in
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        client = clientOptional.get();

        //create order
        LocalDateTime date;
        date = LocalDateTime.now();
        System.out.println(date.toString());
        Order order = new Order(date, client);


        //find Products
        String namePart = "Sony";
        //select Category
        List<Category> categoriesList = (ArrayList<Category>) categoryRepository.findAll();
        System.out.println("*************************************");
        for (Category item : categoriesList) {
            System.out.println(item.getCategoryName());
        }
        //doing request
        List<Product> products = productRepository.findByCategoryAndProductNamePart(categoriesList.get(1), namePart);
        //show results
        System.out.println("*************************************");
        for (Product item : products) {
            System.out.println(item);
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
        Page<Product> page = productRepository.findAll(new PageRequest(0, 5, new Sort(new Sort.Order(Sort.Direction.ASC, "price"))));//заменить методы на неустаревающие
        products = page.getContent();
        //show results
        for (Product item : products) {
            System.out.println(item);
        }
        //Use Specification
        productRepository.findAll(productFindByName("Sony")).forEach(System.out::println);

        //Use Specification for any word part
        String wordPart = "Yuri";
        clientRepository.findAll(clientFindByCriteries("Yuri", "9058762476")).forEach(System.out::println);

        //Test Logging
        Category category = new Category("Books");
        categoryRepository.save(category);
        categoryRepository.delete(category);
    }

}


