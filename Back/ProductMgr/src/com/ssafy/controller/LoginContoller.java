package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.MemberDto;
import com.ssafy.model.service.LoginService;
import com.ssafy.model.service.LoginServiceImpl;

@WebServlet("/login.do")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = LoginServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("LOGIN".equals(action)) {
			login(request,response);
		}else if("LOGOUT".equals(action)) {
			logout(request,response);
		}
		else {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}



	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			MemberDto param = new MemberDto();
			param.setId(id);
			param.setPw(pw);
			MemberDto member = service.login(param);

			if(member!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", member);
				response.sendRedirect(request.getContextPath()+"/main.do");
			}else {
				System.out.println("그런 회원이 존재하지 않습니다.");
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
				request.getRequestDispatcher("/main.do").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
