package com.ssafy.prj.model.mapper;

import com.ssafy.prj.model.dto.Member;

public interface MemberMapper {

	Member selectLogin(Member param);
	void insertMember(Member member);

}