<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<li onClick="javascript:getPageContent(1)"><i
	class="fa fa-angle-double-left" aria-hidden="true"></i></li>
<c:forEach var="i" begin="1" end="${page }" step="1">
	<li onClick="javascript:getPageContent(${i})">${i }</li>
</c:forEach>

<li onClick="javascript:getPageContent(${page})"><i
	class="fa fa-angle-double-right" aria-hidden="true"></i></li>