package com.ssafy.prj.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.prj.model.dto.Member;
import com.ssafy.prj.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper dao;
	
	@Override
	public void join(Member member) throws Exception {
		dao.insertMember(member);
	}
	
	public Member login(Member param) throws Exception {
		return dao.selectLogin(param);
	}
}
