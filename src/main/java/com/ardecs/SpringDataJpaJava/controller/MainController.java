package com.ardecs.SpringDataJpaJava.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/", "/home"}) // Обрабатывать запросы на получение  главной страницы
    // @RequestMapping(value = "/", method = RequestMethod.GET) // Обрабатывать запросы на получение  главной страницы
    public String showHomePage(Map<String, Object> model) {
        model.put("Description", "Выберите действие:"); //Добавить сообщения в модель
        return "home"; // Вернуть имя представления
    }
}
