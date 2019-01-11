package com.ardecs.SpringDataJpaJava.controller;

import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = {"/clients"}, method = RequestMethod.GET)
    public String showClients(Model model) {
        List<Client> clientList = (ArrayList<Client>) clientRepository.findAll();
        model.addAttribute(clientList);
        return "clients";
    }
}
