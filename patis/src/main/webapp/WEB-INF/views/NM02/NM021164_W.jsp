<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="TODAY_DATE" />

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
		
			<div class="board-write__box" id="board-write-js" data-btype="${b_type}">
				<div class="write-row__box">
					<div class="write-col-head">
						<span class="data-tit">작성자</span>
					</div>
					<div class="write-col-body">
						<c:if test="${sessionScope.loginId eq null }">
							<input type="text" value="${data.b_AUTHOR }" class="input-author" id="input-author-js" />
						</c:if>
						<c:if test="${sessionScope.loginId ne null }">
							<span class="data-txt"><c:out value="${mode eq 'WRITE' ? sessionScope.loginName : data.b_AUTHOR}" /></span>
						</c:if>
					</div>
				</div>
				
				<div class="write-row__box">
					<div class="write-col-head">
						<span class="data-tit">제목</span>
					</div>
					<div class="write-col-body">
						<input type="text" value="${data.b_TITLE }" class="input-title" id="input-title-js" />
					</div>
				</div>
				
				<div class="write-row__box">
					<div class="write-col-head">
						<span class="data-tit">내용</span>
					</div>
					<div class="write-col-body">
						<%@ include file="/WEB-INF/views/daum-editor/editor_frame.jsp" %>
						<c:if test="${mode eq 'MODIFY'}">
							<script>Editor.modify({'content': '${data.b_DESCRIPTION}'})</script>
						</c:if>
					</div>
				</div>
				<div class="btn__box">
					<button type="button" class="btn-write" onclick="boardWriteProcessHandler('${b_type}', '${mode}', '${data.b_No}')">
						<c:out value="${mode eq 'WRITE' ? '등록하기' : '변경하기'}" />
					</button>
					<button type="button" class="btn-cancel" onclick="boardListMoveHandler('${b_type}', '${searchType}', '${searchKeyword}')">취소</button>
				</div>
			</div>
    </div>
  </div>
  
  <form action="/collusion.apply.do" method="get" id="frm-${fn:toLowerCase(b_type)}">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  </form>
  
  <form action="/collusion.apply.write.do" method="post" id="frm-${fn:toLowerCase(b_type)}-write-process">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="mode" value="${mode }" />
  	<input type="hidden" name="b_type" value="${b_type }" />
  	<input type="hidden" name="b_no" value="${data.b_No }" />
  	<input type="hidden" name="b_title" />
  	<input type="hidden" name="b_description" />
  	<input type="hidden" name="b_author" value="${sessionScope.loginNo }" />
  </form>
</div>