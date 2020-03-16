<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<div class="ad0101-header">
  <p>게시판 관리 > 공지사항(AD0203)</p>
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
  <div
    class="ad02-table"
    id="ad02-table"
    data-mc="${param.mc }"
    data-sc="${param.sc }"
  >
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

  <ul class="ad0101-paging" id="ad0101-paging"></ul>

  <div class="rightArea">
    <div class="rightArea__title">권한 관리</div>
    <div class="rightArea__content">
      <div class="rightArea__content__left">설정</div>
      <div
        class="rightArea__content__right"
        id="rightArea__content__right"
      ></div>
    </div>
    <div class="rightArea__footer">
      <p>
        - 현재 보이는 데이터가 해당 게시판의 읽기, 쓰기 권한입니다.
      </p>
      <p>
        - 게시판 별 읽기, 쓰기 권한을 설정할 수 있습니다.
      </p>
      <p>
        - 수정은 작성자 본인만 가능하며, 삭제는 관리자모드에서만 가능합니다.
      </p>
    </div>
  </div>

  <div class="modal-01">
    <div class="modal_box">
      <header class="modal-header">
        <div>댓글관리</div>
        <a href="javascript:closeModal()" class="modal-X">
          <i class="fa fa-times-circle" aria-hidden="true"></i>
        </a>
      </header>

      <div class="modal_box__main mm" id="modal_box__main">
        <div class="modal_box__header mh" id="modal_box__header">
          <div id="mh__no" class="mh__no"></div>
          <div id="mh__title" class="mh__title"></div>
          <div id="mh__author" class="mh__author"></div>
        </div>
        <ul class="mm__list" id="mm__list"></ul>
      </div>
    </div>
  </div>
</div>

<script src="/assets/js/admin/AD_board_ajax.js"></script>
<script src="/assets/js/admin/AD_board.js"></script>
