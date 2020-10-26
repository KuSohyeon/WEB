package com.ssafy.prj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.prj.model.dto.Member;
import com.ssafy.prj.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping("/join")
	private String join(Member member) {
		// 사용자 입력 데이터를 서버스에 넘기기 위해서 정제작업
		try {
			service.join(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/main";
	}
	
	@GetMapping("/join")
	public void joinForm() {}
	
	@GetMapping("/login")
	private void loginform() {}
	
	@PostMapping("/login")
	private String login(Member param, HttpServletRequest request) {
		String page = "redirect:/main";
		try {
			Member member = service.login(param);
			// 로그인 성공시 
			if (member != null) {
				request.getSession().setAttribute("member", member);
			} 
			// 로그인 실패시
			else {
				request.setAttribute("msg", "아이디 또는 패스워드가 다릅니다.");
				page = "member/login";
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	@GetMapping("/logout")
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
}
