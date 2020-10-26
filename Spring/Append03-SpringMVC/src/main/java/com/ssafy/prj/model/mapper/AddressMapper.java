package com.ssafy.prj.model.mapper;

import java.util.List;

import com.ssafy.prj.model.dto.Address;

public interface AddressMapper {

	List<Address> selectAddress(String ownerId);
	void deleteAddress(int no);
	void insertAddress(Address addressDto);

}