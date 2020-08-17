package com.osmond.test;

import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.osmond.bean.Book;
import com.osmond.bean.Category;
import com.osmond.common.StoreResult;
import com.osmond.dao.CategoryDao;
import com.osmond.dao.impl.CategoryDaoImpl;
import com.osmond.service.CategoryService;
import com.osmond.service.impl.CategoryServiceImpl;
import com.osmond.utils.JsonUtils;

public class CategoryTest {
	private CategoryDao dao;
	private CategoryService service;

	@Before
	public void init() {
		dao = new CategoryDaoImpl();
		service = new CategoryServiceImpl();
	}

	@Test
	public void addDao() {
		Category category = new Category();
		category.setCategoryName("玄幻类");
		category.setDes("修仙传奇，值得拥有");
		dao.addCategory(category);
	}

	@Test
	public void deleteDao() {
		int deleteCategoryById = dao.deleteCategoryById(4);

	}

	@Test
	public void updateDao() {
		Category category = new Category();
		category.setId(1);
		category.setCategoryName("增肥类");
		category.setDes("肥美无敌的身材，您值得拥有");
		dao.updateCategory(category);
	}

	@Test
	public void findOneDao() {
		Category category = dao.findCategoryById(1);
		System.out.println(category);
	}

	@Test
	public void findAllDao() {
		List<Category> findCategories = dao.findCategories();
		for (Category category : findCategories) {
			System.out.println(category);
			List<Book> books = category.getBooks();
			if (books.size() > 0 && books != null) {
				for (Book book : books) {
					System.out.println("每一个对象对应的书籍对象" + book);
				}
			}

			System.out.println("-----------------");
		}
	}

	@Test
	public void addService() {
		Category category = new Category();
		category.setCategoryName("言情类");
		category.setDes("修仙，打boss");
		StoreResult addCategory = service.addCategory(category);
		String objectToJson = JsonUtils.objectToJson(addCategory);
		System.out.println(objectToJson);
	}

	@Test
	public void deleteService() {
		StoreResult storeResult = service.deleteCategoryById(6);
		String objectToJson = JsonUtils.objectToJson(storeResult);
		System.out.println(objectToJson);

	}

	@Test
	public void updateService() {
		Category category = new Category();
		category.setId(4);
		category.setCategoryName("言情类");
		category.setDes("小薇姐姐");
		StoreResult updateCategory = service.updateCategory(category);
		String objectToJson = JsonUtils.objectToJson(updateCategory);
		System.out.println(objectToJson);
	}

	@Test
	public void findOneService() {
		Category category = service.findCategoryById(1);
		System.out.println(category);
	}

	@Test
	public void findAllService() {
		List<Category> findCategorys = service.findCategories();
		for (Category category : findCategorys) {
			System.out.println(category);
		}
	}

}
