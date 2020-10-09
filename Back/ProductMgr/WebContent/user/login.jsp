<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
<style>
.border{
	border:1px solid;
	padding : 20px;
	margin : 20px; auto;
	border-radius:10px;
}

</style>
</head>
<body>
	<div class="container">
	
	<div align=center class="border">
		<h2 align=center><strong>메인 페이지</strong><br></h2>
		<h6 align=center style="color:gray">${msg}<br><br></h6>
			<form action="login.do" method="post" id="login">
				<input type="hidden" name="action" value="LOGIN">
				<div class="form-group">
					<div class="row">
						<div class="col-sm-5">
							<label for="id"><h5>Id</h5></label>
						</div>
						<div class="col-sm-4">
						 	<input type="text" class="form-control" id="id" name="id">
						 </div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-5">
							<label for="pw"><h5>Password</h5></label>
						</div>
						<div class="col-sm-4 ">
							 <input type="password" class="form-control" id="pw" name="pw">
						</div>
					</div>
				</div>
				
					<button id="btn" class="btn btn-success" >Login</button>
			</form>
	</div>
		
	</div>
	<script type="text/javascript">
		$("#btn").click(function(){
			if($("#id").val().trim()==""){
				window.alert("아이디를 입력하세요.");
				return;
			}
			else if($("#pw").val().trim()==""){
				window.alert("비밀번호를 입력하세요.");
				return;
			}
			else{
				$("#login").submit();
			}
		});
	</script>
</body>
</html>