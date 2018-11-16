/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
    @Query(("SELECT p from Product p where p.category=?1 and p.name like ?2% order by p.name desc "))
    List<Product> findByCategoryAndNameLike(Category category, String name);
//    Optional<Country> findById(Long id);




}
