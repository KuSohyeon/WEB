<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
			<form action="delete-all" method="post" id="form">
			<table class="table tbl-bordered">
			<tr>
				<th><label for="all">전체</label><input type="checkbox" name="all" id="all"></th>
				<th>국가번호</th>
				<th>국가명</th>
				<th>환진자수</th>
				<th>지역</th>
				<th></th>
			</tr>
			<c:forEach var="nation" items="${list}">
			<tr>
				<td><input type="checkbox" name="nationCcode" value="${nation.ccode}"></td>
				<td>${nation.ccode}</td>
				<td>${nation.cname}</td>
				<td>${nation.patient}</td>
				<c:if test="${nation.rcode=='na'}">
					<td>북아메리카</td>
				</c:if>
				<c:if test="${nation.rcode=='as'}">
					<td>아시아</td>
				</c:if>
				<c:if test="${nation.rcode=='eu'}">
					<td>유럽</td>
				</c:if>
				
				<td><a href="delete?ccode=${nation.ccode}" class="btn btn-primary">삭제</a></td>
			</tr>
			</c:forEach>
			
			<c:if test="${empty list}">
			<tr>
				<td colspan="5" class="text-center">주소록이 존재하지 않습니다.</td>
			</tr>	
			</c:if>
			
			</table>
			
			<div class="text-right">
				<a href="regist" class="btn btn-warning">등록</a>
				<button class="btn btn-warning" id="deleteAll">선택삭제</button>
			</div>
			</form>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
	<script>
		$("#all").click(function () {
			$("input[name='nationCcode']").prop("checked", this.checked);
		});
		$("#deleteAll").click(function(){
			$("#form").submit();
		});
	
	</script>
</body>
</html>















