package com.ssafy.corona.model.service;

import java.util.Map;

import com.ssafy.corona.model.dto.UserInfo;

public interface UserinfoService {

	UserInfo login(Map<String, String> map) throws Exception;

}
