package com.osmond.service;

import java.util.List;

import com.osmond.bean.Category;
import com.osmond.common.StoreResult;

public interface CategoryService {
	StoreResult addCategory(Category category);

	StoreResult deleteCategoryById(int categoryId);

	StoreResult updateCategory(Category category);

	Category findCategoryById(int categoryId);

	List<Category> findCategories();
	
	boolean checkCategoryName(String categoryName);
}
