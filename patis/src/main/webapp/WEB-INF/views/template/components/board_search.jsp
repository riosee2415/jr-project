<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div
  class="board-search__area"
  id="search-area-js"
  data-type="${searchType}"
  data-keyword="${searchKeyword}"
>
  <div class="board-search-type">
    <div class="search-type__box" id="search-type-js">
      <p class="search-type-text">전체</p>
      <i class="fa fa-caret-down" aria-hidden="true"></i>
    </div>
    <ul class="search-type__list" id="search-type-list-js">
      <li class="active" data-type="td">전체</li>
      <li data-type="g" class="d-none" id="search-type-gubun">구분</li>
      <li data-type="t">제목</li>
      <li data-type="d">내용</li>
    </ul>
  </div>
  <div class="board-search-keyword">
    <input
      type="text"
      class="search-keyword"
      onkeydown="javascript:boardSearchEnterHandler()"
    />
    <button
      type="button"
      class="search-button"
      onclick="javascript:boardSearchHandler()"
    ></button>
  </div>
</div>
