<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
		
			<div class="board-detail__box">
				<h3 class="detail-title">${data.b_TITLE }</h3>
				<div class="detail-info__box">
					<table>
						<tr>
							<th>번호</th>
							<td>${data.b_NO }</td>
							<th>등록일</th>
							<td>${data.b_CREATE_TIME }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${data.b_AUTHOR }</td>
							<th>조회</th>
							<td>${data.b_HIT }</td>
						</tr>
					</table>
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
									<td onclick="javascript:goCollusionDetailHandler('${prevData.b_NO}')">${prevData.b_TITLE }</td>
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
									<td onclick="javascript:goCollusionDetailHandler('${nextData.b_NO}')">${nextData.b_TITLE }</td>
								</c:otherwise>
							</c:choose>
						</tr>	
					</table>
				</div>
				<div class="btn__box">
					<button type="button" onclick="goCollusionListHandler()">목록</button>
				</div>
			</div>
    </div>
  </div>
  
  <form action="/collusion.apply.do" method="get" id="frm-collusion">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  </form>
  
  <form action="/collusion.apply.detail.do" method="get" id="frm-collusion-detail">
  	<input type="hidden" name="parent" value="${param.parent }" />
  	<input type="hidden" name="code" value="${param.code }" />
  	<input type="hidden" name="b_no" />
  </form>
</div>