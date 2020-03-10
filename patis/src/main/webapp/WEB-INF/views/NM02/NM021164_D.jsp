<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
		
			<div class="board-detail__box">
				<div class="detail-info__box">
					<div class="detail-tit__box">
						<h3 class="detail-title">${data.b_TITLE }</h3>
						<ul class="detail-list">
							<li>
								<span class="data-tit">작성자</span>
								<span class="data-txt">${data.b_AUTHOR }</span>
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
							<li>
								<span class="data-tit">파일1</span>
								<span class="data-txt">붙임1. 공고문.hwp</span>
							</li>
							<li>
								<span class="data-tit">파일2</span>
								<span class="data-txt">붙임2. 공고문.hwp</span>
							</li>
						</ul>
					</div>
				</div>
				<div class="detail-desc__box">${data.b_DESCRIPTION }</div>	
				<div class="detail-paging__box">
					<table>
						<tr>
							<th>이전글</th>
							<c:choose>
								<c:when test="${empty prevData.b_NO }">
									<td class="empty">이전 글이 없습니다.</td>
								</c:when>
								<c:otherwise>
									<td onclick="javascript:boardDetailMoveHandler('${prevData.b_TYPE}', '${prevData.b_NO}', '${prevData.ROWNUM}', '${searchType}', '${searchKeyword}')">${prevData.b_TITLE }</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th>다음글</th>
							<c:choose>
								<c:when test="${empty nextData.b_NO }">
									<td class="empty">다음 글이 없습니다.</td>
								</c:when>
								<c:otherwise>
									<td onclick="javascript:boardDetailMoveHandler('${nextData.b_TYPE }', '${nextData.b_NO}', '${nextData.ROWNUM}', '${searchType}', '${searchKeyword}')">${nextData.b_TITLE }</td>
								</c:otherwise>
							</c:choose>
						</tr>	
					</table>
				</div>
				<div class="btn__box">
					<button type="button" onclick="boardListMoveHandler('${data.b_TYPE}', '${searchType}', '${searchKeyword}')">목록</button>
				</div>
			</div>
			
			<div class="board-comment__area" id="boad-comment-js" data-btype="${data.b_TYPE }" data-pno="${data.b_NO}">
				<%@ include file="/WEB-INF/views/template/components/board_comment.jsp" %>
			</div>
    </div>
  </div>
  
  <form action="/collusion.apply.do" method="get" id="frm-${fn:toLowerCase(data.b_TYPE)}">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  </form>
  
  <form action="/collusion.apply.detail.do" method="get" id="frm-${fn:toLowerCase(data.b_TYPE)}-detail">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="b_no" />
  	<input type="hidden" name="rownum" />
  	<input type="hidden" name="s_type" />
  	<input type="hidden" name="s_keyword" />
  </form>
</div>