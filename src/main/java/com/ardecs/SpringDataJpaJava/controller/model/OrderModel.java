package com.ardecs.SpringDataJpaJava.controller.model;

import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;

public class OrderModel {
    private long orderCheck;
    private long idProduct;
    private long quantity;
    private Client client;
    private Order order;
    private List<OrderPosition> list;
    private long orderId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderPosition> getList() {
        return list;
    }

    public void setList(List<OrderPosition> list) {
        this.list = list;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getOrderCheck() {
        return orderCheck;
    }

    public void setOrderCheck(long orderCheck) {
        this.orderCheck = orderCheck;
    }
}