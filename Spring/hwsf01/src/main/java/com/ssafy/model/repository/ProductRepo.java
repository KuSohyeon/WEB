package com.ssafy.model.repository;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductRepo {
	public void add(Product p); // 상품 추가 
	
	public Product detail(int no); // 상품 디테일
	
	public List<Product> search(String key, String word); // 상품 목록

	
	public void delete(int no); // 상품 삭제
}
