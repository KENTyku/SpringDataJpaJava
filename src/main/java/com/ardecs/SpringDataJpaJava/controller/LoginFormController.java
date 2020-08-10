package com.ardecs.SpringDataJpaJava.controller;

import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginFormController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = {"/loginPage"}, method = RequestMethod.GET)
    //TODO: This method isn't using now, because we have Spring security embedded  login controller.  Change it.
    public String showLoginForm() {
        return "login";
    }
}
