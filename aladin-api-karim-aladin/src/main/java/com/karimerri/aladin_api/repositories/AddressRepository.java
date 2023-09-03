package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
