<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

body, p {
	text-align: center;
}

#bookTable th{
	text-align: right;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable tr:nth-child(2n) {
	text-align: center;
	background-color: lightgray;
}


#bookTable td {
	width: 100px;
}

#bookTable td:nth-child(2) {
	width: 300px;
}
#bookTable td:nth-child(1) {
	width: 150px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#searchBtn").click(function() {
		
		if($("#sword").val() == "") {
			alert("모든 목록 조회!!");
		} 
		$("#searchform").attr("action", "${root}/book/list").submit();
	});
	
	
});

</script>
</head>
<body>
	<h1>도서 목록 화면</h1>
	<div align="right">
	 <form id="searchform" method="get" class="form-inline" action="">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="skey">
			    <option value="title" selected="selected">책제목</option>
			    <option value="publisher">출판사</option>
			    <option value="price">가격</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="sword">
			  <button type="button" id="searchBtn" class="btn btn-primary">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	  <br>
	  </div>

	<table id="bookTable">
		
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>도서분류</td>
			<td>저자</td>
			<td>가격</td>
		</tr>
	<c:if test="${list !=null}">
		<c:forEach var="book" items = "${list}">
			<tr>
				<td>${book.isbn}</td>
				<td><a href="${root}/book/detail?isbn=${book.isbn}">${book.title}</a></td>
				<td>${book.catalogue}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</c:if>
	
	<c:if test="${empty list}">
		<tr>
		<td colspan="5">조회할 수 있는 책이 없습니다.</td>
		</tr>
	</c:if>
	</table>
	<div id="result"></div>
	<p>
		<a href='${root}/book/write'>도서 등록</a> <a href='${root}/'>메인페이지</a> 
	</p>
</body>
</html>
