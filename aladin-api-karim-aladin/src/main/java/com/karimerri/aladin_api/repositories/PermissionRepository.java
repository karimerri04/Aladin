/**
 *
 */
package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
