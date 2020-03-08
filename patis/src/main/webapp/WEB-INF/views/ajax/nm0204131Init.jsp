<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="statute" items="${statuteList }">
	<c:choose>
		<c:when test="${statute.b_NOTICE eq 1 }">
			<tr class="row-notice">
				<td>공지</td>
				<td class="header-title">${statute.b_TITLE }</td>
				<td>${statute.b_AUTHOR }</td>
				<td>${statute.b_CREATE_TIME }</td>
				<td>${statute.b_HIT }</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td>${statute.b_NO }</td>
				<td class="header-title">${statute.b_TITLE }</td>
				<td>${statute.b_AUTHOR }</td>
				<td>${statute.b_CREATE_TIME }</td>
				<td>${statute.b_HIT }</td>
			</tr>
		</c:otherwise>
	</c:choose>
</c:forEach>