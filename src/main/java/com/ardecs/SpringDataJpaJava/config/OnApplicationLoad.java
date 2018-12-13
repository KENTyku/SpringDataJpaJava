package com.ardecs.SpringDataJpaJava.config;

import javax.annotation.PostConstruct;

import com.ardecs.SpringDataJpaJava.Entity.Category;
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
    }
}
