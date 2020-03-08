<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="board" items="${boardList }">
	<tr>
		<td><input type="checkbox" /></td>
		<td>${board.b_NO }</td>
		<td>${board.b_TITLE }</td>
		<td>${board.b_AUTHOR }</td>
		<td>${board.b_CREATE_TIME }</td>
		<td>${board.b_UPLOAD_TIME }</td>
		<td>${board.b_HIT }</td>
		<td>${board.b_NOTICE }</td>
		<td>버튼</td>
		<td>버튼</td>
	</tr>
</c:forEach>