package com.karimerri.aladin_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.Address;
import com.karimerri.aladin_api.repositories.AddressRepository;

@Service
@Transactional
public class AddressService {

	private static final AlaDinLogger logger = AlaDinLogger.getLogger(AddressService.class);

	@Autowired
	AddressRepository addressRepository;

	public Address createAddress(Address address) {

		final Address savedAddress = addressRepository.save(address);
		logger.info("New Address created. Addres zipCoee : {}", savedAddress.getPostalCode());
		return savedAddress;
	}

	public Address getAddressById(Integer id) {
		return addressRepository.findById(id).get();
	}
}
