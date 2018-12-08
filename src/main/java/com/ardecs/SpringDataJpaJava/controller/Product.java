package com.ardecs.SpringDataJpaJava.controller;

public class Product {
    long id;
    String name;

    public Product(long id, String name, String comment, double price, String cateroty, String county) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.price = price;
        this.cateroty = cateroty;
        this.county = county;
    }

    public Product() {
    }

    String comment;
    double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCateroty() {
        return cateroty;
    }

    public void setCateroty(String cateroty) {
        this.cateroty = cateroty;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    String cateroty;
    String county;

}
