package com.ssafy.guestbook.model.service;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.dto.GuestBook;
import com.ssafy.guestbook.model.mapper.GuestBookDao;
import com.ssafy.util.PageNavigation;

@Service
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
	private GuestBookDao dao;

	@Override
	public void writeArticle(GuestBook guestBookDto) throws Exception {
		if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
			throw new Exception();
		}
		dao.writeArticle(guestBookDto);
	}

	@Override
	public List<GuestBook> listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		return dao.listArticle(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = dao.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public GuestBook getArticle(int articleno) throws Exception {
		return dao.getArticle(articleno);
	}

	@Override
	public void modifyArticle(GuestBook guestBookDto) throws Exception {
		dao.modifyArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleno) throws Exception {
		dao.deleteArticle(articleno);
	}

}
