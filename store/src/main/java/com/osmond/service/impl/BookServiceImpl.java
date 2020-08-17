package com.osmond.service.impl;

import java.util.List;

import com.osmond.bean.Book;
import com.osmond.common.StoreResult;
import com.osmond.dao.BookDao;
import com.osmond.dao.impl.BookDaoImpl;
import com.osmond.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public StoreResult addBook(Book book) {
		int count = bookDao.addBook(book);
		if (count == 0) {
			return StoreResult.build(500, "添加书籍失败", null);
		}
		return StoreResult.ok("添加成功");
	}

	@Override
	public StoreResult deleteBook(int bookid) {
		int count = bookDao.deleteBook(bookid);
		return null;
	}

	@Override
	public StoreResult updateBook(Book book) {
		int count = bookDao.updateBook(book);
		return null;
	}

	@Override
	public Book findBookById(int bookId) {
		Book book = bookDao.findBookById(bookId);
		return null;
	}

	@Override
	public List<Book> findBooks() {
		List<Book> books = bookDao.findBooks();
		return books;
	}

}
