package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {

	private static ProductDAO productDAO;
	private ProductDAOImpl() {}
	public static ProductDAO getInstance() {
		if(productDAO==null) {
			productDAO=new ProductDAOImpl();
		}
		return productDAO;
	}

	@Override
	public void insert(ProductDto product) throws Exception {
		String sql = "insert into product (no,name,price,content) values (?,?,?,?);";
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, product.getNo());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getContent());
			pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("insert 오류 : " + e);
		}
		
	}
	@Override
	public List<ProductDto> search(String key, String word) {
		List<ProductDto> list = new ArrayList<ProductDto>();
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from product ");
		if(!word.isEmpty()) {
			String query = "";
			if("name".equals(key)) {
				query = " like ? ";
			}else {
				query = " <= ? ";
			}
			sql.append("where "+key+query);
		}
		sql.append("order by no;");
		try(
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			if(!word.isEmpty()) {
				if("name".equals(key)) {
					pstmt.setString(1, "%"+word+"%");
				}else {
					pstmt.setInt(1, Integer.valueOf(word));
				}
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto product = new ProductDto();
				product.setNo(rs.getInt("no"));
				product.setName(rs.getNString("name"));
				product.setPrice(rs.getInt("price"));
				product.setContent(rs.getString("content"));
				list.add(product);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}
	@Override
	public ProductDto detail(int no) {
		ProductDto product = new ProductDto();
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from product where no = ?");
		try(
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				product.setNo(rs.getInt("no"));
				product.setName(rs.getNString("name"));
				product.setPrice(rs.getInt("price"));
				product.setContent(rs.getString("content"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return product;
	}
	
}
