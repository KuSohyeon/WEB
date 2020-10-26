
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<title>도서 상세</title>
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
	
</head>
<body>
<div class="container mx-auto">
	<h2 class="text-center bg-light mt-5 mb-2 p-2">입력된 도서 정보</h2>
	
	
	<table class="table table-bordered">
		<tr>
			<th colspan="2">상품정보</th>
		</tr>
		<tr>
			<th>아이디</th><td>${product.id}</td>
		</tr>
		<tr>
			<th>상품 번호</th><td>${product.no}</td>
		</tr>
		<tr>
			<th>상품명</th><td>${product.name}</td>
		</tr>
		<tr>
			<th>상품 가격</th><td>${product.price}</td>
		</tr>
		<tr>
			<th>상품 설명</th><td>${product.content}</td>
		</tr>
	</table>
	<p class="text-center">
		<a href="${root}/main/list">상품 목록</a>
		<a href="${root}/main/delete?no=${product.no}">상품 삭제</a>
	</p>
</div>
</body>
</html>