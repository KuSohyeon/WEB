package com.ssafy.corona.model.mapper;

import java.util.Map;

import com.ssafy.corona.model.dto.UserInfo;

public interface UserinfoMapper {

	UserInfo login(Map<String, String> map) throws Exception;

}
