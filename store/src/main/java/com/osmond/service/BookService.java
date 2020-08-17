package com.osmond.service;

import java.util.List;

import com.osmond.bean.Book;
import com.osmond.common.StoreResult;

public interface BookService {
	StoreResult addBook(Book book);

	StoreResult deleteBook(int bookid);

	StoreResult updateBook(Book book);

	Book findBookById(int bookId);

	List<Book> findBooks();

}
