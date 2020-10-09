package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.ProductDto;

public interface ProductDAO {

	void insert(ProductDto product) throws Exception;

	List<ProductDto> search(String key, String word);

	ProductDto detail(int no);

	
}
