package com.osmond.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osmond.bean.Book;
import com.osmond.bean.Category;
import com.osmond.dao.BookDao;
import com.osmond.service.CategoryService;
import com.osmond.service.impl.CategoryServiceImpl;
import com.osmond.utils.DbcpUtils;

public class BookDaoImpl implements BookDao {

	@Override
	public int addBook(Book book) {
		Connection conn = DbcpUtils.getConnection();
		PreparedStatement pst = null;
		String sql = "INSERT INTO books(bookName,sellPoint,price,pic,des,categoryId) VALUES(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setString(2, book.getSellPoint());
			pst.setInt(3, book.getPrice());
			pst.setString(4, book.getPic());
			pst.setString(5, book.getDes());
			Category category = book.getCategory();
			pst.setInt(6, category.getId());
			int count = pst.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbcpUtils.closeAll(conn, pst, null);
		}

		return 0;
	}

	@Override
	public int deleteBook(int bookid) {
		Connection conn = DbcpUtils.getConnection();
		PreparedStatement pst = null;
		String sql = "DELETE FROM books WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bookid);
			int count = pst.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbcpUtils.closeAll(conn, pst, null);
		}
		return 0;
	}

	@Override
	public int updateBook(Book book) {
		Connection conn = DbcpUtils.getConnection();
		PreparedStatement pst = null;
		String sql = "UPDATE books SET bookName = ?,sellPoint = ?,price = ?, pic = ?,des = ?,categoryId = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setString(2, book.getSellPoint());
			pst.setInt(3, book.getPrice());
			pst.setString(4, book.getPic());
			pst.setString(5, book.getDes());
			Category category = book.getCategory();
			pst.setInt(6, category.getId());
			pst.setInt(7, book.getId());
			int count = pst.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbcpUtils.closeAll(conn, pst, null);
		}
		return 0;
	}

	@Override
	public Book findBookById(int bookid) {
		Connection conn = DbcpUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM books WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bookid);
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setBookName(resultSet.getString("bookName"));
				book.setPrice(resultSet.getInt("price"));
				book.setSellPoint(resultSet.getString("sellPoint"));
				book.setPic(resultSet.getString("pic"));
				book.setDes(resultSet.getString("des"));
				int categoryId = resultSet.getInt("categoryId");
				// 为了得到Category对象才做出的下面操作，如果不操作得不到返回为Category类型的结果集
				CategoryService categoryService = new CategoryServiceImpl();
				Category category = categoryService.findCategoryById(categoryId);
				book.setCategory(category);
				return book;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbcpUtils.closeAll(conn, pst, resultSet);
		}
		return null;
	}

	@Override
	public List<Book> findBooks() {
		Connection conn = DbcpUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		// 为了得到Category对象才做出的下面操作，如果不操作得不到返回为Category类型的结果集
		CategoryService categoryService = new CategoryServiceImpl();
		String sql = "SELECT * FROM books";
		try {
			pst = conn.prepareStatement(sql);
			resultSet = pst.executeQuery();
			List<Book> books = new ArrayList<Book>();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setBookName(resultSet.getString("bookName"));
				book.setPrice(resultSet.getInt("price"));
				book.setSellPoint(resultSet.getString("sellPoint"));
				book.setPic(resultSet.getString("pic"));
				book.setDes(resultSet.getString("des"));
				int categoryId = resultSet.getInt("categoryId");
				Category category = categoryService.findCategoryById(categoryId);
				book.setCategory(category);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbcpUtils.closeAll(conn, pst, resultSet);
		}
		return null;
	}

}
