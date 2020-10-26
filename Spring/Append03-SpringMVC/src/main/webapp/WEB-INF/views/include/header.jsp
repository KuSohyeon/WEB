<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
		<header class="bg-primary">
			<nav class="row p-2">
				<div class="col-1">
					<a href="${root}" class="text-white">
						<i class="fas fa-address-card fa-3x"></i>
					</a>
				</div>
				<div class="col-11 text-right my-auto pr-4">
				
					<c:choose>
						<c:when test="${empty sessionScope.member}"> <%-- 로그인이 안된 경우 --%>
							<a href="${root}/member/login" class="text-white">로그인</a>
							<a href="${root}/member/join" class="text-white pl-2">회원가입</a>						
						</c:when>
						<c:otherwise> <%-- 로그인 되어있는 경우 --%>
							<a href="${root}/address/list" class="text-white">주소록</a>
							<a href="${root}/member/logout" class="text-white">로그아웃</a>						
						</c:otherwise>
					</c:choose>
				</div>
			</nav>
		</header>