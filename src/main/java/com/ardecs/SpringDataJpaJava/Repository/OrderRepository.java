/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface OrderRepository extends CrudRepository<Order, Long> {
//    @Query("SELECT o from Order o where o.client.id=?1 ")
//    List<Order> findAllOrdersClient(long clientId);

    List<Order> findAllOrderByClient_IdLikeOrderByIdAsc(Long id);


}
