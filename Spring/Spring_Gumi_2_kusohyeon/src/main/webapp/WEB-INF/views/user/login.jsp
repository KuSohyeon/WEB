<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}"/>
</c:if>
<script type="text/javascript">
$(document).ready(function() {
	$("#loginBtn").click(function() {
		
		if($("#id").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#pw").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else {
			$("#loginform").attr("action", "${root}/user/login").submit();
		}
	});
	 
});
</script>
</head>
<body>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<form id="loginform" method="post" action="">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" value="${saveid}">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pw" name="pw" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
			</div>

			<div class="form-group" align="center">
				<button type="button" id="loginBtn" class="btn btn-warning">로그인</button>
			</div>
		</form>
	</div>
</div>
