<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!-- CONTENT HEADER -->
<div class="ad0101-header">
  <p>회원관리 > 로그인기록 관리(AD0101)</p>
</div>
<div class="admin__area">
  <!-- <div class="board-search__area"> -->
    <!-- <div class="board-search-type"> -->
      <!-- <div class="search-type__box active" id="search-type-js"> -->
       <!--  <p class="search-type-text">전체</p> -->
      <!--  <i class="fa fa-caret-down" aria-hidden="true"></i> --> 
      <!-- </div> -->
      <!-- <ul
        class="search-type__list"
        id="search-type-list-js"
        style="display: none;"
      >
        <li class="active">전체</li>
        <li>아이디</li>
        <li>아이디주소</li>
      </ul> -->
   <!--  </div>  -->
  <!-- </div> -->
 <!--  <input type="text" />
  <button>검색</button> -->
 
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
</div>
<div class="ad0101-paging-box">
  <ul class="ad0101-paging">
    <li onClick="javascript:getPageContent(1)">
      <i class="fa fa-angle-double-left" aria-hidden="true"></i>
    </li>
    <c:forEach var="i" begin="1" end="${page }" step="1">
      <li onClick="javascript:getPageContent(${i})">${i }</li>
    </c:forEach>

    <li onClick="javascript:getPageContent(${page})">
      <i class="fa fa-angle-double-right" aria-hidden="true"></i>
    </li>
  </ul>
</div>

<script src="/assets/js/admin/AD0101.js"></script>
