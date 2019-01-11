package com.ardecs.SpringDataJpaJava.config;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import com.ardecs.SpringDataJpaJava.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class OnApplicationLoad {
    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @PostConstruct//выполняет этот метод после инициализации всех бинов
    public void onApplicationLoad() {
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category("Computer");
        categoryList.add(category);
        category = new Category("Mobile");
        categoryList.add(category);
        category = new Category("Audio");
        categoryList.add(category);
        categoryRepository.saveAll(categoryList);
        List<Country> countryList = new ArrayList<>();
        Country country = new Country("USA");
        countryList.add(country);
        country = new Country("Russia");
        countryList.add(country);
        country = new Country("Japan");
        countryList.add(country);
        countryRepository.saveAll(countryList);
        List<Client> clientList = new ArrayList<>();
        Client client = new Client("Yuri", "9051111111", passwordEncoder.encode("1234"));
        client.setRole(Constants.ADMIN_ROLE);
        clientList.add(client);
        client = new Client("Bob", "9052222222", passwordEncoder.encode("1234"));
        clientList.add(client);
        client = new Client("Den", "9053333333", passwordEncoder.encode("1234"));
        clientList.add(client);
        clientRepository.saveAll(clientList);
        for (int i = 0; i < 20; i++) {
            float price = random.nextInt(100) + 1;
//            String name = String.valueOf(random.nextInt(10000000) + 1);
            String name = java.util.UUID.randomUUID().toString();
//            String comment = String.valueOf(random.nextInt(10000000) + 1);
            String comment = java.util.UUID.randomUUID().toString();
            long idCountry = random.nextInt(3) + 4;
            long idCategory = random.nextInt(3) + 1;
            Product product = new Product(price, name, comment, countryRepository.findById(idCountry).get(), categoryRepository.findById(idCategory).get());
            productRepository.save(product);
        }
    }
}
