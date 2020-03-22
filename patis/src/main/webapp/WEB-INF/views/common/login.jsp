<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="login-page">
      <div class="login-box">
        <h3 class="login-title">회원 로그인</h3>
        <c:if test="${param.loginMsg eq '1'}">
			<h5>로그인 3회 이상 실패로 로그인이 불가능합니다.</h5>        
        </c:if>
        
         <c:if test="${param.loginMsg eq '2'}">
			<h5>아이디 또는 비밀번호가 일치하지 않습니다.</h5>        
        </c:if>
        <form action="${pageContext.request.contextPath }/mainLogin.do" method="post">
	        <div class="id"><input type="text" id="loginId" name="loginId" placeholder="아이디" /></div>
	        <div class="pass"><input type="password" id="loginPass" name="loginPass" placeholder="비밀번호" /></div>
	        <div class="idSearch">아이디 찾기</div>
	         <div class="passSearch">비밀번호 찾기</div>
	        <div class="login-button">
	          <button class="login-btn" type="submit" >로그인</button>
	          <button class="join-btn" type="button" onclick="javacript:pageLink('/join.do')">회원가입</button>
	        </div>
        </form>
      </div>
    </div>
  </div>
</div>
