<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="collusion" items="${collusionList }">
	<c:choose>
		<c:when test="${collusion.b_NOTICE eq 1 }">
			<tr class="row-notice">
				<td>공지</td>
				<td class="header-title">${collusion.b_TITLE }</td>
				<td>${collusion.b_AUTHOR }</td>
				<td>${collusion.b_CREATE_TIME }</td>
				<td>${collusion.b_HIT }</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td>${collusion.b_NO }</td>
				<td class="header-title">${collusion.b_TITLE }</td>
				<td>${collusion.b_AUTHOR }</td>
				<td>${collusion.b_CREATE_TIME }</td>
				<td>${collusion.b_HIT }</td>
			</tr>
		</c:otherwise>
	</c:choose>
</c:forEach>