package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author jury
 */
@Entity
public class OrderPosition {
    @EmbeddedId
    private OrderPositionId id;
    private long quantity;

    public OrderPosition() {
    }

    public OrderPosition(OrderPositionId id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id=" +
                ", quantity=" + quantity +
                '}';
    }

    /**
     * @return the id
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * @param id the id to set
     */
    public void setQuantity(long id) {
        this.quantity = id;
    }

}