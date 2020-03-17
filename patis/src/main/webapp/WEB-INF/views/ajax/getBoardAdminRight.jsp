<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:forEach var="data" items="${list }">
	<li onclick="javascript:boardNameClickHandler('${data.BOARD_NAME }')">${data.BOARD_NAME }</li>
</c:forEach>