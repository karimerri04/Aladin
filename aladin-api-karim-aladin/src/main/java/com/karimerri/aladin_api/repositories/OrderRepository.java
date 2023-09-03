/**
 *
 */
package com.karimerri.aladin_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karimerri.aladin_api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o where o.customer.id=:id")
	List<Order> findByCustomerOrders(Integer id);

	Order findByOrderNumber(String id);

	/*
	 * @Query("select o from Order o where o.status=:statut") List<Order>
	 * getOrdersByStatut(OrderStatus new1);
	 */

}
