package com.ardecs.SpringDataJpaJava.Entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author jury
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    private String categoryName;

    public Category() {
    }

    public Category(String categoryName) {

        this.categoryName = categoryName;
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
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param catgory_name the catgory_name to set
     */
    public void setCategoryName(String catgory_name) {
        this.categoryName = catgory_name;
    }

    @Override
    public String toString() {

        return id + " " + categoryName;
    }

}
