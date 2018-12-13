package com.ardecs.SpringDataJpaJava.config;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OnApplicationLoad {
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
        Client client = new Client("Yuri", "9051111111");
        clientList.add(client);
        client = new Client("Bob", "9052222222");
        clientList.add(client);
        client = new Client("Den", "9053333333");
        clientList.add(client);
        clientRepository.saveAll(clientList);
    }
}
