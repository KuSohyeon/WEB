
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>상품 등록</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
	.container {
		width: 700px;
	}
	.h40 { height: 40px; }
	.h50 { height: 50px; }
	.bottom__content {
		font-family: 굴림체;
		font-size: small;
		color: rgb(0, 0, 128);
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	
</head>
<body>
<div class="container mx-auto">
	<h2 class="text-center bg-light mt-5 mb-2 p-2">상품 등록 화면</h2>
	
	<div class="text-right">
		<span class="text-warning">*</span> 표시가 된 항목은 필수 입력 항목입니다.
	</div>
	<div class="h40 bg-light mt-3 mb-3"></div>
	
	<form method="post" action="save" id="productForm">

		<!--아이디-->
		<div class="row form-group">
			<label for="no" class="col-3 pl-5"><span class="text-warning">*</span> 아이디</label>
			<div class="col-9">
				<input type="text" name="id" id="id" size="50">
			</div>			
		</div>	
		<!--상품명-->
		<div class="row form-group">
			<label for="name" class="col-3 pl-5"><span class="text-warning">*</span> 상품명</label>
			<div class="col-9">
				<input type="text" name="name" id="name" size="50">
			</div>			
		</div>	
		<!--상품가격-->
		<div class="row form-group">
			<label for="price" class="col-3 pl-5"><span>*</span> 상품가격</label>
			<div class="col-9">
				<input type="text" name="price" id="price" size="10" maxlength="6">
				<select name="currency" id="currency" tabindex="13">
					<option value="원" selected>원</option>
					<option value="달러">달러</option>
				</select>
			</div>			
		</div>			
		<!--상품 설명-->
		<div class="row form-group">
			<label for="content" class="col-3 pl-5"><span>*</span> 상품 설명</label>
			<div class="col-9">
				<textarea name="content" id="content" rows="3" cols="50"></textarea>
			</div>			
		</div>							
		
		<div class="row bg-light mb-3 h50 align-items-center justify-content-center">
			<div class="col-6 text-center">

				<button type="button" class="btn btn-primary" id="btnOk">확인</button> 
				
				<a href="#1" id="btnReset">
					<button type="button" class="btn btn-warning">취소</button>
				</a>
				<a href="${root}/">
				  <button type="button" class="btn btn-info">돌아가기</button>
				</a>
			</div>
		</div>
	</form>
	<!--정보입력 테이블끝//-->
	
	<div class="text-center bottom__content">	
		사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터<BR> 
		Copyright ⓒ 2020. SCSA. All Rights Reserved.
	</div>
</div>
<script>
	$("#btnOk").click(function() {	
		
		if (formChk(['id','name']) == false) {
			return false;
		}
		console.log("click!!");
		$('#productForm').submit();
		console.log("submit!!")
	});
	
	$('#btnReset').click(function() {
		$('#productForm')[0].reset();
	});
	
	function formChk(elements) {
		let result = true;
		$.each(elements, function(index, element) {
			let $ele = $(`#\${element}`);
			let msg = '필수 입력항목입니다. 내용을 입력하세요';
			if ($ele.prop('tagName') == 'SELECT') {
				msg = '항목을 선택하세요';
			}
			if ($ele.val().trim() == '') {
				alert(msg);
				$ele.focus();
				result = false;
				return false;
			}
		});
		return result;
	}
	
</script>
</body>
</html>