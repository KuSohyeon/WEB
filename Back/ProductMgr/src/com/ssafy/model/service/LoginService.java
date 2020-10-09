package com.ssafy.model.service;

import com.ssafy.model.MemberDto;

public interface LoginService {
	MemberDto login(MemberDto member) throws Exception;
}
