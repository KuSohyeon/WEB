package com.ssafy.model.repository;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.Product;

public interface ProductRepo {
	public void add(Product p); // 상품 추가 
	
	public Product detail(int no); // 상품 디테일
	
	public List<Product> search(Map<String, Object> map); // 상품 목록

	
	public void delete(int no); // 상품 삭제
}
