package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.entities.Category;
import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.repositories.CategoryRepository;
import com.karimerri.aladin_api.repositories.OrderRepository;
import com.karimerri.aladin_api.repositories.PaymentRepository;
import com.karimerri.aladin_api.repositories.ProductRepository;
import com.karimerri.aladin_api.utils.AlaDinException;

@Service
@Transactional
public class CatalogService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	PaymentRepository paymentRepository;

	/*
	 * public Category createCategory(Category category) { final Category
	 * persistedCategory = getCategoryByName(category.getName()); if
	 * (persistedCategory != null) throw new AlaDinException("Category " +
	 * category.getName() + " already exist"); return
	 * categoryRepository.save(category); }
	 */

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
		 * persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
		 */
		return productRepository.save(persistedProduct);
	}

	public List<Product> findByFavorited(Boolean isFavorited) {
		return productRepository.findByFavorited(isFavorited);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public Category getCategoryByName(String name) {
		return categoryRepository.getByName(name);
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

	public Category updateCategory(Category category) {
		final Category persistedCategory = getCategoryById(category.getId());
		if (persistedCategory == null)
			throw new AlaDinException("Category " + category.getId() + " doesn't exist");
		persistedCategory.setDescription(category.getDescription());
		persistedCategory.setDisplayOrder(category.getDisplayOrder());
		persistedCategory.setDisabled(category.isDisabled());
		return categoryRepository.save(persistedCategory);
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
		 * persistedProduct.setIsFavorited(product.getIsFavorited());
		 * persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
		 */
		return productRepository.save(persistedProduct);
	}
}
