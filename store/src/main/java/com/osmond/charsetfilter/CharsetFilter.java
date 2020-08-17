package com.osmond.charsetfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharsetFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 解决post请求过来的中文乱码问题
		response.setCharacterEncoding("UTF-8");
		// 解决字节流发送中文乱码问题
		response.setHeader("Content-Type", "text/html; charset=utf-8");
		// 解决字符流发送中文乱码问题
		response.setContentType("text/html; charset=utf-8");

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
