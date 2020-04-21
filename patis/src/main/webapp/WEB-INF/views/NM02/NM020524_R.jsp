<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="todayDate" />

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-detail__box">
        <div class="detail-info__box">
          <div class="detail-tit__box">
            <h3 class="detail-title">${data.b_TITLE }</h3>
            <ul class="detail-list">
              <li>
                <span class="data-tit">작성자</span>
                <span class="data-txt"
                  ><c:out
                    value="${data.b_AUTHOR_NO eq 0 ? data.b_AUTHOR_NONE : data.b_AUTHOR}"
                /></span>
              </li>
              <li>
                <span class="data-tit">작성일</span>
                <span class="data-txt">${data.b_CREATE_TIME }</span>
              </li>
              <li>
                <span class="data-tit">조회수</span>
                <span class="data-txt">${data.b_HIT }</span>
              </li>
            </ul>
          </div>
          <div class="detail-file__box">
            <ul class="detail-list">
              <c:choose>
                <c:when test="${empty fileList }">
                  <li class="empty">첨부파일이 없습니다.</li>
                </c:when>
                <c:otherwise>
                  <c:forEach var="file" items="${fileList}" varStatus="status">
                    <c:set
                      var="fileName"
                      value="${fn:split(file.FILE_O_PATH, '/')}"
                    />
                    <li>
                      <span class="data-tit">파일${status.count}</span>
                      <span
                        class="data-txt"
                        onclick="fileDownload('${file.FILE_NO}', '${file.FILE_V_PATH}', '${fileName[fn:length(fileName)-1]}', this)"
                        >${fileName[fn:length(fileName)-1]}</span
                      >
                    </li>
                  </c:forEach>
                </c:otherwise>
              </c:choose>
            </ul>
          </div>
        </div>
        <div class="detail-desc__box">${fn:replace(data.b_DESCRIPTION, "\\'", "'") }</div>
        
        <div class="reply__box">
        	<table class="reply__table">
        		<thead>
        			<tr>
       					<th>추진상황</th>
       					<td>${data.b_REPLY_STATE }</td>
       					<th>통지일</th>
       					<td><c:out value="${empty data.b_REPLY_TIME ? todayDate : data.b_REPLY_TIME}" /></td>
        			</tr>
        		</thead>
        		<tbody>
        			<tr>
        				<td colspan="4">
        					<form
					          action="/community.reply.write.do"
					          method="post"
					          id="frm-${fn:toLowerCase(data.b_TYPE)}-reply-write-process"
					        >
					        	<input type="hidden" name="parent" value="${param.parent }" />
					        	<input type="hidden" name="code" value="${param.code }" />
					        	<input type="hidden" name="mode" />
					        	<input type="hidden" name="b_no" value="${data.b_NO }" />
					        	<input type="hidden" name="b_reply_state" value="답변완료" />
					        	<input type="hidden" name="b_reply_author" value="${sessionScope.loginNo }" />
					        	
					        	<div class="reply__data__box" id="reply-data-js">
		       						<c:choose>
		        						<c:when test="${empty data.b_REPLY }">
			        							<textarea name="b_reply" class="init-focus" id="input-reply-js"></textarea>
		        						</c:when>
		        						<c:otherwise>
			        							${data.b_REPLY }
	        							</c:otherwise>
		        					</c:choose>
	        					</div>
        					</form>
        				</td>
        			</tr>
        		</tbody>
        	</table>
        </div>
        
        <div class="btn__box">
          <c:if test="${not empty sessionScope.loginId }">
            <c:if test="${AcceptRight.BOARD_CONTROLL_RIGHT >= sessionScope.loginRight}">
            	<c:if test="${empty data.b_REPLY}">
           			<button
	                type="button"
	                onclick="javascript:boardReplyWriteProcessHandler('${data.b_TYPE}', 'WRITE', '${data.b_NO}', '${searchType}', '${searchKeyword}')"
	                >답변</button
	              >
            	</c:if>
            	<c:if test="${not empty data.b_REPLY}">
            		<button
	                type="button"
	                onclick="javascript:boardReplyModifyHandler('${data.b_TYPE}', 'MODIFY', '${data.b_NO}', '${searchType}', '${searchKeyword}')"
	                id="reply-modify-js"
	                >수정</button
	              >
	              <button
	                type="button"
	                onclick="javascript:boardReplyRemoveProcessHandler('${data.b_TYPE}', '${data.b_NO}', '${searchType}', '${searchKeyword}')"
	                >삭제</button
	              >
            	</c:if>	
            </c:if>
          </c:if>
          <button
            type="button"
            onclick="boardListMoveHandler('${data.b_TYPE}', '${searchType}', '${searchKeyword}')"
          >
            목록
          </button>
        </div>
      </div>
      
			<form
		    action="/community.do"
		    method="get"
		    id="frm-${fn:toLowerCase(data.b_TYPE)}"
		  >
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>
		  
		  <form
		    action="/community.reply.remove.do"
		    method="post"
		    id="frm-${fn:toLowerCase(data.b_TYPE)}-reply-remove"
		  >
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="b_no" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>   
    </div>
  </div>
</div>
