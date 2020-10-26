package com.ssafy.corona.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.corona.model.dto.UserInfo;
import com.ssafy.corona.model.service.UserinfoService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		try {
			UserInfo UserinfoDto = userinfoService.login(map);
			if(UserinfoDto != null) {
				session.setAttribute("userinfo", UserinfoDto);
				
				Cookie cookie = new Cookie("ssafy_id", UserinfoDto.getId());
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
				response.addCookie(cookie);
				
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error.jsp";
		}
		return "index";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
