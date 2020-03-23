<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>관리자 로그인</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/assets/images/commons/favicon.png"
    />
    <link
      rel="stylesheet"
      href="/assets/plugins/font-awesome-4.7.0/font-awesome.min.css"
    />
    <link
      rel="stylesheet"
      href="/assets/css/admin/adminStyles.css?ver=${ver}"
    />
  </head>
  <body class="login-body">
    <c:if test="${loginCode == 0 }">
      <script>
        alert("ID :: LOGIN ERROR");
      </script>
    </c:if>

    <c:if test="${loginCodePass == 0 }">
      <script>
        alert("PASSWORD :: LOGIN ERROR");
      </script>
    </c:if>

    <div class="login">
      <img src="/assets/images/commons/hdlogo.png" alt="로고" />
      <div class="login-box">
        <div class="login-box__top">ADMIN LOGIN</div>
         <c:choose>
        	<c:when test="${errorCode eq '1'}">
        		 <h3 class="findId_error">
		         	<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>&nbsp;접근권한이 없습니다.
		        </h3>
        	</c:when>
        	
        	<c:otherwise>
		       
	        </c:otherwise>
        </c:choose>
        <div class="login-box__center">
          <form
            action="${pageContext.request.contextPath }/admin.do"
            method="post"
          >
            <div class="login-data">
              <div class="login-data__label">ID</div>
              <input type="text" class="login-data__input" name="id" />
            </div>

            <div class="login-data">
              <div class="login-data__label">PASSWORD</div>
              <input type="password" class="login-data__input" name="pass" />
            </div>

            <div class="login-data">
              <input type="submit" value="LOGIN" class="login-data__button" />
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
