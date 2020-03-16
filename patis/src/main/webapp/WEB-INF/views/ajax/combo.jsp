<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<c:forEach var="data" items="${combo }">
	<option value="${data.DETAIL_CODE }">${data.VAL }</option>
</c:forEach>


