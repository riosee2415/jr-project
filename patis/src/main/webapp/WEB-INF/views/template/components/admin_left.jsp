<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="left-menu">
	<div class="left-menu-icon__box" id="left-menu-icon-js">
		<ul>
			<li class="<c:if test="${param.mc eq 1 || empty param.mc}">active</c:if>"><i class="fa fa-user-o" aria-hidden="true"></i></li>
			<li class="<c:if test="${param.mc eq 2}">active</c:if>"><i class="fa fa-list" aria-hidden="true"></i></li>
			<li class="<c:if test="${param.mc eq 3}">active</c:if>"><i class="fa fa-cog" aria-hidden="true"></i></li>
			<li class="<c:if test="${param.mc eq 4}">active</c:if>"><i class="fa fa-user-o" aria-hidden="true"></i></li>
		</ul>
	</div>
	
	
	
	
	<div class="left-menu-list__box" id="left-menu-list-js">
		
			<div class="lefe-menu-list__area <c:if test="${param.mc eq 1 || empty param.mc}">active</c:if>">
			<h3 class="left-menu-title">회원 관리</h3>
			<ul class="left-menu-sub">
        <li class="<c:if test='${param.mc eq 1 && param.sc eq 1 }'>active</c:if>" onclick="javascript:subMenuHandler('/loginInfo.do', 1, 1)">로그인기록 관리</li>
        <li class="<c:if test='${param.mc eq 1 && param.sc eq 2 }'>active</c:if>" onclick="javascript:subMenuHandler('/loginReport.do',1 ,2)">접속통계 관리</li>
        <li class="<c:if test='${param.mc eq 1 && param.sc eq 3 }'>active</c:if>" onclick="javascript:subMenuHandler('/userControll.do',1, 3)">사용자 관리</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area <c:if test="${param.mc eq 2}">active</c:if>">
			<h3 class="left-menu-title">게시판 관리</h3>
			<ul class="left-menu-sub">
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 1 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.statute.do', 2, 1)">도시재생 관계법령</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 2 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.community.do', 2, 2)">마을커뮤니티</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 3 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.notice.do', 2, 3)">공지사항</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 4 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.eventAlert.do', 2, 4)">행사알림</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 5 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.eventArchive.do', 2, 5)">행사자료</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 6 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.release.do', 2, 6)">보도자료</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 7 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.yardOffice.do', 2, 7)">구청[사진 및 영상자료]</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 8 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.yardSupport.do', 2, 8)">현장지원센터[사진 및 영상자료]</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 9 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.hire.do', 2, 9)">채용공고</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 10 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.eduOffice.do', 2, 10)">구청[도시재생학교]</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 11 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.eduSupport.do', 2, 11)">현장지원센터[도시재생학교]</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 12 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.calendar.do', 2, 12)">교육 연간일정표</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 13 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.calendar_apply.do', 2, 13)">교육 일정등록 및 신청</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 14 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.presentation.do', 2, 14)">주민설명회</li>
        <li class="<c:if test='${param.mc eq 2 && param.sc eq 15 }'>active</c:if>" onclick="javascript:subMenuHandler('/admin.collusion.do', 2, 15)">공모사업신청</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area <c:if test="${param.mc eq 3}">active</c:if>">
			<h3 class="left-menu-title">회원관리3</h3>
			<ul class="left-menu-sub">
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-1</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-2</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-3</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area <c:if test="${param.mc eq 4}">active</c:if>">
			<h3 class="left-menu-title">회원관리4</h3>
			<ul class="left-menu-sub">
        <li onclick="javascript:subMenuHandler('/main.do')">menu4-1</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu4-2</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu4-3</li>
      </ul>
		</div>
	</div>
</nav>



<!-- form tag -->
<form id="menuFrm" method="get">
	<input type="hidden" id="mc" name="mc" />
	<input type="hidden" id="sc" name="sc"/>
</form>
