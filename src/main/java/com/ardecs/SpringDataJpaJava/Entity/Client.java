package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author jury
 */
@Entity
public class Client {
    @Id
    private String login;
    @NotNull
    private String name;
    //    @NotNull
    private String phoneNumber;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<Order> orders;
    @NotNull
    private String password;
    private String role;

    public Client() {
    }

    public Client(String login, String name, String phoneNumber, String password) {
        this.login = login;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Client(String login, String phoneNumber, String password) {
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }


    /**
     * @return the country_name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {

        return login + " " + name + " " + phoneNumber;
    }
}
