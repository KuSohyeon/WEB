<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/9617958a58.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div class="content bg-light">
			<div class="col-6 mx-auto mt-5">
				<c:if test="${not empty msg}">
					<p class="text-center">${msg}</p>
				</c:if>
				<form id="loginform" method="post" action="login">
					<div class="form-group">
						<input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력" value="">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password" name="password" placeholder="패스워드 입력">
					</div>
					<div class="form-group row" align="center">
						<button type="button" id="loginBtn" class="btn btn-warning ml-4 col-5">로그인</button>
						<button type="button" id="joinBtn" class="btn btn-primary col-5 ml-2">회원가입</button>
					</div>
				</form>
			</div>
			
			<script>
			$("#loginBtn").click(function() {
				if ($('#id').val().trim() == '') {
					alert('아이디를 입력하세요');
					$('#id').focus();
					return;
				}
				if ($('#password').val().trim() == '') {
					alert('패스워드를 입력하세요');
					$('#password').focus();
					return;
				}
				$("#loginform").submit();
			});
			
			$("#joinBtn").click(function() {
				location.href = "${pageContext.request.contextPath}/member/join";
			});
			</script>	
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>
</body>
</html>