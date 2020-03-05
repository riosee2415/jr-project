<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	/* out.println(session.getAttribute("loginId"));
	out.println(session.getAttribute("loginName"));
	out.println(session.getAttribute("loginRight")); */
%>

<div class="admin-main-box">
	<div class="admin-main-box__top">
		<h2 class="admin-main-title">회원관리</h2>
		<div class="admin-main-control__box">
			<button type="button">선택수정</button>
			<button type="button">선택삭제</button>
			<button type="button">회원추가</button>
		</div>
	</div>
	
	<div class="admin-main-box__content">
		<h2>CONTENT</h2>
	</div>
</div>