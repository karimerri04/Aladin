package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.karimerri.aladin_api.entities.Item;

public interface OrderItemRepository extends JpaRepository<Item, Integer> {

	@Query("select o from OrderItem o where o.product.id=:id")
	Item findOrderItemByProductId(Integer id);

	@Modifying
	@Query(value = "truncate table OrderItem", nativeQuery = true)
	void truncateOrderItemsTable();
}
