package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.model.dao.ProductDAO;
import com.ssafy.model.dao.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDao = ProductDAOImpl.getInstance();
	
	private static ProductService service;
	private ProductServiceImpl() {}
	public static ProductService getInstance() {
		if(service==null) {
			service = new ProductServiceImpl();
		}
		return service;
	}
	
	@Override
	public void addProduct(ProductDto product) throws Exception {
		productDao.insert(product);
		
	}
	@Override
	public List<ProductDto> search(String key, String word) {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return productDao.search(key,word);
	}
	@Override
	public ProductDto searchByNo(int no) {
		return productDao.detail(no);
	}

}
