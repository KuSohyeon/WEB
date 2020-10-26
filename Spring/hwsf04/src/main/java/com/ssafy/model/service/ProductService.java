package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.dto.Product;

public interface ProductService {

	public void add(Product p); // 상품 추가 
	
	public Product detail(int no); // 상품 추가 

	public List<Product> search(Map<String, String> map); // 상품 목록

	public void delete(int no); // 상품 삭제
}
