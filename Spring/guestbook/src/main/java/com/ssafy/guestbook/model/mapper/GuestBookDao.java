package com.ssafy.guestbook.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.guestbook.model.dto.GuestBook;

public interface GuestBookDao {

	public void writeArticle(GuestBook guestBookDto) throws SQLException;
	public List<GuestBook> listArticle(Map<String, Object> map) throws SQLException;
	public int getTotalCount(Map<String, String> map) throws SQLException;
	
	public GuestBook getArticle(int articleno) throws SQLException;
	public void modifyArticle(GuestBook guestBookDto) throws SQLException;
	public void deleteArticle(int articleno) throws SQLException;
	
}
