<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="data" items="${list }">
	<li>
		<div>${data.ROWNUM}</div>
		<div>${data.LOG_ID}</div>
		<div>${data.LOG_IP}</div>
		<div>${data.LOG_DATE}</div>
	</li>
</c:forEach>
