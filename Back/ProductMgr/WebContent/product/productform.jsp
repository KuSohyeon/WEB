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

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#">상품 관리 프로그램</a>
		</nav>
		<h2 class="text-center bg-light mt-5 mb-2 p-2">상품 등록 화면</h2>
		<c:if test="${user ne null}">
			<div align=center>
				<br>
				<p>${user.name}님
					환영합니다!<a href="login.do?action=LOGOUT" id="logout" style="color: gray">
						&nbsp 로그아웃</a>
				</p>

			</div>
		</c:if>
		<div class="text-right">
			<span class="text-warning">*</span> 표시가 된 항목은 필수 입력 항목입니다.
		</div>
		<div class="h40 bg-light mt-3 mb-3"></div>

		<form method="post" action="product.do" id="productForm">
			<input type="hidden" name="action" value="SAVE">
			<!--상품번호-->
			<div class="row form-group">
				<label for="no" class="col-3 pl-5"><span
					class="text-warning">*</span> 상품번호</label>
				<div class="col-9">
					<input type="text" name="no" id="no" size="50">
				</div>
			</div>
			<!--상품명-->
			<div class="row form-group">
				<label for="name" class="col-3 pl-5"><span
					class="text-warning">*</span> 상품명</label>
				<div class="col-9">
					<input type="text" name="name" id="name" size="50">
				</div>
			</div>
			<!--상품가격-->
			<div class="row form-group">
				<label for="price" class="col-3 pl-5"><span>*</span> 상품가격</label>
				<div class="col-9">
					<input type="text" name="price" id="price" size="10" maxlength="6">
					원
				</div>
			</div>
			<!--상품 설명-->
			<div class="row form-group">
				<label for="content" class="col-3 pl-5"><span>*</span> 상품 설명</label>
				<div class="col-9">
					<textarea name="content" id="content" rows="3" cols="50"></textarea>
				</div>
			</div>

			<div
				class="row bg-light mb-3 h50 align-items-center justify-content-center">
				<div class="col-6 text-center">
					<a href="#1" id="btnOk">
						<button type="button" class="btn btn-primary">확인</button>
					</a> <a href="#1" id="btnReset">
						<button type="reset" class="btn btn-warning">취소</button>
					</a> <a href="${root}/main.do">
						<button type="button" class="btn btn-info">돌아가기</button>
					</a>
				</div>
			</div>
		</form>
		<!--정보입력 테이블끝//-->
		<div align=center>
			<a class="select" href="${root}/product.do?action=LIST_PRODUCT">상품목록</a>
		</div>
	</div>

<script type="text/javascript">
	$("#logout").click(function(){
		window.alert("로그아웃 되었습니다.");
	});
	$("#btnOk").click(function(){
		if($("#no").val().trim()==""){
			window.alert("상품 번호를 입력하세요.");
			return;
		}else if($("#name").val().trim()==""){
			window.alert("상품명을 입력하세요.");
			return;
		}else if($("#price").val().trim()==""){
			window.alert("상품 가격을 입력하세요.");
			return;
		}else if($("#content").val().trim()==""){
			window.alert("상품설명을 입력하세요.");
			return;
		}else{
			$("#productForm").submit();
		}
	});

</script>



</body>
</html>