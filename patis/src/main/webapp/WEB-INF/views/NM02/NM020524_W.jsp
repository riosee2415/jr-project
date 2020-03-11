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
		
			<div class="board-detail__box" id="board-detail-js" data-btype="${b_type}">
				<div class="detail-info__box">
					<div class="detail-tit__box">
						<input type="text" name="B_TITLE" value="${data.b_TITLE}" placeholder="제목을 입력해주세요" class="input-title init-input-focus" id="input-title-js" />
						<ul class="detail-list">
							<li>
								<span class="data-tit">작성자</span>
								<span class="data-txt"><c:out value="${mode eq 'WRITE' ? sessionScope.loginName : data.b_AUTHOR}" /></span>
							</li>
							<li>
								<span class="data-tit">작성일</span>
								<span class="data-txt"><c:out value="${mode eq 'WRITE' ? TODAY_DATE : data.b_CREATE_TIME}" /></span>
							</li>
							<li>
								<span class="data-tit">조회수</span>
								<span class="data-txt"><c:out value="${mode eq 'WRITE' ? '0' : data.b_HIT}" /></span>
							</li>
						</ul>
					</div>
				</div>
				<div class="detail-desc__box" id="input-desc-js">
					<%@ include file="/WEB-INF/views/daum-editor/editor_frame.jsp" %>
				</div>
				<div class="btn__box">
					<button type="button" onclick="boardWriteProcessHandler('${b_type}', '${mode}', '${data.b_No}')">
						<c:out value="${mode eq 'WRITE' ? '등록' : '변경'}" />
					</button>
					<button type="button" onclick="boardListMoveHandler('${b_type}', '${searchType}', '${searchKeyword}')">목록</button>
				</div>
			</div>
    </div>
  </div>
  
  <form action="/community.do" method="get" id="frm-${fn:toLowerCase(b_type)}">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  </form>
  
  <form action="/community.write.do" method="post" id="frm-${fn:toLowerCase(b_type)}-write-process">
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