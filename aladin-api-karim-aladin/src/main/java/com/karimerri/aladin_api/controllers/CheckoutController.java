package com.karimerri.aladin_api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.karimerri.aladin_api.entities.Cart;

@Controller
public class CheckoutController extends AlaDinAdminBaseController {

	@GetMapping(path = "/checkout")
	public Cart checkout(HttpServletRequest request) {
		return getOrCreateCart(request);
	}
}
