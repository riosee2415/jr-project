<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="data" items="${userList }">
	<tr onclick="javascript:trClickHandler('${data.USER_ID}')">
		<td>${data.USER_NAME }</td>
		<td>${data.USER_ID }</td>
		<td>${data.USER_RIGHT }</td>
	</tr>
</c:forEach>