package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jury
 */

@Entity
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private LocalDateTime date;
//    private String date;
    @OneToMany(mappedBy = "id.order", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<OrderPosition> orderPositions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Order() {
    }

    public Order(@NotNull LocalDateTime date, Client client) {
        this.date = date;
        this.client = client;
    }

    public Order(@NotNull LocalDateTime date, List<OrderPosition> orderPositions, Client client) {
        this.date = date;
        this.orderPositions = orderPositions;
        this.client = client;
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
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {

        return id + " " + date + " " + client;
    }


    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}