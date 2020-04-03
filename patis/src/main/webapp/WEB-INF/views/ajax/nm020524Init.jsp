<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${empty boardList }">
    <tr class="row-empty">
      <td 
				<c:choose>
					<c:when test="${board.b_GUBUN eq null }">colspan="5"</c:when>
					<c:otherwise>colspan="6"</c:otherwise>
				</c:choose>
			>조회된 데이터가 없습니다.</td>
    </tr>
  </c:when>
  <c:otherwise>
    <c:forEach var="board" items="${boardList }">
      <tr <c:if test="${board.b_NOTICE eq 1}">class="row-notice"</c:if>>
        <td><c:out value="${board.b_NOTICE eq 1 ? '공지' : board.ROWNUM}" /></td>
        <c:if test="${board.b_GUBUN ne null}">
        	<td>${board.b_GUBUN}</td>
        </c:if>
        <td
          class="header-title"
          onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
          >
          ${board.b_TITLE }</td
        >
        <td 
        	class="header-author"
          ><c:out
            value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
        /></td>
        <td>${board.b_CREATE_TIME }</td>
        <td>${board.b_HIT }</td>
      </tr>
    	<c:if test="${not empty board.b_REPLY}">
    	<tr class="row-reply">
    		<td></td>
    		<td class="header-title">해당 글에 대한 답변입니다.</td>
    		<td>${board.b_REPLY_AUTHOR }</td>
    		<td>${board.b_REPLY_DATE }</td>
    		<td>${board.b_REPLY_HIT }</td>
    	</tr>
    	</c:if>
    </c:forEach>
  </c:otherwise>
</c:choose>
-----
<c:choose>
  <c:when test="${empty boardList }">
    <div class="empty__box">조회된 데이터가 없습니다.</div>
  </c:when>
  <c:otherwise>
    <c:forEach var="board" items="${boardList }">
	    <div
	      class="border-list_wrap"
	      onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
	    >
	    	<c:if test="${board.b_NOTICE eq 1}">
		      <p class="border-notice">공지</p>
	      </c:if>
	      <h3 class="border-list_title">
	      	<c:if test="${board.b_GUBUN ne null}">
          	<span>[${board.b_GUBUN}]</span>
          </c:if>
	      	${board.b_TITLE }</h3>
	      <ul class="border-list_com">
	        <li>
	          <i class="fa fa-pencil" aria-hidden="true"></i>
	          <c:out
	            value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
	          />
	        </li>
	        <li>
	          <i class="fa fa-calendar" aria-hidden="true"></i>
	          ${board.b_CREATE_TIME }</li
	        >
	        <li>
	          <i class="fa fa-eye" aria-hidden="true"></i>
	          ${board.b_HIT }</li
	        >
	      </ul>
	    </div>
    </c:forEach>
  </c:otherwise>
</c:choose>
