package com.ssafy.prj.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.prj.model.dto.Address;
import com.ssafy.prj.model.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressMapper dao;
	
	@Override
	public List<Address> addressList(String ownerId) throws Exception {
		return dao.selectAddress(ownerId);
	}

	@Override
	public void addressDelete(int no) throws Exception {
		dao.deleteAddress(no);
	}

	@Override
	public void addressSave(Address addressDto) throws Exception {
		dao.insertAddress(addressDto);
	}

	@Override
	public void addressAllDelete(String[] addressNoArr) throws Exception {
		for (String no : addressNoArr) {
			dao.deleteAddress(Integer.parseInt(no));
		}
	}
}
