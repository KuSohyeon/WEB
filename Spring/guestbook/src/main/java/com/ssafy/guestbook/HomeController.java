package com.ssafy.guestbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
}

//gustbook_framework<최종프로젝트>
//
//레거시 프로젝트 생성(Spring MVC)
//패키지명 넣기
//프로젝트 property -> project facets
//pom.xml - 프로젝트에 필요한 라이브러리설정
//  <properties>부터 복붙
//web.xml - 프로젝트에 대한 전체 설정 (필터설정)
//  한글인코딩
//  root-context.xml(일반설정 읽어옴)
//     - DB,  MyBatis 설정 
//     - configLocation (mapper)
//     - mapperLocations (sql문작성)
//  servlet-context.xml(웹 설정 읽어옴)
//    - context:component-scan 객체 관리 등록
//설정파일들의 위치는 resources
//  - mybatis-config.xml myBatis설정 typeAliases설정(DTO)
//  - member.xml   sql문 작성, parameter Type, resultType
//  -  guestbook.xml   sql문 작성, parameter Type, resultType
//DAO 
//  - interface만 있음
//  - namespace = package 명 + interface명
//  - id = method 명
//  - DAOImple 없음. Mybatis가 알아서 처리