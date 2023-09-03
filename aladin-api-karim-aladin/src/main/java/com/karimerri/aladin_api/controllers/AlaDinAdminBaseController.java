
package com.karimerri.aladin_api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.Cart;

public abstract class AlaDinAdminBaseController {

	/*
	 * public static AuthenticatedUser getCurrentUser() {
	 *
	 * final Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof AuthenticatedUser) return ((AuthenticatedUser)
	 * principal); // principal object is either null or represents anonymous user -
	 * // neither of which our domain User object can represent - so return null
	 * return null; }
	 */

	/*
	 * public static boolean isLoggedIn() { return getCurrentUser() != null; }
	 */

	protected final AlaDinLogger logger = AlaDinLogger.getLogger(getClass());

	@Autowired
	protected MessageSource messageSource;

	/*
	 * @ModelAttribute("authenticatedUser") public AuthenticatedUser
	 * authenticatedUser(@AuthenticationPrincipal AuthenticatedUser
	 * authenticatedUser) { return authenticatedUser; }
	 */

	// protected abstract String getHeaderTitle();

	public String getMessage(String code) {
		return messageSource.getMessage(code, null, null);
	}

	public String getMessage(String code, String defaultMsg) {
		return messageSource.getMessage(code, null, defaultMsg, null);
	}

	protected Cart getOrCreateCart(HttpServletRequest request) {
		Cart cart = null;
		cart = (Cart) request.getSession().getAttribute("CART_KEY");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("CART_KEY", cart);
		}
		return cart;
	}

}
