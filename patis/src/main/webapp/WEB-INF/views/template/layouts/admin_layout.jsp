<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="admin-box">
	<div class="admin-box__header">
		<tiles:insertAttribute name="header" />
	</div>

	<div class="admin-box__main">
		<div class="admin-box__main__left">
			<tiles:insertAttribute name="left" />
		</div>
		
		<div class="admin-box__main__content">
			<tiles:insertAttribute name="content" />
		</div>
	</div>

	<div class="admin-box__footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>
