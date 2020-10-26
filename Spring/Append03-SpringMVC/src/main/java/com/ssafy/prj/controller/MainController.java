package com.ssafy.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"/", "/main"})
	public String main() {
		return "main";
	}
}

//<SpringFramework>
//
//1. 프로젝트 property속성가서 4.0/1.8/tomcat 설정
//2. pom.xml 수정
//3. web.xml 필터 설정
//4. 각각의 root-context 설정(mybatis, transaction)
//5. META-INF, context.xml 설정(DB)
//6. servlet-context 확인(여기는 근데 이미 어느정도 되어있긴 함)
 