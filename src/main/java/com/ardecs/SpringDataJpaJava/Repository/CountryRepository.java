/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByName(String name);

    @Query(("SELECT c from Country c where c.name like %:countryNamePart% order by c.name "))
    List<Country> findByCountryNamePart(@Param(value = "countryNamePart") String name);

    Boolean existsByName(String name);
}
