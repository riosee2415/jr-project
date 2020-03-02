<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="sub-top-menu">
	<div class="top-menu__box menu-one active">
		<ul class="top-menu__list">
			<c:forEach var="detail" items="${DetailMenuList }" varStatus="status">
				<c:if test="${param.code == detail.PARENT_CODE}" >
					<li id="sub_top_subject-js" class="active"><span><c:out value="${detail.VAL }"></c:out></span></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</div>