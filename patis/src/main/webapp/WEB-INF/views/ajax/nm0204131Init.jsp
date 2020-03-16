<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${empty boardList }">
    <tr class="row-empty">
      <td colspan="5">조회된 데이터가 없습니다.</td>
    </tr>
  </c:when>
  <c:otherwise>
    <c:forEach var="board" items="${boardList }">
      <c:choose>
        <c:when test="${board.b_NOTICE eq 1 }">
          <tr class="row-notice">
            <td>공지</td>
            <td
              class="header-title"
              onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
              >${board.b_TITLE }</td
            >
            <td
              ><c:out
                value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
            /></td>
            <td>${board.b_CREATE_TIME }</td>
            <td>${board.b_HIT }</td>
          </tr>
        </c:when>
        <c:otherwise>
          <tr>
            <td>${board.ROWNUM }</td>
            <td
              class="header-title"
              onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
              >${board.b_TITLE }</td
            >
            <td
              ><c:out
                value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
            /></td>
            <td>${board.b_CREATE_TIME }</td>
            <td>${board.b_HIT }</td>
          </tr>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </c:otherwise>
</c:choose>
-----
<c:choose>
  <c:when test="${empty boardList }">
    <div class="border-lsit_wrap">
      <table class="border-list__table2">
        <tr class="row-empty">
          <td>조회된 데이터가 없습니다.</td>
        </tr>
      </table>
    </div>
  </c:when>
  <c:otherwise>
    <c:forEach var="board" items="${boardList }">
      <c:choose>
        <c:when test="${board.b_NOTICE eq 1 }">
          <div
            class="border-lsit_wrap"
            onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
          >
            <table class="border-list__table2">
              <thead>
                <tr class="row-notice">
                  <th>공지</th>
                  <th colspan="3">${board.b_TITLE }</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="2">
                    <c:out
                      value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
                    />
                  </td>
                  <td>${board.b_CREATE_TIME }</td>
                  <td>${board.b_HIT }</td>
                </tr>
              </tbody>
            </table>
          </div>
        </c:when>
        <c:otherwise>
          <div
            class="border-lsit_wrap"
            onclick="javascript:boardDetailMoveHandler('${board.b_TYPE}', '${board.b_NO}', '${board.ROWNUM}')"
          >
            <table class="border-list__table2">
              <thead>
                <tr>
                  <th>${board.ROWNUM }</th>
                  <th colspan="3">${board.b_TITLE }</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="2"
                    ><c:out
                      value="${board.b_AUTHOR_NO eq 0 ? board.b_AUTHOR_NONE : board.b_AUTHOR}"
                  /></td>
                  <td>${board.b_CREATE_TIME }</td>
                  <td>${board.b_HIT }</td>
                </tr>
              </tbody>
            </table>
          </div>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </c:otherwise>
</c:choose>
