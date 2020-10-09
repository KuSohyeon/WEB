package com.ssafy.model.service;

import com.ssafy.model.MemberDto;
import com.ssafy.model.dao.LoginDAO;
import com.ssafy.model.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDao = LoginDAOImpl.getInstance();
	
	/********* 싱글턴 패턴 적용 **********/
	private static LoginService loginService;
	private LoginServiceImpl() {}
	public static LoginService getInstance() {
		if(loginService==null) {
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}
	
	@Override
	public MemberDto login(MemberDto member) throws Exception {
		return loginDao.login(member);
	}

}
