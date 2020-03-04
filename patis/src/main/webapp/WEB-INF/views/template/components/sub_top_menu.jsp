<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="sub-top-menu">
	<div class="top-menu__box">
		<ul id="sub_top_subject-js" class="top-menu__list">
			<c:forEach var="detail" items="${DetailMenuList }" varStatus="status">
				<c:if test="${param.code == detail.PARENT_CODE}" >
					<c:set value="${menuCount + 1 }" var="menuCount" />
					<li class="<c:out value="${menuCount eq 1 ? 'active' : ''}" />" onclick="_topMenuClickHandler('${menuCount}', '${detail.VAL}')">
						<span><c:out value="${detail.VAL }"></c:out></span>
					</li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</div>