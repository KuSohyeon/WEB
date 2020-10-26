package com.ssafy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
									// 사용자가 url을 직접 치고 들어오면 404에러 발생, 그걸 막기위해 headers 기입 표현이 다르게 나옴 415에러
	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<MemberDto>  userList() {
		return userService.userList();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) {
		userService.userRegister(memberDto);
		return userService.userList();
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public MemberDto userInfo(@PathVariable("userid") String userid) {
		return userService.userInfo(userid); //MemberDto 얻어옴
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) {
		userService.userModify(memberDto);
		return userService.userList();
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public List<MemberDto> userDelete(@PathVariable("userid") String userid) {
		userService.userDelete(userid);
		return userService.userList();
	}
	
}
