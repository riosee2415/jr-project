<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="board-pagination" id="board-pagination-js">
	<li class="page-control control-double-left" onclick="javascript:getPageContent(1)">
		<i class="fa fa-angle-double-left" aria-hidden="true"></i>
	</li>
	<li class="page-control control-left">
		<i class="fa fa-angle-left" aria-hidden="true"></i>
	</li>
	<c:forEach var="i" begin="1" end="${page }" step="1">
		<li class="page-number" onclick="javascript:getPageContent(${i})">${i}</li>
	</c:forEach>
	<li class="page-control control-right">
		<i class="fa fa-angle-right" aria-hidden="true"></i>
	</li>
	<li class="page-control control-double-right" onclick="javascript:getPageContent(${page})">
		<i class="fa fa-angle-double-right" aria-hidden="true"></i>
	</li>
</ul>