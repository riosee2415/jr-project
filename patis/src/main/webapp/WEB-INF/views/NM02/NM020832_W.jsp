<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
prefix="fn" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="TODAY_DATE" />

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div
        class="board-write__box"
        id="board-write-js"
        data-btype="${b_type}"
        data-key="${file_key}"
      >
        <form
          action="/news.write.do"
          method="post"
          id="frm-${fn:toLowerCase(b_type)}-write-process"
        >
          <input type="hidden" name="parent" value="${param.parent }" />
          <input type="hidden" name="code" value="${param.code }" />
          <input type="hidden" name="tab" value="${tab }" />
          <input type="hidden" name="mode" value="${mode }" />
          <input type="hidden" name="rownum" value="${rownum }" />
          <input type="hidden" name="b_type" value="${b_type }" />
          <input type="hidden" name="b_no" value="${data.b_NO }" />
          <input type="hidden" name="b_title" />
          <input type="hidden" name="b_description" />
          <input
            type="hidden"
            name="b_author"
            value="<c:out value='${sessionScope.loginNo > 0 ? sessionScope.loginNo : 0}' />"
          />
          <input type="hidden" name="file_key" value="${file_key }" />
          <input type="hidden" name="remove_file" value="${remove_file }" />
          <input type="hidden" name="s_type" value="${searchType }" />
          <input type="hidden" name="s_keyword" value="${searchKeyword }" />

          <div class="write-row__box">
            <div class="write-col-head">
              <span class="data-tit">작성자</span>
            </div>
            <div class="write-col-body">
              <c:if test="${sessionScope.loginId eq null }">
                <input
                  type="text"
                  name="b_author_none"
                  value="${data.b_AUTHOR }"
                  class="input-author"
                  id="input-author-js"
                />
              </c:if>
              <c:if test="${sessionScope.loginId ne null }">
                <span class="data-txt"
                  ><c:out
                    value="${mode eq 'WRITE' ? sessionScope.loginName : data.b_AUTHOR}"
                /></span>
              </c:if>
            </div>
          </div>

          <div class="write-row__box">
            <div class="write-col-head">
              <span class="data-tit">제목</span>
            </div>
            <div class="write-col-body">
              <input
                type="text"
                value="${data.b_TITLE }"
                class="input-title"
                id="input-title-js"
              />
            </div>
          </div>

          <div class="write-row__box">
            <div class="write-col-head">
              <span class="data-tit">내용</span>
            </div>
            <div class="write-col-body">
              <%@ include file="/WEB-INF/views/daum-editor/editor_frame.jsp" %>
            </div>
          </div>

          <c:if test="${not empty fileList}">
            <div class="write-row__box">
              <div class="write-col-head">
                <span class="data-tit">파일</span>
              </div>
              <div class="write-col-body">
                <ul class="file-list">
                  <c:forEach var="file" items="${fileList}">
                    <c:set
                      var="fileName"
                      value="${fn:split(file.FILE_O_PATH, '/')}"
                    />
                    <li>
                      <i class="fa fa-floppy-o" aria-hidden="true"></i>
                      <span
                        onclick="fileDownload('${file.FILE_NO}', '${file.FILE_V_PATH}', '${fileName[fn:length(fileName)-1]}', this)"
                        >${fileName[fn:length(fileName)-1]}</span
                      >
                      <i
                        class="fa fa-times"
                        aria-hidden="true"
                        onclick="javascript:boardRemoveFileHandler(this, '${file.FILE_NO}')"
                      ></i>
                    </li>
                  </c:forEach>
                </ul>
              </div>
            </div>
          </c:if>
          <div class="btn__box">
            <button
              type="button"
              class="btn-write"
              onclick="javascript:boardWriteProcessHandler('${b_type}', '${mode}', '${data.b_NO}')"
            >
              <c:out value="${mode eq 'WRITE' ? '등록하기' : '변경하기'}" />
            </button>
            <c:if test="${mode eq 'WRITE'}">
              <button
                type="button"
                class="btn-cancel"
                onclick="javascript:boardListMoveHandler('${b_type}', '${searchType}', '${searchKeyword}')"
                >취소</button
              >
            </c:if>
            <c:if test="${mode eq 'MODIFY'}">
              <button
                type="button"
                class="btn-cancel"
                onclick="javascript:boardDetailMoveHandler('${b_type}', '${data.b_NO}', '${rownum}', '${searchType}', '${searchKeyword}')"
                >취소</button
              >
            </c:if>
          </div>
        </form>
      </div>
      
      <form action="/news.do" method="get" id="frm-${fn:toLowerCase(b_type)}">
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="tab" value="${tab }" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>
		
		  <form
		    action="/news.detail.do"
		    method="get"
		    id="frm-${fn:toLowerCase(b_type)}-detail"
		  >
		    <input type="hidden" name="parent" value="${param.parent }" />
		    <input type="hidden" name="code" value="${param.code }" />
		    <input type="hidden" name="tab" value="${tab }" />
		    <input type="hidden" name="b_no" />
		    <input type="hidden" name="rownum" />
		    <input type="hidden" name="s_type" />
		    <input type="hidden" name="s_keyword" />
		  </form>
    </div>
  </div>

  <script>
		window.onload = function() {
			var tabName = "${tabName}";
		
			setTitleName(tabName);

			var mode = "${mode}";
			if(mode == 'MODIFY') 
				modifyEditor('${data.b_DESCRIPTION}');
		}
  </script>
</div>
