<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <%@ include file="/WEB-INF/views/template/components/board_search.jsp"
        %>
      </div>

      <div class="nm34-page-wrap">
         <div
          class="board-list__box"
	        id="board-list-js"
	        data-btype="${b_type_1}"
	        data-parent="${param.parent}"
	        data-code="${param.code}"
	      >
	      	<div id="${fn:toLowerCase(b_type_1)}-board-js" style="width: 100%;"></div>
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
      
      <form action="/archive.detail.do" method="get" id="frm-${fn:toLowerCase(b_type_1)}-detail">
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="tab" value="1" />
		    <input type="hidden" name="b_no" />
		    <input type="hidden" name="rownum" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>

			<form action="/archive.write.do" method="get" id="frm-${fn:toLowerCase(b_type_1)}-write">
				<input type="hidden" name="parent" value="${param.parent }" />
				<input type="hidden" name="code" value="${param.code }" /> 
				<input type="hidden" name="tab" value="1" />
				<input type="hidden" name="s_type" /> 
				<input type="hidden" name="s_keyword" /> 
				<input type="hidden" name="mode" value="WRITE" />
			</form>
    </div>
    
    <!--현장지원센터 -->
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <%@ include file="/WEB-INF/views/template/components/board_search.jsp" %>
      </div>
      
      <div class="nm34-page-wrap">
         <div
         	class="board-list__box"
	        id="board-list-js"
	        data-btype="${b_type_2}"
	        data-parent="${param.parent}"
	        data-code="${param.code}"
	      >
	      	<div id="${fn:toLowerCase(b_type_2)}-board-js" style="width: 100%;"></div>
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
      
      <form action="/archive.detail.do" method="get" id="frm-${fn:toLowerCase(b_type_2)}-detail">
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="tab" value="2" />
		    <input type="hidden" name="b_no" />
		    <input type="hidden" name="rownum" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>

			<form action="/archive.write.do" method="get" id="frm-${fn:toLowerCase(b_type_2)}-write">
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
		}
  </script>
</div>
