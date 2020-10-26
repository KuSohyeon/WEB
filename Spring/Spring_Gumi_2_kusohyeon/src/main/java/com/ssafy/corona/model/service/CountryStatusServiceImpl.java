package com.ssafy.corona.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.corona.model.dto.CountryStatus;
import com.ssafy.corona.model.mapper.CountryStatusMapper;

@Service
public class CountryStatusServiceImpl implements CountryStatusService {

	@Autowired
	private CountryStatusMapper mapper;
	
	@Override
	public void regist(CountryStatus countryStatus) throws Exception {
		if(countryStatus.getCcode() == null || countryStatus.getCname() == null || countryStatus.getRcode() == null) {
			throw new Exception();
		}
		mapper.insert(countryStatus);
		
	}

	@Override
	public List<CountryStatus> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public void delete(String ccode) throws Exception {
		mapper.delete(ccode);
		
	}

	@Override
	public void ccodeAllDelete(String[] ccodeArr) throws Exception {
		for (String ccode : ccodeArr) {
			mapper.delete(ccode);
		}
	}
	

}
