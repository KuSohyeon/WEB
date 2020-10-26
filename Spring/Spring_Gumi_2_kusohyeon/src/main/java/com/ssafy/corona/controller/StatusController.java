package com.ssafy.corona.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.corona.model.dto.CountryStatus;
import com.ssafy.corona.model.service.CountryStatusService;


@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private CountryStatusService countryStatusService;
	
	@GetMapping(value="/regist")
	public void regist() {}
	
	@PostMapping(value="/regist")
	public String regist(CountryStatus countryStatus, Model model, HttpSession session) {
			try {
				countryStatusService.regist(countryStatus);
				model.addAttribute("msg", countryStatus.getCname()+ "현황 등록성공");
				return "status/writesuccess";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "현황 등록중 문제가 발생했습니다.");
				return "error/error";
			}
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		try {
			List<CountryStatus> list = countryStatusService.list();
			model.addAttribute("list", list);
			return "status/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("ccode") String ccode, Model model) {
		try {
			countryStatusService.delete(ccode);
			return "redirect:list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@PostMapping("/delete-all")
	public String ccodeAllDelete(String[] ccode) {
		try {
			if (ccode != null) {
				countryStatusService.ccodeAllDelete( ccode );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:list"; // 다시 controller호출

	}
}
