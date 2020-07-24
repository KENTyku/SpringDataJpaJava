package com.ardecs.SpringDataJpaJava.com.ardecs;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Entity.Report;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static com.ardecs.SpringDataJpaJava.Repository.specification.ClientSpecificaton.clientFindByCriteries;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaJavaTests {
    private static final String LOGIN = "Bob";

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

    @Before

    public void initDataBase() {
        if (!categoryRepository.existsByName("Computer")) {
            Category category = new Category("Computer");
            categoryRepository.save(category);
        }
        if (!categoryRepository.existsByName("Mobile")) {
            Category category = new Category("Mobile");
            categoryRepository.save(category);
        }
        if (!categoryRepository.existsByName("Audio")) {
            Category category = new Category("Audio");
            categoryRepository.save(category);
        }
        if (!countryRepository.existsByName("USA")) {
            Country country = new Country("USA");
            countryRepository.save(country);
        }
        if (!countryRepository.existsByName("Russia")) {
            Country country = new Country("Russia");
            countryRepository.save(country);
        }
        if (!countryRepository.existsByName("Japan")) {
            Country country = new Country("Japan");
            countryRepository.save(country);
        }

        if (!productRepository.existsByName("IPhone")) {
            Product product = new Product(1000, "IPhone", "mobile comment IPhone",
                    countryRepository.findByName("USA"), categoryRepository.findByName("Mobile"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Sony")) {
            Product product = new Product(500, "Sony", "mobile comment Sony",
                    countryRepository.findByName("Japan"), categoryRepository.findByName("Mobile"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Sony next")) {
            Product product = new Product(550, "Sony next", "mobile comment Sony next",
                    countryRepository.findByName("Japan"), categoryRepository.findByName("Mobile"));
            productRepository.save(product);
        }
        if (!clientRepository.existsByName(LOGIN)) {
            Client client = new Client(LOGIN, "Bobik", "9052222222", "1234");
            clientRepository.save(client);
        }
    }

    @Test

    public void clientRegistration() {
        String login = "Yuri";
        String password = "9051111111";
        clientRepository.save(new Client(login,"Yuri","9051111111", password));
        Client client = clientRepository.findByLogin(login);
        assertEquals(password, client.getPassword());
    }

    @Test
    public void clientSignIn() {
        Client client = clientRepository.findByLogin(LOGIN);
        assertEquals("Bobik", client.getName());
        assertEquals("9052222222", client.getPhoneNumber());
    }

    @Test
    public void addOrder() {
        Client client = clientRepository.findByLogin(LOGIN);
        //create order
        LocalDateTime date;
        date = LocalDateTime.now();
        Order order = new Order(date, client);
        //find Products
        String namePart = "Sony";
        //select Category
        List<Category> categoriesList = (ArrayList<Category>) categoryRepository.findAll();
        for (Category item : categoriesList) {
            System.out.println(item.getCategoryName());
        }
        //doing request
        List<Product> products = productRepository.findByCategoryAndProductNamePart(categoriesList.get(1), namePart);
        //show results
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

        assertEquals(2, orderRepository.getOrderWithPositionsByClient(client).size());
    }


    @Test
    public void pagingAllProducts() {
        Page<Product> page = productRepository.findAll(PageRequest.of(
                1, 2, Sort.by(new Sort.Order(Sort.Direction.ASC, "price"))
                )
        );
        assertEquals(2, page.getContent().size());
    }

    @Test
    public void searchClientsWithCriteries() {
        List<Client> clientList = clientRepository
                .findAll(clientFindByCriteries("Yuri", "9051111111"));
        assertEquals(1, clientList.size());
    }


    @Test
    public void addToReport() {
        Category category = new Category("Books");
        categoryRepository.save(category);
        categoryRepository.delete(category);
        Iterable<Report> iterable = reportRepository.findAll();
        long count = StreamSupport.stream(iterable.spliterator(), false)
                .filter(r -> r.getName().contains("Category"))
                .count();
        assertEquals(2, count);
    }
}


