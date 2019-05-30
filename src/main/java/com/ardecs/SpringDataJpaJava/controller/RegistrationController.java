package com.ardecs.SpringDataJpaJava.controller;

import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = {"/registrationClient"}, method = RequestMethod.POST)
    public String addClientAccount(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("passwordConfirm") String passwordConfirm,
            Model model
    ) {
        boolean check = true;
        if(login.isEmpty()||password.isEmpty()||passwordConfirm.isEmpty()){
            model.addAttribute("messageEmpty", "Поля не могут быть пустыми");
            return "registration";
        }if(login.length()<4||password.length()<4||passwordConfirm.length()<4){
            model.addAttribute("messageShort", "Значения полей должны иметь длину более 3 символов");
            return "registration";
        }
        if (clientRepository.existsById(login)) {
            model.addAttribute("messageLogin", "Логин занят, введите другой");
            check = false;
        }
        if (!password.equals(passwordConfirm)){
            model.addAttribute("messagePassword", "Пароли не совпадают, введите пароль и подтверждение повторно");
            check = false;
        }

        if (!check) {
            return "registration";
        }
        Client client = new Client(login, passwordEncoder.encode(password));
        clientRepository.save(client);
        return "redirect:/";
    }
}
