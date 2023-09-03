package com.karimerri.aladin_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.CreditCard;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.CreditCardService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@PostMapping(path = "/creditcard/new", consumes = "application/json")
	public OperationResponse createCreditCard(@RequestBody CreditCard creditCard) {

		System.out.println("The recieved CreditCard is:" + creditCard.toString());

		final OperationResponse resp = new OperationResponse();
		final CreditCard persistedCreditCard =

				creditCardService.createCreditCard(creditCard);

		if (persistedCreditCard == null) {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add CreditCard - CreditCard allready exist ");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Created new CreditCard with id : {} and name :" + persistedCreditCard.getCardHolderName()
					+ persistedCreditCard.getCcType() + "info CreditCard created successfully");
		}

		return resp;
	}

	@GetMapping(path = "/creditcard/customer/{id}")
	public List<CreditCard> getCreditCardByCustomerId(@PathVariable Integer id) {
		return creditCardService.getCreditCardByCustomerId(id);
	}

	@GetMapping(path = "/creditcard/active/{isActive}")
	public CreditCard getCreditCardByCustomerId(@PathVariable Boolean isActive) {
		return creditCardService.getCreditCardByActiveCard(isActive);
	}
	
	@GetMapping(path = "/creditcard/{id}")
	public CreditCard getCreditCardById(@PathVariable Integer id) {
		return creditCardService.getCreditCardById(id);
	}
}
