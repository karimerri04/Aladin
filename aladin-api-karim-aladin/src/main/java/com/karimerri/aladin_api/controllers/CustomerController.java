package com.karimerri.aladin_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Customer;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.CustomerService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class CustomerController extends AlaDinAdminBaseController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/customer/new", consumes = "application/json")
	public OperationResponse createCustomer(@RequestBody Customer customer) {

		System.out.println(customer.toString());

		final OperationResponse resp = new OperationResponse();
		final Customer persistedCustomer = customerService.createCustomer(customer);

		if (persistedCustomer == null) {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add Customer - Customer allready exist ");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Created new Customer with id : {} and name : {}" + persistedCustomer.getId()
					+ persistedCustomer.getCreateDate() + "info Customer created successfully");
		}

		return resp;
	}

	@GetMapping(path = "/customers/email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return customerService.getCustomerByEmail(email);
	}

	@GetMapping(path = "/customers/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping(path = "/customers")
	public List<Customer> listCustomers() {
		return customerService.getAllCustomers();
	}
}
