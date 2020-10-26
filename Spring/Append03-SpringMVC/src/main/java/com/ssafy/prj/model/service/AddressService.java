package com.ssafy.prj.model.service;

import java.util.List;

import com.ssafy.prj.model.dto.Address;

public interface AddressService {

	List<Address> addressList(String ownerId) throws Exception;

	void addressDelete(int no) throws Exception;

	void addressSave(Address addressDto) throws Exception;

	void addressAllDelete(String[] addressNoArr) throws Exception;

}