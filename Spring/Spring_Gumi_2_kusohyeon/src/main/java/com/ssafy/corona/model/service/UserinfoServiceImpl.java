package com.ssafy.corona.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.corona.model.dto.UserInfo;
import com.ssafy.corona.model.mapper.UserinfoMapper;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper mapper;
	
	@Override
	public UserInfo login(Map<String, String> map) throws Exception {
		if(map.get("id") == null || map.get("pw") == null)
			return null;
		return mapper.login(map);
	}


}
