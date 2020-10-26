package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	public List<Product> search(Map<String, String> map) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		return repo.search(param);
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
