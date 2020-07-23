package com.ardecs.SpringDataJpaJava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//Чтобы исключить источник данных и гибернацию JPA auto-configuration, используйте:
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SpringDataJpaJava {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaJava.class, args);
    }
}
