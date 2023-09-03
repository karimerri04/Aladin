package com.karimerri.aladin_api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.models.StripeClient;
import com.stripe.model.Charge;
import com.stripe.model.EphemeralKey;
import com.stripe.net.RequestOptions;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class PaymentController {

	private final StripeClient stripeClient;

	@Autowired
	PaymentController(StripeClient stripeClient) {
		this.stripeClient = stripeClient;
	}

	@PostMapping("/payment/charge")
	public Charge chargeCard(HttpServletRequest request) throws Exception {
		final RequestOptions requestOptions = (new RequestOptions.RequestOptionsBuilder())
				.setStripeVersionOverride("{{API_VERSION}}").build();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put("customer", "{{CUSTOMER_ID}}");
		EphemeralKey.create(options, requestOptions);

		final String token = request.getHeader("token");
		final Double amount = Double.parseDouble(request.getHeader("amount"));
		return stripeClient.chargeNewCard(token, amount);
	}

	@PostMapping("/payment/token")
	public EphemeralKey tokenCard(HttpServletRequest request) throws Exception {
		final RequestOptions requestOptions = (new RequestOptions.RequestOptionsBuilder())
				.setStripeVersionOverride("{{API_VERSION}}").build();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put("customer", "{{CUSTOMER_ID}}");
		final EphemeralKey key = EphemeralKey.create(options, requestOptions);
		return key;

	}
}
