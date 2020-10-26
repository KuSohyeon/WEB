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
<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div class="content bg-light">
			<h2>싸피 주소록</h2>
			<form action="delete-all" method="post">
			<table class="table tbl-bordered">
			<tr>
				<th><label for="all">전체</label><input type="checkbox" name="all" id="all"></th>
				<th>이름</th>
				<th>이메일</th>
				<th>생일</th>
				<th>주소</th>
				<th></th>
			</tr>
			<c:forEach var="addressDto" items="${ssafyAddressList}">
			<tr>
				<td><input type="checkbox" name="addressNo" value="${addressDto.no}"></td>
				<td>${addressDto.name}</td>
				<td>${addressDto.email}</td>
				<td>${addressDto.birth}</td>
				<td>${addressDto.address}</td>
				<td><a href="delete?no=${addressDto.no}" class="btn btn-primary">삭제</a></td>
			</tr>
			</c:forEach>
			
			<c:if test="${empty ssafyAddressList}">
			<tr>
				<td colspan="5" class="text-center">주소록이 존재하지 않습니다.</td>
			</tr>	
			</c:if>
			
			</table>
			
			<div class="text-right">
				<a href="save" class="btn btn-warning">등록</a>
				<button class="btn btn-warning">전체삭제</button>
			</div>
			</form>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
	<script>
		$("#all").click(function () {
			$("input[name='addressNo']").prop("checked", this.checked);
		});
	
	</script>
</body>
</html>















