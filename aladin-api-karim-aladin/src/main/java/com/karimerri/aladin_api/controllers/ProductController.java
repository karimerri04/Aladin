/**
 *
 */
package com.karimerri.aladin_api.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.ProductService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class ProductController extends AlaDinAdminBaseController {
	@Autowired
	private ProductService productService;

	@DeleteMapping(path = "/products/{id}")
	public String deleteProduct(Product product) {

		final Product persistedProduct = productService.deleteProduct(product);

		logger.debug("Updated product with id updated successfully: {} and name : {}", persistedProduct.getId(),
				persistedProduct.getName());

		return "redirect:/products";
	}

	@GetMapping(path = "/products/category/{id}")
	public List<Product> getProductByCategory(@PathVariable Integer id) {
		return productService.getProductByCategory(id);
	}

	@GetMapping(path = "/products/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	@GetMapping(path = "products/favorite/{isFavorited}")
	Collection<Product> getProductByProductCart(@PathVariable Boolean isFavorited) {

		return productService.findByFavorited(isFavorited);
	}

	@GetMapping(path = "/products")
	public Collection<Product> listProducts() {

		return productService.getAllProducts();
	}

	@GetMapping(path = "products/searchTerm/{searchTerm}")
	public Collection<Product> searchWithJPQLQuery(@PathVariable String searchTerm) {

		return productService.searchWithJPQLQuery(searchTerm);
	}

	@PutMapping(path = "/products/isFavorited/{id}", consumes = "application/json")
	public OperationResponse toggleProductFavorite(@PathVariable Integer id,
			@RequestBody Map<String, Boolean> payload) {

		System.out.println("the value recieved is" + id + "//" + payload.get("isFavorited"));

		final OperationResponse resp = new OperationResponse();

		final Product persistedProduct = productService.getProductById(id);

		if (persistedProduct != null) {
			// persistedProduct.setIsFavorite(payload.get("isFavorited"));

			productService.updateProduct(persistedProduct);
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Updated new product with id : {} and name : {}" + persistedProduct.getId()
					+ persistedProduct.getName() + "info Product updated successfully");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to update Product - Product don't exist ");
		}
		return resp;
	}

	@PostMapping(path = "/products/{id}")
	public String updateProduct(Product product) {

		final Product persistedProduct = productService.updateProduct(product);

		logger.debug("Updated product with id updated successfully: {} and name : {}", persistedProduct.getId(),
				persistedProduct.getName());

		return "redirect:/products";
	}

}
