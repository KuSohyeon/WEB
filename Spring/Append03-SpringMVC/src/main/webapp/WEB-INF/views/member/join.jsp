<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<style>
	.content {
		min-height: 500px;
	}	
</style>

<script src="https://kit.fontawesome.com/9617958a58.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div class="content bg-light">
			<h2>회원가입</h2>
			<form action="join.do" method="post">
			  <div class="form-group">
			    <label for="id">아이디</label>
			    <input type="text" class="form-control" id="id" name="id">
			  </div>
			  <div class="form-group">
			    <label for="password">패스워드</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <div class="form-group">
			    <label for="name">이름</label>
			    <input type="text" class="form-control" id="name" name="name">
			  </div>
			  
			  <div class="form-group">
			    <label for="area">지역</label>
			    <select class="form-control" id="area" name="area">
			      <option value="1">광주</option>
			      <option value="2">구미</option>
			      <option value="3">대전</option>
			      <option value="4">서울</option>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label for="classNo">반</label>
			    <input type="text" class="form-control" id="classNo" name="classNo">
			  </div>
			  <button type="submit" class="btn btn-primary">가입</button>
			</form>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
</body>
</html>



