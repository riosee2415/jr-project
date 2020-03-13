<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="<c:if test='${param.parent == 3 }'>sub-banner-1</c:if>
			<c:if test='${param.parent == 4 }'>sub-banner-2</c:if>
			<c:if test='${param.parent == 5 }'>sub-banner-3</c:if>
			<c:if test='${param.parent == 8 }'>sub-banner-4</c:if>
			<c:if test='${param.parent == 10 }'>sub-banner-5</c:if>
			<c:if test='${param.parent == 11 }'>sub-banner-6</c:if>
			<c:if test='${param.parent == 12 }'>sub-banner-7</c:if> sub-banner">
	<div class="sub-banner-overlay"></div>
	<h2 class="sub-banner-title" id="sub-banner-js">
		<c:forEach var="subMenu" items="${subMenuList }" varStatus="status">
			<c:if test="${param.parent == subMenu.PARENT_CODE and param.code == subMenu.DETAIL_CODE}" >
				<c:out value="${subMenu.VAL}" />
			</c:if>
		</c:forEach>
	</h2>
</div>