package com.ardecs.SpringDataJpaJava.Repository.specification;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import org.springframework.data.jpa.domain.Specification;
import sun.misc.Cleaner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClientSpecificaton {
    public static Specification<Client> clientFindByName(final String name) {
        return new Specification<Client>() {
            @Override
            public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), name);
            }
        };
    }
    public static Specification<Product> productFindByCountry(final String country) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("country"), country);
            }
        };
    }
}
