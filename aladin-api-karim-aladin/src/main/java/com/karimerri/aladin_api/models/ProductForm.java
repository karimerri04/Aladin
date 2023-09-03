/**
 *
 */
package com.karimerri.aladin_api.models;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.karimerri.aladin_api.entities.Category;
import com.karimerri.aladin_api.entities.Product;

import lombok.Data;

@Data
public class ProductForm {
	public static ProductForm fromProduct(Product product) {
		final ProductForm p = new ProductForm();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setDisabled(product.isDiscontinued());
		p.setPrice(product.getPrice());
		p.setSku(product.getSku());
		// p.setCategoryId(product.getCategory().getId());
		// p.setImageUrl(WebUtils.IMAGES_PREFIX+product.getId()+".jpg");
		return p;
	}

	private Integer id;
	@NotEmpty
	private String sku;
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	@DecimalMin("0.1")
	private BigDecimal price = new BigDecimal("0.0");
	private String imageUrl;
	private MultipartFile image;
	private boolean disabled;

	@NotNull
	private Integer categoryId;

	public Product toProduct() {
		final Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setDescription(description);
		// p.setDisabled(disabled);
		p.setPrice(price);
		p.setSku(sku);
		final Category category = new Category();
		category.setId(categoryId);
		// p.setCategory(category);
		// p.setImageUrl(WebUtils.IMAGES_PREFIX+id+".jpg");
		return p;
	}
}
