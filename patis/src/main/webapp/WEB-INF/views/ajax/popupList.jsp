<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="data" items="${list }">
  <div class="popup_area__desc__data">
    <div class="popup_area__desc__subject">
      <div>${data.POPUP_NAME }</div>
    </div>
    <form
      action="${pageContext.request.contextPath }/popupUpload.do"
      id="popupFileUp-js"
      method="post"
      enctype="multipart/form-data"
    >
      <div class="popup_area__desc__content">
        <input
          type="hidden"
          value="${data.POPUP_NAME }"
          id="popup-name"
          name="popup-name"
        />
        <div class="popup_area__desc__content__data">
          <div>
            <label>팝업넓이</label>
          </div>
          <div>
            <input
              type="text"
              value="${data.POPUP_WIDTH }"
              maxlength="3"
              id="popup-width"
              name="popup-width"
            /><span>px</span>
          </div>
        </div>

        <div class="popup_area__desc__content__data">
          <div>
            <label>팝업높이</label>
          </div>
          <div>
            <input
              type="text"
              value="${data.POPUP_HEIGHT }"
              maxlength="3"
              id="popup-height"
              name="popup-height"
            /><span>px</span>
          </div>
        </div>

        <div class="popup_area__desc__content__data">
          <div>
            <label>현재팝업</label>
          </div>

          <div>
            <input type="text" value="${data.POPUP_PATH }" readonly />
          </div>
        </div>
        <div class="popup_area__desc__content__data">
          <div>
            <label>변경할 팝업</label>
          </div>

          <div>
            <input
              type="file"
              id="popupFile"
              name="popupFile"
              value="파일찾기"
            />
          </div>
        </div>

        <div class="popup_area__desc__content__data">
          <div>
            <label>팝업내용</label>
          </div>

          <div>
            <input
              type="text"
              value="${data.POPUP_DESC }"
              id="popup-desc"
              name="popup-desc"
            />
          </div>
        </div>
        
        <div class="popup_area__desc__content__data">
          <div>
            <label>팝업링크</label>
          </div>

          <div>
            <input
              type="text"
              value="${data.POPUP_LINK }"
              id="popup-link"
              name="popup-link"
            />
          </div>
        </div>

        <div class="popup_area__desc__content__data">
          <div>
            <label>사용여부</label>
          </div>
          <c:if test="${data.POPUP_USE eq 0 }">
            <div>
              <input
                type="button"
                value="미사용"
                class="unUse"
                id="popup-use"
                name="popup-use"
                onclick="javascript:useHandler('${data.POPUP_USE}', '${data.POPUP_NAME }')"
              />
            </div>
          </c:if>
          <c:if test="${data.POPUP_USE eq 1 }">
            <div>
              <input
                type="button"
                value="사용중"
                class="Use"
                id="popup-use"
                name="popup-use"
                onclick="javascript:useHandler('${data.POPUP_USE}', '${data.POPUP_NAME }')"
              />
            </div>
          </c:if>
        </div>

        <div class="popup_area__desc__content__data">
          <input type="submit" value="팝업저장" />
        </div>
      </div>
    </form>
  </div>
</c:forEach>
