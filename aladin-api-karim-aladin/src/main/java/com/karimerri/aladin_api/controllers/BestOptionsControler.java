package com.karimerri.aladin_api.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.services.ProductService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class BestOptionsControler extends AlaDinAdminBaseController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "products/price/{searchTerm}")
	public Collection<Product> findProductsByPrice(@PathVariable String searchTerm) {

		return productService.searchWithPriceQuery(searchTerm);
	}
}
