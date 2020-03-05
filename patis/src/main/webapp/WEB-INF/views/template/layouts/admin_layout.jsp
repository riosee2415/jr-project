<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyyMMddHHmmddss" var="ver" />

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>관리자페이지</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/assets/images/commons/favicon.png"
    />
    <link rel="stylesheet" href="/assets/css/admin/adminStyles.css?ver=${ver}" />
  </head>
  <body>
		<div class="admin-box">
			<div class="admin-box__header">
				<tiles:insertAttribute name="header" />
			</div>
		
			<div class="admin-box__main">
				<div class="admin-box__main__left">
					<tiles:insertAttribute name="left" />
				</div>
				
				<div class="admin-box__main__container">
					<div class="admin-box__main__content">
						<tiles:insertAttribute name="content" />
					</div>
					
					<div class="admin-box__footer">
						<tiles:insertAttribute name="footer" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>