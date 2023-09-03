/**
 *
 */
package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category getByName(String name);

}
