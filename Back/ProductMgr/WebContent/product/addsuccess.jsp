<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>상품 관리 프로그램</title>
<style>
.select {
	font-size:30px;
	margin: 100px 30px;
	padding: 10px;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#">상품 관리 프로그램</a>
		</nav>
		<div align=center>
			<br>
			<h2 class="bg-light">상품 등록이 성공하였습니다.</h2>
			<br>
			<a class="select" href="${root}/product.do?action=ADD_PRODUCT_FORM">상품 등록</a> 
			<a class="select" href="${root}/product.do?action=LIST_PRODUCT">상품 목록</a> 
		</div>

	</div>



</body>
</html>