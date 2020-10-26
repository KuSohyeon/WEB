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
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div class="content bg-light">
			내용이 보여질 영역입니다.
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
</body>
</html>





