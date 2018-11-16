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
//@Component
@Entity
public class Client {

    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String telefonNumber;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Order> orders;

    public Client() {
    }

    public Client(String name, String telefonNumber) {
        this.name = name;
        this.telefonNumber = telefonNumber;
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



    public String getTelefonNumber() {
        return telefonNumber;
    }

    public void setTelefonNumber(String telefonNumber) {
        this.telefonNumber = telefonNumber;
    }

//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
    @Override
    public String toString() {

        return id + " " + name+" "+telefonNumber;
    }
}
