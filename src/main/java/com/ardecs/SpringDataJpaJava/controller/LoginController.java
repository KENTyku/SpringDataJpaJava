package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    /*@Autowired
    private ProductRepository productRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String addClientAccount(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            Model model
    ) {
        if (login.isEmpty() || password.isEmpty()) {
            model.addAttribute("messageEmpty", "Поля не могут быть пустыми");
            return "loginPage";
        }
        if (!clientRepository.existsById(login)) {
            model.addAttribute("messageLogin", "Нет такого логина");
            return "loginPage";
        }
        Client client=clientRepository.findById(login).get();


        if (!passwordEncoder.matches(password,client.getPassword())) {
            model.addAttribute("messagePassword", "Неверный пароль.");
            return "loginPage";
        }
        System.out.println("LOGIN");
//        Client client = new Client(login, passwordEncoder.encode(password));
//        clientRepository.save(client);
        return "redirect:/";
    }*/
//TODO: This stub for use embedded Spring security login controller. Change it.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
