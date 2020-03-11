<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <div class="board-search__area">
          <div class="board-search-type">
            <div class="search-type__box" id="search-type-js">
              <p class="search-type-text">전체</p>
              <i class="fa fa-caret-down" aria-hidden="true"></i>
            </div>
            <ul class="search-type__list" id="search-type-list-js">
              <li class="active">전체</li>
              <li>제목</li>
              <li>내용</li>
            </ul>
          </div>
          <div class="board-search-keyword">
            <input type="text" class="search-keyword" />
            <button type="button" class="search-button"></button>
          </div>
        </div>
      </div>

      <div class="board-list__box">
        <!-- PC버전 -->
        <div class="board-pc-ver" style="display: none">
          <table class="board-list__table">
            <thead>
              <tr>
                <th class="header-5">번호</th>
                <th class="header-title">제목</th>
                <th class="header-15">작성자</th>
                <th class="header-15">날짜</th>
                <th class="header-5">조회</th>
              </tr>
            </thead>

            <tbody id="statute-board-js"></tbody>
          </table>
        </div>

        <!-- 모바일 버전 -->
        <div class="board-mobile-ver">
          <div class="board-mobile-wrap">
            <div>
              <table class="border-list__table2">
                <caption>
                  도시재생 관계법령 모바일.ver
                </caption>
                <thead>
                  <tr>
                    <th>71</th>
                    <th colspan="3">제목</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td colspan="2">작성자</td>
                    <td>2020.03.11.</td>
                    <td>조회수</td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div></div>
          </div>
        </div>
        <ul class="board-pagination" id="board-pagination-js">
          <li
            class="page-control control-double-left"
            onclick="javascript:getStatutePageContent(1)"
          >
            <i class="fa fa-angle-double-left" aria-hidden="true"></i>
          </li>
          <li class="page-control control-left">
            <i class="fa fa-angle-left" aria-hidden="true"></i>
          </li>
          <c:forEach var="i" begin="1" end="${page }" step="1">
            <li
              class="page-number"
              onclick="javascript:getStatutePageContent(${i})"
              >${i}</li
            >
          </c:forEach>
          <li class="page-control control-right">
            <i class="fa fa-angle-right" aria-hidden="true"></i>
          </li>
          <li
            class="page-control control-double-right"
            onclick="javascript:getStatutePageContent(${page})"
          >
            <i class="fa fa-angle-double-right" aria-hidden="true"></i>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <form action="/statute.detail.do" method="get" id="frm-statute-detail">
    <input type="hidden" name="parent" value="${param.parent }" />
    <input type="hidden" name="code" value="${param.code }" />
    <input type="hidden" name="b_no" />
  </form>
</div>
