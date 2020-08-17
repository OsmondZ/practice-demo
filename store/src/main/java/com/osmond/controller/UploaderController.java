package com.osmond.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.osmond.bean.Book;
import com.osmond.bean.Category;
import com.osmond.common.StoreResult;
import com.osmond.service.BookService;
import com.osmond.service.CategoryService;
import com.osmond.service.impl.BookServiceImpl;
import com.osmond.service.impl.CategoryServiceImpl;
import com.osmond.utils.IdGenerator;

/**
 * Servlet implementation class UploaderController
 */
public class UploaderController extends HttpServlet {
	private CategoryService categoryService;
	private BookService bookService;
	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
		bookService = new BookServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			System.out.println("不能上传");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItem = fileUpload.parseRequest(request);
			//创建了一个书籍空对象
			Book book = new Book();
			for (FileItem item : fileItem) {
				if(item.isFormField()){
					//获取的是 jsp页面 form表单里面的name属性
					// name="bookName" value="用户输入的值"
					String fieldName = item.getFieldName();
					//获取的是 jsp页面 form表单里面的value值
					String value = item.getString("utf-8");
					if("bookName".equals(fieldName)){
						book.setBookName(value);
					}else if("sellPoint".equals(fieldName)){
						book.setSellPoint(value);
					}else if("price".equals(fieldName)){
						book.setPrice(Integer.valueOf(value));
					}else if("categoryId".equals(fieldName)){
						Category category = categoryService.findCategoryById(Integer.valueOf(value));
						book.setCategory(category);
					}else if("des".equals(fieldName)){
						book.setDes(value);
					}
				}else{
					//装我们的路径 这个是图片名称
					String name = item.getName();
					// 不同的浏览器 上传图片 图片的名称不一样

					String fileName = FilenameUtils.getName(name);
					fileName = IdGenerator.getGenerator(fileName);

					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					String folder = format.format(date);
					//2020-08-13
					File file = new File("D://upPic",folder);
					if(!file.exists()){
						file.mkdir();
					}
					item.write(new File(file,fileName));
					//真正的路径
					book.setPic("http://192.168.0.123/"+folder+"/"+fileName);
				}
			}
			StoreResult addBook = bookService.addBook(book);
			response.sendRedirect("/store/manager");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
