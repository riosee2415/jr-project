<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="loginLog" items="${loginLogDataList }">
	<tr>
		<td>${loginLog.LOG_NO }</td>
		<td>${loginLog.LOG_ID }</td>
		<td>${loginLog.LOG_IP }</td>
		<td>${loginLog.LOG_DATE }</td>
	</tr>
</c:forEach>