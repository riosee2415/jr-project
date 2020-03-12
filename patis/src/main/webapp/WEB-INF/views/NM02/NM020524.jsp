<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <%@ include file="/WEB-INF/views/template/components/board_search.jsp" %>
      </div>

      <div class="board-list__box" id="board-list-js" data-btype="${b_type}" data-parent="${param.parent}" data-code="${param.code}">
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

          <tbody id="${fn:toLowerCase(b_type)}-board-js"></tbody>
        </table>
        
        <div id="${fn:toLowerCase(b_type)}-paging-js"></div>
        
        <%-- <div class="board-btn__box">
        	<button type="button" onclick="javascript:boardWriteMoveHandler('${sessionScope.loginId}', '${data.b_TYPE}', '${searchType}', '${searchKeyword}')">글쓰기</button>
        </div> --%>
      </div>
    </div>
  </div>
  
  <form action="/community.detail.do" method="get" id="frm-${fn:toLowerCase(b_type)}-detail">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="b_no" />
  	<input type="hidden" name="rownum" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  </form>
  
  <form action="/community.write.do" method="get" id="frm-${fn:toLowerCase(b_type)}-write">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  	<input type="hidden" name="mode" value="WRITE" />
  </form>
</div>