/**
 *
 */
package com.karimerri.aladin_api.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.karimerri.aladin_api.entities.Product;
import com.karimerri.aladin_api.models.ProductForm;
import com.karimerri.aladin_api.services.ProductService;

@Component
public class ProductFormValidator implements Validator {
	@Autowired
	protected MessageSource messageSource;
	@Autowired
	protected ProductService productService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final ProductForm product = (ProductForm) target;
		final String sku = product.getSku();
		final Product p = productService.getProductBySku(sku);
		if (p != null)
			errors.rejectValue("sku", "error.exists", new Object[] { sku }, "Product SKU " + sku + " already exists");
	}

}
