<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<style>
.select {
	font-size: 30px;
	margin: 100px 30px;
	padding: 10px;
	font-weight: bold;
}</style>
</head>
<body>
<div class="container">
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#">상품 관리 프로그램</a>
		</nav>
		<h2 class="text-center bg-light mt-5 mb-2 p-2">상품 목록 화면</h2>
		<c:if test="${user ne null}">
			<div align=center>
				<br>
				<p>${user.name}님
					환영합니다!<a href="login.do?action=LOGOUT" id="logout" style="color: gray">
						&nbsp 로그아웃</a>
				</p>

			</div>
		</c:if>
	<form id="searchform" method="get" class="form-inline" action="product.do">
	  <input type="hidden" name="action" value="LIST_PRODUCT">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="name" selected="selected">상품명</option>
			    <option value="price">가격</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word">
			  <button type="submit" class="btn btn-primary">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	<table class="table table-bordered">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품설명</th>
		</tr>
		<c:if test="${list.size() ne 0}">
		<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.no}</td>
			<td><a href="${root}/product.do?action=DETAIL&no=${product.no}">${product.name}</a></td>
			<td>${product.price}</td>
			<td>${product.content}</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
	
	<div align=center>
	<br>
			<a class="select" href="${root}/product.do?action=ADD_PRODUCT_FORM">상품 등록</a> 
			<a class="select" href="${root}/main.do">메인 페이지</a>
			<a class="select" href="${root}/product.do?action=LAST_PRODUCT">이번주 신상</a>
		</div>

</div>
</body>
</html>