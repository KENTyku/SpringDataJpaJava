package com.ardecs.SpringDataJpaJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping({"/createProduct"})
public class editController {


    @RequestMapping(value = "/createProduct", method = RequestMethod.GET, params = "new")
    // Обрабатывать запросы на получение  формы по GET запросу формата: URL/createProduct?new
    public String createProduct(@ModelAttribute("product") Product product) {
//    public String createProduct(@ModelAttribute("product") Product product ,Model model) {
//        product=new Product();
//        model.addAttribute(product);

        return "editProduct"; // Вернуть имя представления
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String saveProduct(Product product, Model model) {
//    public String saveProduct() {
//        if (bindingResult.hasErrors()) {
//// Проверка ошибок
//            return "editProduct";
//        }

//        Обрабатываем результаты

        String name = product.getName();
        System.out.println(name);
        model.addAttribute(product);


//                return "home"; // Переадресовать
// Сохранить объект Spitter
//        spitterService.saveSpitter(spitter);

//        return "redirect:/createProduct/" + spitter.getUsername(); // Переадресовать
        return "productList";
// после запроса POST
    }
}