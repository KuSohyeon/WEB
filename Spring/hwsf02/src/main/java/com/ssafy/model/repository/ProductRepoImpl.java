package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

@Repository
public class ProductRepoImpl implements ProductRepo {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void add(Product p) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into product2 (id,name,price,content) values (?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getContent());
			pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("오류 : "+e);
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public List<Product> search(String key, String word) {
		List<Product> list = new ArrayList<Product>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no,id,name,price,content from product2 ");
			if(!word.isEmpty()) {
				String query = "";
				if("name".equals(key)) {
					query=" like ?";
				}else {
					query=" <= ?";
				}
				sql.append("where "+key+query);
			}
			
			sql.append(" order by no");
			pstmt = conn.prepareStatement(sql.toString());
			if(!word.isEmpty()) {
				if("name".equals(key)) {
					pstmt.setString(1, "%"+word+"%");
				}else {
					pstmt.setInt(1, Integer.valueOf(word));
				}	
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setNo(rs.getInt("no"));
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setContent(rs.getString("content"));
				
				list.add(product);
			}
		}catch(Exception e) {
			System.out.println("오류 : "+e);
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public void delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from product2 where no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt==1) {
				System.out.println(no+" 상품 지우기 성공");
			}
		}catch(Exception e) {
			System.out.println("오류 : " + e);
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public Product detail(int no) {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from product2");
			sql.append(" where no = ?;");
				
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getString("id"));
				product.setNo(rs.getInt("no"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setContent(rs.getString("content"));
				
			}
		}catch(Exception e) {
			System.out.println("오류 : "+e);
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return product;
	}


}
