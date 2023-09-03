
package com.karimerri.aladin_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karimerri.aladin_api.entities.Customer;
import com.karimerri.aladin_api.entities.Order;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email=:email")
	Customer findCustomerByEmail(String email);

	@Query("select o from Order o where o.customer.email=?1")
	List<Order> getCustomerOrders(String email);

}
