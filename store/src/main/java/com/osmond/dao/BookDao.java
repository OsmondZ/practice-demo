package com.osmond.dao;

import java.util.List;

import com.osmond.bean.Book;

public interface BookDao {

	int addBook(Book book);

	int deleteBook(int bookid);

	int updateBook(Book book);

	Book findBookById(int bookId);

	List<Book> findBooks();

}
