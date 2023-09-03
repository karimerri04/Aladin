package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.repositories.ProductRepository;
import com.karimerri.aladin_api.utils.AlaDinException;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	/*
	 * public Product createProduct(Product product) { final Product
	 * persistedProduct = getProductBySku(product.getName()); if (persistedProduct
	 * != null) throw new AlaDinException("Product SKU " + product.getSku() +
	 * " already exist"); return productRepository.save(product); }
	 */

	public Product deleteProduct(Product product) {
		final Product persistedProduct = getProductById(product.getId());
		if (persistedProduct == null)
			throw new AlaDinException("Product " + product.getId() + " doesn't exist");
		else
			persistedProduct.setDescription(product.getSku());
		/*
		 * persistedProduct.setDescription(product.getDescription());
		 * persistedProduct.setDisabled(product.isDisabled());
		 * persistedProduct.setCreatedOn(product.getCreatedOn());
		 * persistedProduct.setAssetName(product.getAssetName());
		 * persistedProduct.setIsFavorited(product.getIsFavorited());
		 * persistedProduct.setCategory(categoryService.getCategoryById(product.
		 * getCategory().getId()));
		 */
		return productRepository.save(persistedProduct);
	}

	public List<Product> findByFavorited(Boolean isFavorited) {
		return productRepository.findByFavorited(isFavorited);
	}

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public List<Product> getProductByCategory(Integer id) {
		return productRepository.findByCategory(id);
	}

	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Product getProductBySku(String sku) {
		return productRepository.findBySku(sku);
	}

	public List<Product> searchWithJPQLQuery(String query) {
		return productRepository.search("%" + query + "%");
	}

	public List<Product> searchWithPriceQuery(String query) {
		return productRepository.search("%" + query + "%");
	}

	public Product updateProduct(Product product) {
		final Product persistedProduct = getProductById(product.getId());
		if (persistedProduct == null)
			throw new AlaDinException("Product " + product.getId() + " doesn't exist");
		else
			persistedProduct.setDescription(product.getSku());
		/*
		 * persistedProduct.setDescription(product.getDescription());
		 * persistedProduct.setDisabled(product.isDisabled());
		 * persistedProduct.setCreatedOn(product.getCreatedOn());
		 * persistedProduct.setAssetName(product.getAssetName());
		 * System.out.println("the favorite value is " + product.getIsFavorited());
		 * persistedProduct.setIsFavorited(product.getIsFavorited());
		 * persistedProduct.setCategory(categoryService.getCategoryById(product.
		 * getCategory().getId()));
		 */
		return productRepository.save(persistedProduct);
	}
}
