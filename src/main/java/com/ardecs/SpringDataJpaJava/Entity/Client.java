package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author jury
 */
@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<Order> orders;

    public Client() {
    }

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {

        return id + " " + name + " " + phoneNumber;
    }
}
