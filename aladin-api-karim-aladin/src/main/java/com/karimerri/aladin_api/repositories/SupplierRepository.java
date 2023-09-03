package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

	/*
	 * @Query("select o from Category o where o.store.id=:id") Store
	 * getStoreByCategory(Integer id);
	 */

}