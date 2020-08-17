package com.osmond.service.impl;

import java.util.List;

import com.osmond.bean.Category;
import com.osmond.common.StoreResult;
import com.osmond.dao.CategoryDao;
import com.osmond.dao.impl.CategoryDaoImpl;
import com.osmond.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public StoreResult addCategory(Category category) {
		boolean isCategoryName = checkCategoryName(category.getCategoryName());
		if (isCategoryName) {
			return StoreResult.build(500, "分类失败。分类名称重复", null);
		}
		int count = categoryDao.addCategory(category);
		if (count == 0) {
			return StoreResult.build(500, "添加失败", null);
		}
		return StoreResult.ok();
	}

	@Override
	public StoreResult deleteCategoryById(int categoryId) {
		int count = categoryDao.deleteCategoryById(categoryId);
		if (count == 0) {
			return StoreResult.build(500, "刪除失敗", null);
		}
		return StoreResult.ok("刪除成功");

	}

	@Override
	public StoreResult updateCategory(Category category) {
		Category isCategory = null;
		isCategory = categoryDao.findCategoryById(category.getId());
		if (isCategory == null) {
			return StoreResult.build(500, "修改失败，该分类不存在", null);
		}
		isCategory = categoryDao.checkCategoryName(category.getCategoryName());
		if (isCategory != null) {
			return StoreResult.build(500, "修改失败,名称已存在", null);
		}
		int count = categoryDao.updateCategory(category);
		if (count == 0) {
			return StoreResult.build(500, "修改失败", null);
		}
		return StoreResult.ok("修改成功");
	}

	@Override
	public Category findCategoryById(int categoryId) {
		Category category = categoryDao.findCategoryById(categoryId);
		return category;
	}

	@Override
	public List<Category> findCategories() {
		List<Category> categories = categoryDao.findCategories();

		return categories;
	}

	@Override
	public boolean checkCategoryName(String categoryName) {
		Category category = categoryDao.checkCategoryName(categoryName);
		if (category != null) {
			return true;
		}
		return false;
	}

}
