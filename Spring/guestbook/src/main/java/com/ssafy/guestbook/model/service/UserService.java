package com.ssafy.guestbook.model.service;

import java.util.Map;

import com.ssafy.guestbook.model.dto.Member;

public interface UserService {

	public Member login(Map<String, String> map) throws Exception;

	public void join(Member member) throws Exception;
	
}
