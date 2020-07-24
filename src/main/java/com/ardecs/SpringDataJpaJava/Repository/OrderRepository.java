/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Entity.Order;
import org.springframework.data.repository.query.Param;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByClientOrderByDateDesc(Client client);

    @Query("select o from Order o left join fetch o.orderPositions where o.client = :client")
    List<Order> getOrderWithPositionsByClient(@Param("client") Client client);

    @Query("select o from Order o left join fetch o.orderPositions where o.id = :orderId")
    Order getOrderWithPositions(@Param("orderId") Long orderId);
}
