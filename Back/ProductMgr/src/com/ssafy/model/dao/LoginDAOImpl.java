package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

import com.ssafy.model.MemberDto;
import com.ssafy.util.DBUtil;


public class LoginDAOImpl implements LoginDAO {

	private static LoginDAO loginDao;
	private LoginDAOImpl() {}
	public static LoginDAO getInstance() {
		if(loginDao==null){
			loginDao=new LoginDAOImpl();
		}
		return loginDao;
	}

	@Override
	public MemberDto login(MemberDto member) throws Exception {
		MemberDto user = null;
		try(
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"Select * from member where id = ? and pw = ?");
				){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new MemberDto();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPw(rs.getString("pw"));
			}
			
			
		}catch(SQLException | NamingException e) {
			user = null;
			e.printStackTrace();
			System.out.println("오류 : "+e);
			throw e;
		}
		System.out.println("회원 확인 완료");
		return user;
	}

}
