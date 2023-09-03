/**
 *
 */
package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karimerri.aladin_api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	@Query("select u from User u where u.phoneNum=:phoneNum")
	User getUserByOpt(Integer phoneNum);

}
