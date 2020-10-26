package com.ssafy.book.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.book.model.dto.Book;

public interface BookService {
	
	public void write(Book book) throws Exception;
	public List<Book> list (Map<String, String> map) throws Exception;
	public Book detail(String isbn) throws Exception;
	public void delete(String isbn) throws Exception;
}
