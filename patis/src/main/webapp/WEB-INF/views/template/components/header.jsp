<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<form
  id="moveMainFrm"
  action="${pageContext.request.contextPath }/logout.do "
></form>

<form
  id="moveMypageFrm"
  action="${pageContext.request.contextPath }/myPage.do "
></form>

<input type="checkbox" id="menu_call" class="ck" />
<header class="mobile header">
  <a href="${pageContext.request.contextPath }/main.do" class="logo"> </a>

  <label for="menu_call" class="lst" onclick="javascript:stopScroll()">
    <span class="menuicon"></span>
    <span class="xicon"></span>
  </label>
</header>
<header class="desk header">
  <div class="deskbox">
    <a href="${pageContext.request.contextPath }/main.do" class="logo"> </a>
    <div class="topHeader">
      <c:choose>
        <c:when test="${not empty loginId }">
          <div class="topHeader_content">
            <div class="loginYet"> <span>${loginName }</span>님 환영합니다.</div>
            <div class="down">
              <div class="myPage" onclick="javascript:moveMypageBtn()">
                <i class="fa fa-address-card" aria-hidden="true"></i> 마이페이지
              </div>
              <div class="logout" onclick="javascript:adminLogoutBtn()">
                <i class="fa fa-sign-out" aria-hidden="true"></i> 로그아웃
              </div>
            </div>
          </div>
        </c:when>

        <c:otherwise>
          <div class="login">
            <button type="button" onclick="javacript:pageLink('/login.do')">
              <i class="fa fa-user-circle" aria-hidden="true"></i> 로그인
            </button>
          </div>
          <div class="join">
            <button
              type="button"
              onclick="javacript:pageLink('/join-step-1.do')"
            >
              <i class="fa fa-user-circle-o" aria-hidden="true"></i> 회원가입
            </button>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
    <nav id="deskmenu">
      <ul class="menu resmenu" id="resmenu-js">
        <c:forEach var="menu" items="${menuList }">
          <li>
            <a class="resmenu__m" href="${menu.URL }"
              ><c:out value="${menu.VAL }"></c:out
            ></a>
            <ul class="sub">
              <c:forEach var="subMenu" items="${subMenuList }">
                <c:if test="${menu.DETAIL_CODE == subMenu.PARENT_CODE }">
                  <li
                    ><a
                      href="${subMenu.URL }?parent=${subMenu.PARENT_CODE }&code=${subMenu.DETAIL_CODE}"
                      ><c:out value="${subMenu.VAL }"></c:out></a
                  ></li>
                </c:if>
              </c:forEach>
            </ul>
          </li>
        </c:forEach>
      </ul>
    </nav>
  </div>
</header>
<nav id="collap_menu">
  <ul class="menu">
    <c:forEach var="menu" items="${menuList }">
      <li>
        <a class="collap-menu-main" onclick="javascript:mobileMenuHandler(this)"
          ><c:out value="${menu.VAL }"></c:out
        ></a>
        <ul class="collap-menu-sub">
          <c:forEach var="subMenu" items="${subMenuList }">
            <c:if test="${menu.DETAIL_CODE == subMenu.PARENT_CODE }">
              <li
                ><a
                  href="${subMenu.URL }?parent=${subMenu.PARENT_CODE }&code=${subMenu.DETAIL_CODE}"
                  ><c:out value="${subMenu.VAL }"></c:out></a
              ></li>
            </c:if>
          </c:forEach>
        </ul>
      </li>
    </c:forEach>
  </ul>
  <div class="topHeader">
    <c:choose>
      <c:when test="${not empty loginId }">
         <div class="topHeader_content">
            <div class="loginYet"> <span>${loginId }</span>님 환영합니다.</div>
            <div class="down">
              <div class="myPage" onclick="javascript:moveMypageBtn()">
                <i class="fa fa-address-card" aria-hidden="true"></i> 마이페이지
              </div>
              <div class="logout" onclick="javascript:adminLogoutBtn()">
                <i class="fa fa-sign-out" aria-hidden="true"></i> 로그아웃
              </div>
            </div>
          </div>
      </c:when>

      <c:otherwise>
        <div class="login">
          <button type="button" onclick="javacript:pageLink('/login.do')">
            <i class="fa fa-user-circle" aria-hidden="true"></i> 로그인
          </button>
        </div>
        <div class="join">
          <button type="button" onclick="javacript:pageLink('/join-step-1.do')">
            <i class="fa fa-user-circle-o" aria-hidden="true"></i> 회원가입
          </button>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</nav>
