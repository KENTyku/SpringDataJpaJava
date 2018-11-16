/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(("SELECT p from Product p where p.category=:category and p.name like %:productNamePart% order by p.name desc "))
    List<Product> findByCategoryAndProductNamePart(@Param(value = "category") Category category, @Param(value = "productNamePart") String name);

    @Query(("SELECT p from Product p where p.name like %:productNamePart% order by p.name desc "))
    List<Product> findByProductNamePart( @Param(value = "productNamePart") String name);



}
