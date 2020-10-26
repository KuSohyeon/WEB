<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
</head>
<style>
h1{
	text-align:center;
}
#place{
margin : 20px;
}
td{
	border : 1px solid black;
	
}
input {
    border: none;
    background: transparent;
}
#pcontent{
	border: 1px solid black;
	width:220px;
	height:100px;
}

</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#download").click(function(){
		//상품 목록
		$.ajax({
			url:'${root}/admin/product',  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(products) {
				makeList(products);
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + xhr.status + " Http에러메시지 : "+xhr.responseText);
			}
		});
	});
	
	// 상품 디테일 정보
	$(document).on("dblclick","li.view",function(){
		let vid = $(this).attr("data-id");
		$.ajax({
			url : '${root}/admin/product/'+vid,
			type : 'GET',
			contentType:'application/json;charset=utf-8',
			success:function(product){
				$("#pid").val(product.id);
				$("#pname").val(product.name);
				$("#pprice").val(product.price);
				$("#pcontent").val(product.content);
				$("#result").text("세부 정보 불러오기");
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
			}
		});
	});
	
	// 상품 정보 수정
	$(document).on("click", "#modify", function() {
		let modifyinfo = JSON.stringify({
					"id" : $("#pid").val(),
					"name" : $("#pname").val(),
					"price" : $("#pprice").val(),
					"content" : $("#pcontent").val()
				   });
		$.ajax({
			url:'${root}/admin/product',  
			type:'PUT',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			data: modifyinfo,
			success:function(users) {
				makeList(users);
				$("#result").text("수정 완료");
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
			}
		});

	});
	
	// 상품 등록
	$(document).on("click", "#add", function() {
		let modifyinfo = JSON.stringify({
					"id" : $("#pid").val(),
					"name" : $("#pname").val(),
					"price" : $("#pprice").val(),
					"content" : $("#pcontent").val()
				   });
		$.ajax({
			url:'${root}/admin/product',  
			type:'POST',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			data: modifyinfo,
			success:function(users) {
				makeList(users);
				$("#pid").val('');
				$("#pname").val('');
				$("#pprice").val('');
				$("#pcontent").val('');
				$("#result").text("등록 완료");
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
			}
		});
	
	});
	
	$(document).on("click","#delete",function(){
		if(confirm("정말 삭제하시겠습니까?")){
			let delid = $("#pid").val();
			console.log(delid);
			$.ajax({
				url : '${root}/admin/product/'+delid,
				type : 'DELETE',
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				success:function(products){
					makeList(products);
					$("#pid").val('');
					$("#pname").val('');
					$("#pprice").val('');
					$("#pcontent").val('');
					$("#result").text("삭제 완료");
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});
		}

	});
	
});

function makeList(products) {
	$("#listplace").empty();
	$(products).each(function(index, product) {
		let str = "<li id=\"view_" + product.id + "\" class=\"view\" data-id=\"" + product.id + "\">"
		+ product.id
		+ "</li>";
		$("#listplace").append(str);
	});//each
}
</script>
<body>
<h1>Welcome To SSAFY</h1>
<hr>
<h2>상품관리</h2>
<button id="download">목록조회</button>(상세 내용을 조회하기 위해서 목록의 아이템을 더블클릭하세요.)
<div id = "place">
<ul id="listplace">
</ul>
</div>



<div>
	<button id="add">추가</button>
	<button id="modify">수정</button>
	<button id="delete">삭제</button>
</div>
<div>
	<table>
		<tr>
			<th colspan="2">상품 정보<th>
		<tr>
		<tr>
			<td>id</td>
			<td><input type="text" id="pid"></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" id="pname"></td>
		</tr>
		<tr>
			<td>price</td>
			<td><input type="text" id="pprice"></td>
		</tr>
	</table>
	
	<div id="contentplace">
		<input type="text" id="pcontent">
	</div>
	<div id="result"></div>
</div>


</body>
</html>