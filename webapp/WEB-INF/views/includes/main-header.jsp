<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 	<a href="${pageContext.request.contextPath }/">
			<img class="logo" src="${pageContext.request.contextPath }/assets/images/logo.jpg">
		</a>
		<ul class="menu">
		
		 		
			<!-- 로그인 전 메뉴 -->
			<c:if test="${ empty sessionScope.authUser }">
			<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
 			</c:if>
 			
			<!-- 로그인 후 메뉴 -->
			<c:if test="${not empty sessionScope.authUser }">
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath}/${authUser.id}">내블로그</a></li>
		</c:if>
 		</ul>
 		