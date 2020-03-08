<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="board" items="${boardList }">
	<tr>
		<td><input type="checkbox" class="ab"/></td>
		<td>${board.b_NO }</td>
		<td>${board.b_TITLE }</td>
		<td>${board.b_AUTHOR }</td>
		<td>${board.b_CREATE_TIME }</td>
		<td>${board.b_UPLOAD_TIME }</td>
		<td>${board.b_HIT }</td>
		<td>
			<c:if test="${board.b_NOTICE eq 0}"><input type="button" id="notice-btn" value="설정" onClick="javascript:noticeBtnHandler(${board.b_NOTICE}, ${board.b_NO}, this)"/></c:if>
			<c:if test="${board.b_NOTICE eq 1}"><input type="button" id="notice-btn" value="해제" onClick="javascript:noticeBtnHandler(${board.b_NOTICE}, ${board.b_NO}, this)"/></c:if>
		</td>
		<td>
			<input type="button" id="notice-btn" value="삭제" onClick="javascript:deleteBtnHandler(${board.b_NO}, this)"/>
		</td>
		<td>${board.b_DELETE_TIME }</td>
	</tr>
</c:forEach>

<script src="/assets/js/admin/AD0215ajax.js"></script>