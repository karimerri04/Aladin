
package com.karimerri.aladin_api.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.karimerri.aladin_api.entities.Property;

public interface PropertyRepository extends PagingAndSortingRepository<Property, Integer> {

	Optional<Property> findByName(String name);

}
