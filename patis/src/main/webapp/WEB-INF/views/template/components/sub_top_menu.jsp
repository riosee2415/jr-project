<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="sub-top-menu">
	<div class="top-menu__box menu-two active">
		<ul class="top-menu__list">
			<c:forEach var="detail" items="${DetailMenuList }" varStatus="status">
				<c:if test="${param.code == detail.PARENT_CODE}" >
					<li class="active"><span><c:out value="${detail.VAL }"></c:out></span></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>

	<div class="top-menu__box menu-four">
		<ul class="top-menu__list">
			<li class="active"><span>도시재생사업 유형별 소개</span></li>
			<li><span>서울시 도시재생사업 진행현황</span></li>
			<li><span>도시재생 주체별 역할</span></li>
			<li><span>도시재생 관계 법령</span></li>
		</ul>
	</div>

	<div class="top-menu__box menu-three">
		<ul class="top-menu__list">
			<li class="active"><span>도시재생사업 유형별 소개</span></li>
			<li><span>서울시 도시재생사업 진행현황</span></li>
			<li><span>도시재생 주체별 역할</span></li>
		</ul>
	</div>

	<div class="top-menu__box menu-one">
		<ul class="top-menu__list">
			<li class="active"><span>공모사업 신청</span></li>
		</ul>
	</div>
</div>