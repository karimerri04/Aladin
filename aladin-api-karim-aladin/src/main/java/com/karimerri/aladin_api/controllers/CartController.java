package com.karimerri.aladin_api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Cart;
import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.models.LineItem;
import com.karimerri.aladin_api.services.ProductService;

@RestController
public class CartController extends AlaDinAdminBaseController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/cart/items")
	@ResponseBody
	public void addToCart(@RequestBody Product product, HttpServletRequest request) {
		final Cart cart = getOrCreateCart(request);
		final Product p = productService.getProductBySku(product.getSku());
		cart.addItem(p);
	}

	@DeleteMapping(path = "/cart")
	@ResponseBody
	public void clearCart(HttpServletRequest request) {
		final Cart cart = getOrCreateCart(request);
		cart.setItems(new ArrayList<LineItem>());
	}

	@GetMapping(path = "/cart/items/count")
	@ResponseBody
	public Map<String, Object> getCartItemCount(HttpServletRequest request) {
		final Cart cart = getOrCreateCart(request);
		final int itemCount = cart.getItemCount();
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", itemCount);
		return map;
	}

	@DeleteMapping(path = "/cart/items/{sku}")
	@ResponseBody
	public void removeCartItem(@PathVariable("sku") String sku, HttpServletRequest request) {
		final Cart cart = getOrCreateCart(request);
		cart.removeItem(sku);
	}

	@GetMapping(path = "/cart")
	public Cart showCart(HttpServletRequest request) {

		return getOrCreateCart(request);
	}

	@PutMapping(path = "/cart/items")
	@ResponseBody
	public void updateCartItem(@RequestBody LineItem item, HttpServletRequest request, HttpServletResponse response) {
		final Cart cart = getOrCreateCart(request);
		if (item.getQuantity() <= 0) {
			final String sku = item.getProduct().getSku();
			cart.removeItem(sku);
		} else
			cart.updateItemQuantity(item.getProduct(), item.getQuantity());
	}
}
