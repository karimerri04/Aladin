/**
 *
 */
package com.karimerri.aladin_api.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.karimerri.aladin_api.entities.Category;
import com.karimerri.aladin_api.services.CategoryService;

@Component
public class CategoryValidator implements Validator {
	@Autowired
	protected MessageSource messageSource;
	@Autowired
	protected CategoryService categoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final Category category = (Category) target;
		final String name = category.getName();
		final Category categoryByName = categoryService.getCategoryByName(name);
		if (categoryByName != null)
			errors.rejectValue("name", "error.exists", new Object[] { name },
					"Category " + category.getName() + " already exists");
	}

}
