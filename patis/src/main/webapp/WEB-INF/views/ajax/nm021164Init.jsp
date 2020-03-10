<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty boardList }">
		<tr class="row-empty">
			<td colspan="5">조회된 데이터가 없습니다.</td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="board" items="${boardList }">
			<c:choose>
				<c:when test="${board.b_NOTICE eq 1 }">
					<tr class="row-notice">
						<td>공지</td>
						<td class="header-title" onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')">${board.b_TITLE }</td>
						<td>${board.b_AUTHOR }</td>
						<td>${board.b_CREATE_TIME }</td>
						<td>${board.b_HIT }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${board.ROWNUM }</td>
						<td class="header-title" onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')">${board.b_TITLE }</td>
						<td>${board.b_AUTHOR }</td>
						<td>${board.b_CREATE_TIME }</td>
						<td>${board.b_HIT }</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:otherwise>
</c:choose>