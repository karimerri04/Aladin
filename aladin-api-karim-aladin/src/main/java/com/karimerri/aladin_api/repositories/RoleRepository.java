/**
 *
 */
package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
