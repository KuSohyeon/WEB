package com.ssafy.prj.model.service;

import com.ssafy.prj.model.dto.Member;

public interface MemberService {

	Member login(Member param) throws Exception;
	void join(Member member) throws Exception;

}