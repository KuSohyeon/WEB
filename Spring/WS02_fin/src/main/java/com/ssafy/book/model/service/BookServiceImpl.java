package com.ssafy.book.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper mapper;
	
	@Override
	public void write(Book book) throws Exception {
		mapper.write(book);
	}

	@Override
	public List<Book> list(Map<String, String> map) throws Exception {
		Map<String,String> param = new HashMap<String, String>();
		param.put("key", map.get("key")==null?"":map.get("key"));
		param.put("word", map.get("word")==null?"":map.get("word"));
		
		return mapper.list(param);
	}

	@Override
	public Book detail(String isbn) throws Exception {
		return mapper.detail(isbn);
	}

	@Override
	public void delete(String isbn) throws Exception {
		mapper.delete(isbn);
	}

}
