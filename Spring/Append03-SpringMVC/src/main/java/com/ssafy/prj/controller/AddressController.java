package com.ssafy.prj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.prj.model.dto.Address;
import com.ssafy.prj.model.dto.Member;
import com.ssafy.prj.model.service.AddressService;

@Controller //이거 빼먹으면 안됨!!404뜸
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping("/save")
	public String addressSave(Address address, HttpSession session, Model model) {
		try {
			String s = null;
			System.out.println(s.length());
			Member member = (Member)session.getAttribute("member");
			address.setOwnerId(member.getId());
			service.addressSave(address);
		} catch (Exception e) {
			e.printStackTrace();
			//msg 이름으로 "주소록 등록시 에러가 발생하였습니다."
			model.addAttribute("msg","주소록 등록시 에러가 발생하였습니다.");
			return "error/error";
		}
		return "redirect:list";
	}

	
	//void일때는 호출한 경로 기준으로 페이지를 찾는다
	// /address/save -> viewResolver
	@GetMapping("/save")
	public void addressSaveForm() {} 
	
	@GetMapping("/list")
	public void addressList(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("member");
		try {
			model.addAttribute("ssafyAddressList", service.addressList(member.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/delete")
	private String addressDelete(int no) {
		try {
			service.addressDelete(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}

	@PostMapping("/delete-all")
	public String addressAllDelete(String[] addressNo) {
		try {
			if (addressNo != null) {
				service.addressAllDelete( addressNo );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// /로 시작할 경우 자동으로 프로젝트 경로 추가
//	     http://localhost:8888/prj/list
		
		return "redirect:list"; // 다시 controller호출
//	    http://localhost:8888/prj/address/list

	}

}
