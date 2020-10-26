package com.ssafy.book.model.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;

	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(Book book,Model model) {
		try {
			service.write(book);
			return "redirect:success";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "책 등록 중 문제가 발생하였습니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/success")
	public void success() {}
	
	@GetMapping("/list")
	public String list(@RequestParam Map<String, String> map, Model model) {
		try {
			List<Book> list = service.list(map);
			model.addAttribute("list", list);
			return "book/list";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/detail")
	public String detail(String isbn, Model model) {
		try {
			Book book = service.detail(isbn);
			model.addAttribute("book", book);
			return "book/detail";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/delete")
	public String delete(String isbn, Model model) {
		try {
			service.delete(isbn);
			return "redirect:list";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
}
