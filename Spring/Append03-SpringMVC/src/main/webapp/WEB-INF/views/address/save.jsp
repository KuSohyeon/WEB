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
			<h2>주소록</h2>
			<form action="save" method="post">
			  <div class="form-group">
			    <label for="name">이름</label>
			    <input type="text" class="form-control" id="name" name="name">
			  </div>
			  
			  <div class="form-group">
			    <label for="email">이메일</label>
			    <input type="text" class="form-control" id="email" name="email">
			  </div>
			  
			  <div class="form-group">
			    <label for="birth">생년월일</label>
			    <input type="text" class="form-control" id="birth" name="birth">
			  </div>
			  
			  <div class="form-group">
			    <label for="address">주소</label>
			    <input type="text" class="form-control" id="address" name="address">
			  </div>

			  <div class="form-group">
			    <label for="areaCode">지역</label>
			    <select class="form-control" id="areaCode" name="areaCode">
			      <option value="0001">광주</option>
			      <option value="0002">구미</option>
			      <option value="0003">대전</option>
			      <option value="0004">서울</option>
			    </select>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">등록</button>
			</form>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
</body>
</html>



