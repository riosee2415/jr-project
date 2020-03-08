<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="ad0101-header">
	<p>게시판 관리 > 공모사업신청 관리</p>
</div>

<div class="admin__area">
	<input type="text" />
	<button>검색</button>
</div>

<div class="ad02-content">
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" /></th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>최근 수정시간</th>
				<th>조회수</th>
				<th>공지사항 여부</th>
				<th>공지사항 설정</th>
				<th>글삭제</th>
				<th>삭제시간</th>
			</tr>
		</thead>

		<tbody id="ajax-tbody">

		</tbody>
	</table>

	<ul class="ad0101-paging">
		<li onClick="javascript:getPageContent(1)">«</li>
		<li><c:forEach var="i" begin="1" end="${page }" step="1">
				<li onClick="javascript:getPageContent(${i})">${i }</li>
			</c:forEach></li>

		<li onClick="javascript:getPageContent(${page})">»</li>
	</ul>
</div>


<script src="/assets/js/admin/AD0215.js"></script>