package com.karimerri.aladin_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Category;
import com.karimerri.aladin_api.services.CategoryService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class CategoryController extends AlaDinAdminBaseController {

	@Autowired
	private CategoryService categoryService;

	/*
	 * @PostMapping(path = "/categorie") public OperationResponse
	 * createCategory(@Valid Category category, HttpServletRequest req) {
	 *
	 * final OperationResponse resp = new OperationResponse(); final String name =
	 * category.getName(); final Category categoryByName =
	 * catalogService.getCategoryByName(name);
	 *
	 * if (categoryByName != null) {
	 * resp.setOperationStatus(ResponseStatusEnum.ERROR);
	 * resp.setOperationMessage("name" + "error.exists" + new Object[] { name } +
	 * "Category " + category.getName() + " already exists"); } else { final
	 * Category persistedCategory = catalogService.createCategory(category);
	 * resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
	 * resp.setOperationMessage("Created new category with id : {} and name : {}" +
	 * persistedCategory.getId() + persistedCategory.getName()); } return resp; }
	 */

	@GetMapping(path = "/categories/{id}")
	public Category editCategoryForm(@PathVariable Integer id) {
		return categoryService.getCategoryById(id);
	}

	@GetMapping(path = "/categories")
	public List<Category> listCategories() {
		return categoryService.getAllCategories();
	}

	/*
	 * @PostMapping(path = "/categories/{id}") public OperationResponse
	 * updateCategory(Category category) { final OperationResponse resp = new
	 * OperationResponse();
	 *
	 * final Category persistedCategory = catalogService.updateCategory(category);
	 *
	 * if (persistedCategory != null) {
	 * resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
	 * resp.setOperationMessage("Updated category with id : {} and name : {}" +
	 * persistedCategory.getId() + persistedCategory.getName()); } return resp; }
	 */

}
