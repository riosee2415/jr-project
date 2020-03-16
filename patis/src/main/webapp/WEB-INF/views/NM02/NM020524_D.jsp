<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
prefix="fn" %>

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
                  <td
                    onclick="javascript:boardDetailMoveHandler('${prevData.b_TYPE}', '${prevData.b_NO}', '${prevData.ROWNUM}', '${searchType}', '${searchKeyword}')"
                    >${prevData.b_TITLE }</td
                  >
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
                  <td
                    onclick="javascript:boardDetailMoveHandler('${nextData.b_TYPE }', '${nextData.b_NO}', '${nextData.ROWNUM}', '${searchType}', '${searchKeyword}')"
                    >${nextData.b_TITLE }</td
                  >
                </c:otherwise>
              </c:choose>
            </tr>
          </table>
        </div>
        <div class="btn__box">
          <c:if test="${not empty sessionScope.loginId }">
            <c:if test="${sessionScope.loginId eq data.b_AUTHOR_ID}">
              <button
                type="button"
                onclick="javascript:boardWriteMoveHandler('${data.b_TYPE}', '${searchType}', '${searchKeyword}', '${data.b_NO}')"
                >수정</button
              >
              <button
                type="button"
                onclick="javascript:boardRemoveProcessHandler('${data.b_TYPE}', '${data.b_NO}', '${searchType}', '${searchKeyword}')"
                >삭제</button
              >
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

      <div
        class="board-comment__area"
        id="board-comment-js"
        data-btype="${data.b_TYPE }"
        data-pno="${data.b_NO}"
      >
        <%@ include file="/WEB-INF/views/template/components/board_comment.jsp"
        %>
      </div>
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
    action="/community.detail.do"
    method="get"
    id="frm-${fn:toLowerCase(data.b_TYPE)}-detail"
  >
    <input type="hidden" name="parent" value="${param.parent }" />
    <input type="hidden" name="code" value="${param.code }" />
    <input type="hidden" name="b_no" />
    <input type="hidden" name="rownum" />
    <input type="hidden" name="s_type" />
    <input type="hidden" name="s_keyword" />
  </form>

  <form
    action="/community.write.do"
    method="get"
    id="frm-${fn:toLowerCase(data.b_TYPE)}-write"
  >
    <input type="hidden" name="parent" value="${param.parent }" />
    <input type="hidden" name="code" value="${param.code }" />
    <input type="hidden" name="b_no" />
    <input type="hidden" name="rownum" value="${rownum}" />
    <input type="hidden" name="s_type" />
    <input type="hidden" name="s_keyword" />
    <input type="hidden" name="mode" value="MODIFY" />
  </form>

  <form
    action="/community.remove.do"
    method="post"
    id="frm-${fn:toLowerCase(data.b_TYPE)}-remove"
  >
    <input type="hidden" name="parent" value="${param.parent }" />
    <input type="hidden" name="code" value="${param.code }" />
    <input type="hidden" name="b_no" />
    <input type="hidden" name="s_type" />
    <input type="hidden" name="s_keyword" />
  </form>
</div>
