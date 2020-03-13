<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sub-banner">
	<div class="sub-banner-overlay"></div>
	<h2 class="sub-banner-title" id="sub-banner-js">
		<c:forEach var="subMenu" items="${subMenuList }" varStatus="status">
			<c:if test="${param.parent == subMenu.PARENT_CODE and param.code == subMenu.DETAIL_CODE}" >
				<c:out value="${subMenu.VAL}" />
			</c:if>
		</c:forEach>
	</h2>
</div>