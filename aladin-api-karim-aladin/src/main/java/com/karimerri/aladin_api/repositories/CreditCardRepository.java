package com.karimerri.aladin_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karimerri.aladin_api.entities.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

	@Query("select c from CreditCard c where c.customer.id=:id")
	List<CreditCard> getCreditCardByCustomerId(Integer id);

	@Query("select c from CreditCard c where c.isActive=:isActive")
	CreditCard getCreditCardByActiveCard(Boolean isActive);
}
