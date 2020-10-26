package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public void add(Product p) {
		repo.add(p);
	}

	@Override
	public List<Product> search(String key, String word) {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return repo.search(key,word);
	}


	@Override
	public void delete(int no) {
		repo.delete(no);
	}

	@Override
	public Product detail(int no) {
		return repo.detail(no);
	}

}
