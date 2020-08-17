package com.osmond.dao;

import java.util.List;

import com.osmond.bean.Category;

public interface CategoryDao {
	int addCategory(Category category);
	int deleteCategoryById(int categoryId);
	int updateCategory(Category category);
	Category findCategoryById(int categoryId);
	List<Category> findCategories();
	Category checkCategoryName(String categoryName);
	
}
