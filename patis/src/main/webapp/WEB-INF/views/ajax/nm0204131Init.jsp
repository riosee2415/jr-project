<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="board" items="${boardList }">
	<c:choose>
		<c:when test="${board.b_NOTICE eq 1 }">
			<tr class="row-notice">
				<td>공지</td>
				<td class="header-title" onclick="javascript:goStatuteDetailHandler('${board.b_NO}')">${board.b_TITLE }</td>
				<td>${board.b_AUTHOR }</td>
				<td>${board.b_CREATE_TIME }</td>
				<td>${board.b_HIT }</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td>${board.b_NO }</td>
				<td class="header-title" onclick="javascript:goStatuteDetailHandler('${board.b_NO}')">${board.b_TITLE }</td>
				<td>${board.b_AUTHOR }</td>
				<td>${board.b_CREATE_TIME }</td>
				<td>${board.b_HIT }</td>
			</tr>
		</c:otherwise>
	</c:choose>
</c:forEach>