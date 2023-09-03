package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.CreditCard;
import com.karimerri.aladin_api.repositories.CreditCardRepository;

@Service
@Transactional
public class CreditCardService {

	private static final AlaDinLogger logger = AlaDinLogger.getLogger(CreditCardService.class);

	@Autowired
	CreditCardRepository creditCardRepository;

	public CreditCard createCreditCard(CreditCard creditCard) {
		final CreditCard savedCreditCard = creditCardRepository.save(creditCard);
		logger.info("Container. CreditCard type : {}", savedCreditCard.getCcType());
		return savedCreditCard;
	}

	public List<CreditCard> getCreditCardByCustomerId(Integer id) {
		return creditCardRepository.getCreditCardByCustomerId(id);
	}

	public CreditCard getCreditCardById(Integer id) {
		return creditCardRepository.findById(id).get();
	}

	public CreditCard getCreditCardByActiveCard(Boolean isActive) {
		return creditCardRepository.getCreditCardByActiveCard(isActive);
	}

	
}
