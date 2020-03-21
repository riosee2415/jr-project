<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="login-page">
      <div class="login-box">
        <h3 class="login-title">회원 로그인</h3>
        <form action="${pageContext.request.contextPath }/mainLogin.do" method="post">
	        <div class="id"><input type="text" id="loginId" name="loginId" placeholder="아이디" /></div>
	        <div class="pass"><input type="password" id="loginPass" name="loginPass" placeholder="비밀번호" /></div>
	        <div class="idSearch">아이디/비밀번호 찾기</div>
	        <div class="login-button">
	          <button class="login-btn" type="submit" >로그인</button>
	          <button class="join-btn" type="button" onclick="javacript:pageLink('/join.do')">회원가입</button>
	        </div>
        </form>
      </div>
    </div>
  </div>
</div>
