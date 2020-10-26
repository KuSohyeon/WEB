package com.ssafy.guestbook.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.dto.Member;
import com.ssafy.guestbook.model.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public Member login(Map<String, String> map) throws Exception {
		if(map.get("userid") == null || map.get("userpwd") == null)
			return null;
		return dao.login(map);
	}

	@Override
	public void join(Member member) throws Exception {
		dao.insertMember(member);
		
	}

}
