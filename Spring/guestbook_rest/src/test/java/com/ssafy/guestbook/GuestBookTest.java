package com.ssafy.guestbook;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.service.GuestBookService;

public class GuestBookTest extends Configure {

	@Autowired
	private GuestBookService guestBookService;
	
	@Test
	public void getArticle() throws Exception {
		GuestBookDto dto = guestBookService.getArticle(41);
		System.out.println(dto.getSubject());
	}
	
	@Test
	public void writeArticle() throws Exception{
		GuestBookDto dto = new GuestBookDto();
		dto.setUserid("ssafy");
		dto.setSubject("test제목");
		dto.setContent("test내용");
		guestBookService.writeArticle(dto);
	}
}
