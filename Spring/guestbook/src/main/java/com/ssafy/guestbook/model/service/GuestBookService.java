package com.ssafy.guestbook.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.guestbook.model.dto.GuestBook;
import com.ssafy.util.PageNavigation;

public interface GuestBookService {

	public void writeArticle(GuestBook guestBookDto) throws Exception;
	public List<GuestBook> listArticle(Map<String, String> map) throws Exception;
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
	public GuestBook getArticle(int articleno) throws Exception;
	public void modifyArticle(GuestBook guestBookDto) throws Exception;
	public void deleteArticle(int articleno) throws Exception;
	
}
