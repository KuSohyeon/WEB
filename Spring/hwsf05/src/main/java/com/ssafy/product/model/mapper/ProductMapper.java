package com.ssafy.product.model.mapper;

import java.util.List;

import com.ssafy.product.model.dto.Product;

public interface ProductMapper {

	public void add(Product product) throws Exception; // 상품 추가 
	
	public void modify(Product product) throws Exception; // 상품 수정
	
	public Product detail(String id) throws Exception; // 상품 디테일 

	public List<Product> list() throws Exception; // 상품 목록

	public void delete(String id) throws Exception; // 상품 삭제
}
