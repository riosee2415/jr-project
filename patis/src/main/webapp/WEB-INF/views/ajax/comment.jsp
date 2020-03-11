<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%  pageContext.setAttribute("crlf", "\r\n");  %>
<%  pageContext.setAttribute("br", "<br/>");  %>

<div class="comment-list__area">
	<c:forEach var="comment" items="${commentList}">
		<div class="comment-list__box">
			<div class="list-top__box">
				<ul>
					<li class="data-user">
						<i class="fa fa-user-o" aria-hidden="true"></i>
						<span>${comment.CO_AUTHOR}</span>
					</li>
					<li class="data-time">
						<i class="fa fa-clock-o" aria-hidden="true"></i>
						<span>${comment.CO_CREATE_TIME}</span>
					</li>
				</ul>
			</div>
			<div class="list-bottom__box">
				<div class="comment-desc">${comment.CO_DESCRIPTION}</div>
				
				<c:if test="${comment.CO_USER_ID eq sessionScope.loginId}">
					<div class="comment-btn">
						<button type="button" onclick="javascript:boardCommentModify('${comment.CO_NO}', '${comment.CO_DESCRIPTION}')">수정</button>
						<button type="button" onclick="javascript:boardCommentRemove('${comment.CO_NO}')">삭제</button>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>
</div>