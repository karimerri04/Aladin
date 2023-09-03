/**
 *
 */
package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.entities.Customer;
import com.karimerri.aladin_api.entities.Order;
import com.karimerri.aladin_api.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}

	public Customer getCustomerById(Integer id) {
		return customerRepository.findById(id).get();
	}

	public List<Order> getCustomerOrders(String email) {
		return customerRepository.getCustomerOrders(email);
	}

}
