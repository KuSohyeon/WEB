package com.ssafy.model.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;


@RequestMapping(value="/main", method = {RequestMethod.GET ,RequestMethod.POST})
@Controller
public class MainController{
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
		private String main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return "redirect:/";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	private String detailProduct(@RequestParam("no") int no,  Model model) throws ServletException, IOException {
		Product product = service.detail(no);
		model.addAttribute("product", product);
		return "product/DetailProduct";
		
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	private String addProduct() {
		return "product/addProduct";
	}


	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String deleteProduct(@RequestParam("no") int no,  Model model) throws ServletException, IOException {
		service.delete(no);
		return "product/deletesuccess";
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(@RequestParam Map<String, String> map, Model model) throws ServletException, IOException {
		try {
			List<Product> list = service.search(map);
			model.addAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return"product/listProduct";
		
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private String addProduct(Product product, Model model) throws ServletException, IOException {
		service.add(product);
		System.out.println(product.getName() + " 상품이 성공적으로 등록되었습니다.");
		return "product/addsuccess";
		
	}

}
