package com.ssafy.product.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<Product>  productList() {
		List<Product> list = null;
		try {
			list = productService.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		
		return list;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<Product> add(@RequestBody Product product,Model model) {
		List<Product> list = null;
		try {
			productService.add(product);
			model.addAttribute("msg", "추가 성공");
			list = productService.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public Product detail(@PathVariable("id") String id,Model model) {
		Product product = null;
		try {
			product=productService.detail(id);
			model.addAttribute("msg", "불러오기 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return product;
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public List<Product> modify(@RequestBody Product product,Model model) {
		List<Product> list = null;
		try {
			productService.modify(product);
			model.addAttribute("msg", "수정 성공");
			list = productService.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public List<Product> userDelete(@PathVariable("id") String id) throws Exception {
		productService.delete(id);
		return productService.list();
		
	}
}
