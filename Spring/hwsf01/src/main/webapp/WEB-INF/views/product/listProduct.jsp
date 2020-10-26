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
<style>
	.container {
		width: 700px;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script type="text/javascript">
		
		function searchArticle() {
			document.getElementById("searchform").action = "${root}/main/list";
			document.getElementById("searchform").submit();
		}
		</script>	
</head>
<body>
<div class="container mx-auto">
	<h2 class="text-center bg-light mt-5 mb-2 p-2">상품 목록 화면</h2>
	<form id="searchform" method="get" class="form-inline" action="">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="name" selected="selected">상품명</option>
			    <option value="price">가격</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchArticle();">검색</button>
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
			<td><a href="${root}/main/detail?no=${product.no}">${product.name}</a></td>
			<td>${product.price}</td>
			<td>${product.content}</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
	<p class="text-center">
		<a href="${root}/main/addProduct">상품 등록</a>
	</p>
</div>
</body>
</html>