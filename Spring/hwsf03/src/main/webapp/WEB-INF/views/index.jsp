<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>상품관리 프로그램</title>
</head>
<style>
.content{
	text-align:center;
	margin : 50px 50px;
	
}
.content>a{
	margin:50px 20px;
	padding: 20px;
	font-size: 30px;
}
</style>
<body>


<div class="container">
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">상품 관리 프로그램</a>
</nav>
  <div class = "content">
  	<img src="./resources/product.jpg"><br><br>
  	<a href="${root}/main/addProduct">상품 등록</a>
  	<a href="${root}/main/list">상품 목록</a>
  </div>
</div>
</body>
</html>