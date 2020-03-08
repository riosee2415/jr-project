<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header-logo__box">
	<h1 class="header-logo-text">
		<a href="${pageContext.request.contextPath }/main.do" title="홈페이지로 이동" class="header-link-out">
			<i class="fa fa-outdent" aria-hidden="true"></i>
		</a>
		<a href="${pageContext.request.contextPath }/admin.do" class="header-link-logo"></a>
	</h1>
</div>

<div class="header-content__box">
	<ul>
		<li>${loginId }</li>
		<li>${loginName }</li>
	</ul>
</div>

<script src="/assets/js/jquery-1.12.4.min.js"></script>
