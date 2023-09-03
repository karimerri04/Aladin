package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.entities.Category;
import com.karimerri.aladin_api.repositories.CategoryRepository;
import com.karimerri.aladin_api.utils.AlaDinException;

@Service
@Transactional
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	/*
	 * public Category createCategory(Category category) { final Category
	 * persistedCategory = getCategoryByName(category.getName()); if
	 * (persistedCategory != null) throw new AlaDinException("Category " +
	 * category.getName() + " already exist"); return
	 * categoryRepository.save(category); }
	 */

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public Category getCategoryByName(String name) {
		return categoryRepository.getByName(name);
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
}
