package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author jury
 */
@Entity
public class Country {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column(unique = true)
    @Size(min =1,max = 20,message = "Countryname must be between 2 and 20 characters")
//    @Pattern(regexp = "[a-zA-Z]+")
    private String name;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return id + " " + name;
    }

}