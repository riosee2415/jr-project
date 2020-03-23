<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
prefix="fn" %>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="subTitle_wrap">
        <div class="subTitle_2">일정목록 및 신청</div>
      </div>

      <div class="board-search__box">
        <%@ include file="/WEB-INF/views/template/components/board_search.jsp"
        %>
      </div>

      <div
        class="board-list__box"
        id="board-list-js"
        data-btype="${b_type_1}"
        data-parent="${param.parent}"
        data-code="${param.code}"
      >
        <!-- PC버전 -->
        <div class="board-pc-ver">
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

            <tbody id="${fn:toLowerCase(b_type_1)}-board-js"></tbody>
          </table>
        </div>

        <!-- 모바일 버전 -->
        <div class="board-mobile-ver">
          <div
            class="board-mobile-wrap"
            id="${fn:toLowerCase(b_type_1)}-board-m-js"
          ></div>
        </div>

        <div id="${fn:toLowerCase(b_type_1)}-paging-js"></div>

        <div class="board-btn__box" id="${fn:toLowerCase(b_type_1)}-button-js">
          <c:if test="${sessionScope.loginRight <= AcceptRight_1.WRITE_RIGHT}">
            <button
              type="button"
              onclick="javascript:boardWriteMoveHandler('${b_type_1}', '${searchType}', '${searchKeyword}')"
              >글쓰기</button
            >
          </c:if>
        </div>
      </div>

      <form
        action="/academy.detail.do"
        method="get"
        id="frm-${fn:toLowerCase(b_type_1)}-detail"
      >
        <input type="hidden" name="parent" value="${param.parent }" />
        <input type="hidden" name="code" value="${param.code }" />
        <input type="hidden" name="tab" value="1" />
        <input type="hidden" name="b_no" />
        <input type="hidden" name="rownum" />
        <input type="hidden" name="s_type" />
        <input type="hidden" name="s_keyword" />
      </form>

      <form
        action="/academy.write.do"
        method="get"
        id="frm-${fn:toLowerCase(b_type_1)}-write"
      >
        <input type="hidden" name="parent" value="${param.parent }" />
        <input type="hidden" name="code" value="${param.code }" />
        <input type="hidden" name="tab" value="1" />
        <input type="hidden" name="s_type" />
        <input type="hidden" name="s_keyword" />
        <input type="hidden" name="mode" value="WRITE" />
      </form>
    </div>

    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <%@ include file="/WEB-INF/views/template/components/board_search.jsp"
        %>
      </div>

      <div
        class="board-list__box"
        id="board-list-js"
        data-btype="${b_type_2}"
        data-parent="${param.parent}"
        data-code="${param.code}"
      >
        <!-- PC버전 -->
        <div class="board-pc-ver">
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

            <tbody id="${fn:toLowerCase(b_type_2)}-board-js"></tbody>
          </table>
        </div>

        <!-- 모바일 버전 -->
        <div class="board-mobile-ver">
          <div
            class="board-mobile-wrap"
            id="${fn:toLowerCase(b_type_2)}-board-m-js"
          ></div>
        </div>

        <div id="${fn:toLowerCase(b_type_2)}-paging-js"></div>

        <div class="board-btn__box" id="${fn:toLowerCase(b_type_2)}-button-js">
          <c:if test="${sessionScope.loginRight <= AcceptRight_2.WRITE_RIGHT}">
            <button
              type="button"
              onclick="javascript:boardWriteMoveHandler('${b_type_2}', '${searchType}', '${searchKeyword}')"
              >글쓰기</button
            >
          </c:if>
        </div>
      </div>

      <form
        action="/academy.detail.do"
        method="get"
        id="frm-${fn:toLowerCase(b_type_2)}-detail"
      >
        <input type="hidden" name="parent" value="${param.parent }" />
        <input type="hidden" name="code" value="${param.code }" />
        <input type="hidden" name="tab" value="2" />
        <input type="hidden" name="b_no" />
        <input type="hidden" name="rownum" />
        <input type="hidden" name="s_type" />
        <input type="hidden" name="s_keyword" />
      </form>

      <form
        action="/academy.write.do"
        method="get"
        id="frm-${fn:toLowerCase(b_type_2)}-write"
      >
        <input type="hidden" name="parent" value="${param.parent }" />
        <input type="hidden" name="code" value="${param.code }" />
        <input type="hidden" name="tab" value="2" />
        <input type="hidden" name="s_type" />
        <input type="hidden" name="s_keyword" />
        <input type="hidden" name="mode" value="WRITE" />
      </form>
    </div>
  </div>

  <script>
    window.onload = function() {
      var tab = "${tab}";
      _topMenuActiveInit(tab);
    };
  </script>
</div>
