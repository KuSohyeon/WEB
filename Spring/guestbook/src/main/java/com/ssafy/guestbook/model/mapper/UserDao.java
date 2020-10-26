package com.ssafy.guestbook.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.guestbook.model.dto.Member;

public interface UserDao {

	public Member login(Map<String, String> map) throws SQLException;

	public void insertMember(Member member) throws SQLException;
	
}
