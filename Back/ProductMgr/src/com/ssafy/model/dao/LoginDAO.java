package com.ssafy.model.dao;

import com.ssafy.model.MemberDto;

public interface LoginDAO {

	MemberDto login(MemberDto member) throws Exception;

}
