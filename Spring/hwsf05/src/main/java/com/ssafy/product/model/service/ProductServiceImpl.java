package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper mapper;
	
	@Override
	public void add(Product product) throws Exception {
		mapper.add(product);
	}

	@Override
	public void modify(Product product) throws Exception {
		mapper.modify(product);
	}

	@Override
	public Product detail(String id) throws Exception {
		return mapper.detail(id);
	}

	@Override
	public List<Product> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void delete(String id) throws Exception {
		mapper.delete(id);
	}

}
