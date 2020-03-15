<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="data" items="${list }">
	<li>
		<div>${data.ROWNUM}</div>
		<div>${data.CONNECT_IP}</div>
		<div>${data.CONNECT_DATE}</div>
		<div>${data.CONNECT_OS}</div>
	</li>
</c:forEach>
