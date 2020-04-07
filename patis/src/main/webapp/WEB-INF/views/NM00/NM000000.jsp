<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="main">
  <div class="main-container">
    <div class="main-container-banner">
      <ul class="main-container__slide" id="slide-image-js">
        <li>
          <a href="#" class="slideimg-01"> </a>
        </li>
        <li>
          <a href="#" class="slideimg-02"> </a>
        </li>
        <li>
          <a href="#" class="slideimg-03"> </a>
        </li>
        <li>
          <a href="#" class="slideimg-04"> </a>
        </li>
        <li>
          <a href="#" class="slideimg-05"> </a>
        </li>
      </ul>
      <ul class="btn_box" id="slide-btn-js">
        <li class="slide-button"><button class="right-btn"></button></li>

        <li class="slide-control">
          <button class="pause"></button>
        </li>
        <li class="slide-button"><button class="left-btn"></button></li>
      </ul>
    </div>
    <div class="banner">
      <div class="up">
        <div>
          <a
            href="${pageContext.request.contextPath }/policy.do?parent=3&code=61"
            class="banner1"
          ></a>
        </div>
        <div>
          <a
            href="${pageContext.request.contextPath }/business.do?parent=4&code=22"
            class="banner2"
          ></a>
        </div>
        <div>
          <a
            href="${pageContext.request.contextPath }/intro.do?parent=4&code=21"
            class="banner3"
          ></a>
        </div>
      </div>
      <div class="down">
        <div>
          <a
            href="${pageContext.request.contextPath }/education.do?parent=5&code=23"
            class="banner4"
          ></a>
        </div>
        <div>
          <a
            href="${pageContext.request.contextPath }/news.do?parent=8&code=32"
            class="banner5"
          ></a>
        </div>
        <div>
          <a
            href="${pageContext.request.contextPath }/school.do?parent=10&code=37"
            class="banner6"
          ></a>
        </div>
      </div>
    </div>
  </div>
  <div class="main-container-content">
    <div class="main-regeneration">
      <a
        href="${pageContext.request.contextPath }/policy.loc.do?parent=3&code=62"
        class="main-img-rayer"
      ></a>
    </div>
    <div class="main-news">
      <ul>
        <li class="main-news__title">
          <span class="title-text">최근소식</span>
          <a
            href="javascript:boardListMoveHandler('${boardData01.btype}')"
            class="main-plus"
          ></a>
        </li>
        <c:choose>
          <c:when test="${empty boardData01.list}">
            <li class="main-urbannews__content empty">
              조회된 데이터가 없습니다.
            </li>
          </c:when>
          <c:otherwise>
            <c:forEach var="board" items="${boardData01.list}">
              <li class="main-urbannews__content">
                <a
                  href="javascript:boardDetailMoveHandler('${boardData01.btype}', '${board.b_NO}', '${board.ROWNUM}')"
                  >${board.b_TITLE}</a
                >
              </li>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
    <div class="main-urbannews">
      <ul>
        <li class="main-urbannews__title">
          <span class="title-text">도시재생 사업 현황</span>
          <a
            href="javascript:boardListMoveHandler('${boardData02.btype}')"
            class="main-plus"
          ></a>
        </li>
        <c:choose>
          <c:when test="${empty boardData02.list}">
            <li class="main-urbannews__content empty">
              조회된 데이터가 없습니다.
            </li>
          </c:when>
          <c:otherwise>
            <c:forEach var="board" items="${boardData02.list}">
              <li class="main-urbannews__content">
                <a
                  href="javascript:boardDetailMoveHandler('${boardData02.btype}', '${board.b_NO}', '${board.ROWNUM}')"
                  >${board.b_TITLE}</a
                >
              </li>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>

  <div class="mainBotton">
    <div class="main-cooper-btn">
      <div><button class="prev"></button></div>
    </div>
    <div class="main-cooper">
      <ul>
        <li>
          <a
            class="main-cooper-01"
            target="_blank"
            href="http://www.molit.go.kr/portal.do"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-02"
            target="_blank"
            href="https://www.seoul.go.kr/main/index.jsp"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-03"
            target="_blank"
            href="https://uri.seoul.go.kr/surc/main.do"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-04"
            target="_blank"
            href="https://www.city.go.kr/index.do"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-05"
            target="_blank"
            href="http://www.law.go.kr/"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-06"
            target="_blank"
            href="https://www.lh.or.kr/index.do"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-07"
            target="_blank"
            href="https://i-sh.co.kr/main/index.do"
          ></a>
        </li>
        <li>
          <a
            class="main-cooper-08"
            target="_blank"
            href="https://www.khug.or.kr/index.jsp"
          ></a>
        </li>
      </ul>
    </div>

    <div class="main-cooper-btn">
      <div><button class="next"></button></div>
    </div>
  </div>

  <div class="sub-content-wrap">
    <form
      action="/news.do"
      method="get"
      id="frm-${fn:toLowerCase(boardData01.btype)}"
    >
      <input type="hidden" name="parent" value="${boardData01.parent }" />
      <input type="hidden" name="code" value="${boardData01.code }" />
      <input type="hidden" name="s_type" />
      <input type="hidden" name="s_keyword" />
    </form>
    <form
      action="/news.detail.do"
      method="get"
      id="frm-${fn:toLowerCase(boardData01.btype)}-detail"
    >
      <input type="hidden" name="parent" value="${boardData01.parent }" />
      <input type="hidden" name="code" value="${boardData01.code }" />
      <input type="hidden" name="b_no" />
      <input type="hidden" name="rownum" />
      <input type="hidden" name="s_type" />
      <input type="hidden" name="s_keyword" />
    </form>
    <form
      action="/collusion.apply.do"
      method="get"
      id="frm-${fn:toLowerCase(boardData02.btype)}"
    >
      <input type="hidden" name="parent" value="${boardData02.parent }" />
      <input type="hidden" name="code" value="${boardData02.code }" />
      <input type="hidden" name="s_type" />
      <input type="hidden" name="s_keyword" />
    </form>
    <form
      action="/collusion.apply.detail.do"
      method="get"
      id="frm-${fn:toLowerCase(boardData02.btype)}-detail"
    >
      <input type="hidden" name="parent" value="${boardData02.parent }" />
      <input type="hidden" name="code" value="${boardData02.code }" />
      <input type="hidden" name="b_no" />
      <input type="hidden" name="rownum" />
      <input type="hidden" name="s_type" />
      <input type="hidden" name="s_keyword" />
    </form>
  </div>

	<%
 		List<String> closeModalList = new ArrayList<String>();
 		Cookie[] cookies = request.getCookies();
 		
 		for(Cookie cookie : cookies) {
 			if(cookie.getName().contains("modal-popup")) {
 				if(cookie.getValue().equals("1")) {
 					closeModalList.add(cookie.getName());
 				}
 			}
 		}
 		request.setAttribute("closeModalList", closeModalList);
	%>

  <c:forEach var="pop" items="${popupList }" varStatus="status">
  	<c:set value="modal-popup${status.count }" var="modalId" />
  	<c:set value="true" var="flagLoop" />
  		<c:forEach var="closeModal" items="${closeModalList }">
  		<c:if test="${closeModal eq modalId }">
  			<c:set value="false" var="flagLoop" />
  		</c:if>
  	</c:forEach>
  	
  	<c:if test="${flagLoop eq 'true'}">
  		<div class="main_modal" id="modal-popup${status.count }">
	      <div
	        class="main_modal__desc"
	        style="width: ${pop.POPUP_WIDTH}px; height: ${pop.POPUP_HEIGHT }px; background-image: url('${pop.POPUP_PATH }'); top:${status.count * 10 }px; left:${(status.count-1) * 600 + 30 }px;"
	      >
	        <div class="main_modal__desc__exit">
	          <i
	            onclick="javascript:closeMainModal('modal-popup${status.count}')"
	            class="fa fa-times"
	            aria-hidden="true"
	          ></i>
	        </div>
	        <div class="main_modal__desc__bottom">
	          <!-- <a
	            href="${pop.POPUP_LINK }"
	            class="main_modal__desc__link"
	            target="_blank"
	            >바로가기</a
	          > -->
	        </div>
	      </div>
        <div 
	      	class="main_modal_btn"
	      	style="width: ${pop.POPUP_WIDTH}px; top:${status.count * 10 }px; left:${(status.count-1) * 600 + 30 }px;">
	      	<a id="chk-close-js" href="javascript:closeCheckMainModal('modal-popup${status.count}')">
	      		<i class="fa fa-square-o" aria-hidden="true"></i>오늘 하루 열지 않음
	     		</a>
	      	<a href="javascript:closeMainModal('modal-popup${status.count}')">닫기</a>
	      </div>
	    </div>
    </c:if>
  </c:forEach>
</div>
