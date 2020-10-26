package com.ssafy.corona.model.mapper;

import java.util.List;

import com.ssafy.corona.model.dto.CountryStatus;

public interface CountryStatusMapper {

	public void insert(CountryStatus countryStatus) throws Exception;
	public List<CountryStatus> list() throws Exception;
	public void delete(String ccode) throws Exception;

}
