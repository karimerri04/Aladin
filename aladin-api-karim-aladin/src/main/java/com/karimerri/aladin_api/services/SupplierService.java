package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.Supplier;
import com.karimerri.aladin_api.repositories.SupplierRepository;

@Service
@Transactional
public class SupplierService {

	private static final AlaDinLogger logger = AlaDinLogger.getLogger(SupplierService.class);

	@Autowired
	SupplierRepository supplierRepository;

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public Supplier getSupplierById(Integer id) {
		return supplierRepository.findById(id).get();
	}
}
