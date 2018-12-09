package com.ardecs.SpringDataJpaJava.com.ardecs;

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
import com.ardecs.SpringDataJpaJava.config.ConfigApp;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.ardecs.SpringDataJpaJava.Repository.specification.ClientSpecificaton.clientFindByCriteries;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)//специальный класс JUnit,требуется для поддержки контекста в JUnit
@ContextConfiguration(classes = ConfigApp.class)
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
        if (!clientRepository.existsByName("Bob")) {
            Client client = new Client("Bob", "9052222222");
            clientRepository.save(client);
        }
    }

    @Test

    public void clientRegistration() {
        Client client = new Client("Yuri", "9051111111");
        clientRepository.save(client);
        Long idClient = client.getId();
        assertEquals(Long.valueOf(23), idClient);

    }

    @Test
    public void clientSignIn() {

        Optional<Client> clientOptional = clientRepository.findById((long) 19);
        Client client = clientOptional.get();
        assertEquals("Bob", client.getName());
        assertEquals("9052222222", client.getPhoneNumber());
    }


    @Test
    public void addOrder() {
        Optional<Client> clientOptional = clientRepository.findById((long) 19);
        Client client = clientOptional.get();
        Long idClient = client.getId();
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
        Long idOrder = order.getId();
        assertEquals(Long.valueOf(21), idOrder);
    }

    @Test
    public void showAllClientOrders() {
        Optional<Client> clientOptional = clientRepository.findById((long) 19);
        Client client = clientOptional.get();
        Long idClient = client.getId();
        List<Order> ordersList = orderRepository.findAllOrderByClient_IdLikeOrderByIdAsc(idClient);

        ArrayList<Long> listIdOrders = new ArrayList<>();
        for (Order item : ordersList) {
            listIdOrders.add(item.getId());
        }
        Long[] expecteds = {Long.valueOf(21)};
        Long[] actual = listIdOrders.toArray(new Long[listIdOrders.size()]);
        assertArrayEquals(expecteds, actual);
    }

    @Test
    public void pagingAllProducts() {
        Page<Product> page = productRepository.findAll(PageRequest.of(1, 2, Sort.by(new Sort.Order(Sort.Direction.ASC, "price"))));
        List<Product> products = page.getContent();
        ArrayList<Long> listIdProducts = new ArrayList<>();
        for (Product item : products) {
            listIdProducts.add(item.getId());
        }
        Long[] expecteds = {Long.valueOf(13)};
        Long[] actual = listIdProducts.toArray(new Long[listIdProducts.size()]);
        assertArrayEquals(expecteds, actual);
    }

    @Test
    public void searchClientsWithCriteries() {
        List<Client> clientList = clientRepository.findAll(clientFindByCriteries("Yuri", "9051111111"));
        ArrayList<Long> listIdClients = new ArrayList<>();
        for (Client item : clientList) {
            listIdClients.add(item.getId());
        }
        Long[] expecteds = {Long.valueOf(23)};
        Long[] actual = listIdClients.toArray(new Long[listIdClients.size()]);
        assertArrayEquals(expecteds, actual);
    }


    @Test
    public void addToReport() {
        Category category = new Category("Books");
        categoryRepository.save(category);
        categoryRepository.delete(category);
        long count = reportRepository.count();
        assertEquals(14, count);
    }
}


