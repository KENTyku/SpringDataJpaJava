/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface ClientRepository extends CrudRepository<Client, String>, JpaSpecificationExecutor<Client> {
    Client findByName(String name);

    Boolean existsByName(String name);


}
