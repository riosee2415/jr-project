<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<form
  id="moveFindIdFrm"
  action="${pageContext.request.contextPath }/findId.do"
  method="get"
></form>
<form
  id="moveFindPassFrm"
  action="${pageContext.request.contextPath }/findPass.do"
  method="get"
></form>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <h2 class="login_tit">
      <span>중랑구청 도시재생지원포털</span>에 오신것을 환영합니다.
    </h2>
    <div class="login-page">
      <div class="login-box">
        <h3 class="login-title">회원 로그인</h3>
        <c:if test="${param.loginMsg eq '1'}">
          <h5>로그인 3회 이상 실패로 로그인이 불가능합니다.</h5>
        </c:if>

        <c:if test="${param.loginMsg eq '2'}">
          <h5>아이디 또는 비밀번호가 일치하지 않습니다.</h5>
        </c:if>
        <form
          id="mainLoginFrm"
          action="${pageContext.request.contextPath }/mainLogin.do"
          method="post"
        >
          <div class="id">
            <input
              type="text"
              id="loginId"
              name="loginId"
              placeholder="아이디"
            />
          </div>
          <div class="pass">
            <input
              type="password"
              id="loginPass"
              name="loginPass"
              placeholder="비밀번호"
              onkeyup="javascript:enterkeyLogin()"
            />
          </div>
          <div class="search_tag_wrap">
            <div class="idSearch" onclick="javascript:moveFindId()">
              아이디 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
            </div>
            <div class="passSearch" onclick="javascript:moveFindPass()">
              비밀번호 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
            </div>
          </div>
          <div class="login-button">
            <button class="login-btn" type="button" onclick="javascript:loginAni()">로그인</button>
            <button
              class="join-btn"
              type="button"
              onclick="javacript:pageLink('/join.do')"
            >
              회원가입
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="loading">
  <p class="circle">
    <span class="ouro ouro3">
      <span class="left"><span class="anim"></span></span>
      <span class="right"><span class="anim"></span></span>
    </span>
  </p>
</div>