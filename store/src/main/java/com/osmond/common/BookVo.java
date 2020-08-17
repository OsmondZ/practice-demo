package com.osmond.common;

import com.osmond.bean.Book;

public class BookVo {
	private Book book;
	private int categoryId;
	private String categoryName;
	private String categoryDes;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDes() {
		return categoryDes;
	}
	public void setCategoryDes(String categoryDes) {
		this.categoryDes = categoryDes;
	}
	@Override
	public String toString() {
		return "BookVo [book=" + book + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", categoryDes=" + categoryDes + "]";
	}
	
}
