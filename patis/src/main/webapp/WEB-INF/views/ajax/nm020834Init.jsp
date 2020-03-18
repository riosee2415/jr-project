<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty boardList }">
		<div class="empty-box">조회된 데이터가 없습니다.</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="board" items="${boardList }">
			<div class="nm34-content-img-box">
          <ul onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')">
            <li>
            	<c:choose>
            		<c:when test="${board.b_THUMB_PATH eq null}">
            			<img
		                src="/assets/images/image/default-thumbnail.png"
		                alt="기본 썸네일 이미지"
		                class="nm34-imgbox"
		              />
            		</c:when>
            		<c:otherwise>
            			<img
		                src="${board.b_THUMB_PATH}"
		                alt="동영상 썸네일 이미지"
		                class="nm34-imgbox"
		              />
            		</c:otherwise>
            	</c:choose>
            </li>
          </ul>
          <ul class="nm34-imgbox-con">
            <li class="nm34-imgbox-title">${board.b_TITLE}</li>
            <li class="nm34-imgbox-date">${board.b_CREATE_TIME}</li>
            <li class="nm34-imgbox-view">
              <span class="nm34-imgbox-view-span">조회수 <span>${board.b_HIT}</span></span>
            </li>
          </ul>
        </div>
		</c:forEach>
	</c:otherwise>
</c:choose>