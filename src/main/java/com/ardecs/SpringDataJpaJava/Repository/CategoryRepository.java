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
 *
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
    @Query(("SELECT c from Category c where c.name like %:categoryNamePart% order by c.name "))
    List<Category> findByCategoryNamePart(@Param(value = "categoryNamePart") String name);
}
