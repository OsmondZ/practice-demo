package com.osmond.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.osmond.bean.Book;
import com.osmond.bean.Category;
import com.osmond.dao.BookDao;
import com.osmond.dao.impl.BookDaoImpl;
import com.osmond.service.BookService;
import com.osmond.service.impl.BookServiceImpl;

public class BookTest {
	private BookService bookServive;
	private BookDao bookDao;
	@Before
	public void init() {
		bookServive = new BookServiceImpl();
		bookDao = new BookDaoImpl();
	}
	@Test
	public void daoAdd() {
		Book book = new Book();
		book.setBookName("嬢后余生");
		book.setSellPoint("凄惨的人生故事中也会带来一丝丝的温暖");
		book.setPic("d://192.168.0.160");
		book.setDes("你买不买嬢都在那里永久的等待");
		book.setPrice(100);
		Category category = new Category();
		category.setId(8);
		category.setCategoryName("心灵鸡汤类");
		category.setDes("带个你的不仅仅是鸡汤，而是从内心散发出的丝丝温暖");
		book.setCategory(category);
		int addBook = bookDao.addBook(book);
		System.out.println(addBook);
	}
	@Test
	public void findOneBook() {
		Book book = bookDao.findBookById(1);
		System.out.println(book);
		System.out.println("--------------");
		Category category = book.getCategory();
		System.out.println(category);
	}
	@Test
	public void findAllBooks() {
		List<Book> books = bookDao.findBooks();
//		System.out.println(books);
//		System.out.println("--------------");
		for (Book book : books) {
			System.out.println(book);
			Category category = book.getCategory();
			System.out.println("--------------");
			System.out.println(category);
		}
//		Category category = book.getCategory();
//		System.out.println(category);
	}
	@Test
	public void deleteBook() {
	int deleteBook = bookDao.deleteBook(3);
	
	}
	@Test
	public void updateBook() {
		Book book = new Book();
		book.setId(1);
		book.setBookName("金钱永不眠");
		book.setSellPoint("金融世界的神奇变化");
		book.setPic("d://192.168.0.160");
		book.setDes("香帅老师倾情推荐");
		book.setPrice(20);
		Category category = new Category();
		category.setId(2);
		category.setCategoryName("商业类");
		category.setDes("带个你的不仅仅是鸡汤，而是从内心散发出的丝丝温暖");
		book.setCategory(category);
		int updateBook = bookDao.updateBook(book);
		System.out.println(updateBook);
	}
}