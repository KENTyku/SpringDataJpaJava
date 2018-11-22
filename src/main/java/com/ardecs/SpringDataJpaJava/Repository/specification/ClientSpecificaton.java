package com.ardecs.SpringDataJpaJava.Repository.specification;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClientSpecificaton {
    public static Specification<Client> clientFindByName(final String name, final String phoneNumber) {//доделать спецификацию чтобы был поис по двум полям формы
        return new Specification<Client>() {
            @Override
            public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (name != null) {
                    criteriaBuilder.like(root.get("name"), name);
                }
                if (phoneNumber) {
                    criteriaBuilder.and(equals(root.get("phoneNumber"), phoneNumber));
                }
                return criteriaBuilder;
            }
        };
    }
    public static Specification<Client> findByPhoneNumber(final String phoneNumber) {
        return new Specification<Client>() {
            @Override
            public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
            }
        };
    }
}
