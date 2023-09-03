package com.karimerri.aladin_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Address;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.AddressService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping(path = "/address/new", consumes = "application/json")
	public OperationResponse createAddress(@RequestBody Address address) {

		System.out.println(address.toString());

		final OperationResponse resp = new OperationResponse();
		final Address persistedAddress = addressService.createAddress(address);

		if (persistedAddress == null) {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add Address - Address allready exist ");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Created new Address with id : {} and name : {}" + persistedAddress.getId()
					+ persistedAddress.getPostalCode() + "info Address created successfully");
		}

		return resp;
	}

	@GetMapping(path = "/address/{id}")
	public Address getAddressById(@PathVariable Integer id) {
		return addressService.getAddressById(id);
	}

}
