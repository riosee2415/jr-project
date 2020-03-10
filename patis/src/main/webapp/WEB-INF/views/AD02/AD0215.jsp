<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<div class="ad0101-header">
  <p>게시판 관리 > 공모사업신청 관리</p>
</div>

<div class="admin__area">
  <div class="board-search__area">
    <div class="board-search-type">
      <div class="search-type__box active" id="search-type-js">
        <p class="search-type-text" id="serach-type-text">제목</p>
        <i class="fa fa-caret-down" aria-hidden="true"></i>
      </div>
      <ul
        class="search-type__list"
        id="search-type-list-js"
        style="display: none;"
      >
        <li class="active">제목</li>
        <li>작성자</li>
      </ul>
    </div>
  </div>
  <input type="text" id="searchValue-js" onkeydown="JavaScript:enterCheck()" />
  <button id="search-btn-js" onClick="javascript:serachData()">검색</button>
</div>

<div class="ad02-content">
  <div class="ad02-table" id="ad02-table" data-mc="${param.mc }" data-sc="${param.sc }">
    <table>
      <thead>
        <tr>
          <th><input type="checkbox" class="check-all" /></th>
          <th>글번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성시간</th>
          <th>최근 수정시간</th>
          <th>조회수</th>
          <th>공지사항 설정</th>
          <th>글삭제</th>
          <th>삭제시간</th>
        </tr>
      </thead>

      <tbody id="ajax-tbody"></tbody>
    </table>
  </div>
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

  <div class="ad02-bottom">
    <div class="ad02-bottom__left"></div>

    <div class="ad02-bottom__right">
      <input
        type="button"
        id="checkDel"
        class="btn btn-md btn-red"
        value="일괄삭제"
        onClick="javascript:allDelete()"
      />
    </div>
  </div>
  <div class="modal">
    <div class="modal_box">
      <a href="#" class="modal-X">X</a>
      <div class="modal_box__header mh" id="modal_box__header">
        <div id="mh__no" class="mh__no"></div>
        <div id="mh__title" class="mh__title"></div>
        <div id="mh__author" class="mh__author"></div>
      </div>

      <div class="modal_box__main mm" id="modal_box__main">
        <ul class="mm__list" id="mm__list"></ul>
      </div>
    </div>
  </div>
</div>

<script src="/assets/js/admin/AD0215ajax.js"></script>
<script src="/assets/js/admin/AD0215.js"></script>
