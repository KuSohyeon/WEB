package com.ssafy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.MemberDto;
import com.ssafy.model.ProductDto;
import com.ssafy.model.dao.ProductDAO;
import com.ssafy.model.service.LoginService;
import com.ssafy.model.service.LoginServiceImpl;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServiceImpl;
import java.util.List;

@WebServlet("/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = ProductServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("SAVE".equals(action)) {
			addProduct(request,response);
		}else if("ADD_PRODUCT_FORM".equals(action)) {
			request.getRequestDispatcher("/product/productform.jsp").forward(request, response);
		}
		else if("LIST_PRODUCT".equals(action)) {
			listProduct(request,response);
		}else if("LAST_PRODUCT".equals(action)) {
			lastProduct(request,response);
		}else if("DETAIL".equals(action)) {
			detail(request,response);
		}
		else {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.valueOf(request.getParameter("no"));
		String name = request.getParameter("name");
		int price = Integer.valueOf(request.getParameter("price"));
		String content = request.getParameter("content");
		ProductDto product = new ProductDto(no,name,price,content);
		
		try {
			service.addProduct(product);
			System.out.println("상품 등록 성공!");
			// 등록시 쿠키 설정
			Cookie cookie = new Cookie("no",String.valueOf(no));
			cookie.setPath("/");
			response.addCookie(cookie);
			request.getRequestDispatcher("/product/addsuccess.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류 : "+ e);
		}
		
		
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) {
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		List<ProductDto> list = new ArrayList<ProductDto>();
	
		try {
			list = service.search(key,word);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/product/listProduct.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	private void lastProduct(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		try {
			int no = 0;
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("no")) {
					no = Integer.valueOf(cookie.getValue());
					break;
				}
			}
			
			if(no!=0) {
				request.setAttribute("product", service.searchByNo(no));
				request.getRequestDispatcher("/product/productDetail.jsp").forward(request, response);
			}else {
				response.sendRedirect("main.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void detail(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.valueOf(request.getParameter("no"));
		request.setAttribute("product", service.searchByNo(no));
		try {
			request.getRequestDispatcher("/product/productDetail.jsp").forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
		
		
	}






}
