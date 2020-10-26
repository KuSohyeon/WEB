package com.ssafy.model.repository;


import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;
import com.ssafy.util.SqlMapConfig;

@Repository
public class ProductRepoImpl implements ProductRepo {

	@Override
	public void add(Product p) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert("com.ssafy.model.repository.ProductRepo.add", p);
		}
		
	}

	@Override
	public List<Product> search(Map<String, Object> map) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList("com.ssafy.model.repository.ProductRepo.search", map);
		}
	}

	@Override
	public void delete(int no) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.delete("com.ssafy.model.repository.ProductRepo.delete", no);
		}
		
	}

	@Override
	public Product detail(int no) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne("com.ssafy.model.repository.ProductRepo.detail", no);
		}
	}


}
