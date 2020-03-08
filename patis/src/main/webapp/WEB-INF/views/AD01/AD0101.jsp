<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!-- CONTENT HEADER -->
<div class="ad0101-header">
  <p>로그인기록 관리</p>
</div>
<div class="admin__area">
  <input type="text" />
  <button>검색</button>
</div>
<div class="ad0101-content">
  <table>
    <thead>
      <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>아이피주소</th>
        <th>로그인시간</th>
      </tr>
    </thead>

    <tbody id="ajax-tbody"></tbody>
  </table>

  <ul class="ad0101-paging">
    <li onClick="javascript:getPageContent(1)">«</li>
    <li>
      <c:forEach var="i" begin="1" end="${page }" step="1">
        <li onClick="javascript:getPageContent(${i})">${i }</li>
      </c:forEach>
    </li>

    <li onClick="javascript:getPageContent(${page})">»</li>
  </ul>
</div>

<script src="/assets/js/jquery-1.12.4.min.js"></script>
<script src="/assets/js/admin/AD0101.js"></script>
