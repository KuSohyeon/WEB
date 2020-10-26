package com.ssafy.corona.model.service;

import java.util.List;

import com.ssafy.corona.model.dto.CountryStatus;

public interface CountryStatusService {

	
	public void regist(CountryStatus countryStatus) throws Exception;
	public List<CountryStatus> list() throws Exception;
	public void delete(String ccode) throws Exception;
	public void ccodeAllDelete(String[] ccode) throws Exception;
	
}
