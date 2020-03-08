<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<nav class="left-menu">
	<div class="left-menu-icon__box" id="left-menu-icon-js">
		<ul>
			<li class="active"><i class="fa fa-user-o" aria-hidden="true"></i></li>
			<li><i class="fa fa-user-o" aria-hidden="true"></i></li>
			<li><i class="fa fa-user-o" aria-hidden="true"></i></li>
			<li><i class="fa fa-user-o" aria-hidden="true"></i></li>
		</ul>
	</div>
	
	
	
	
	<div class="left-menu-list__box" id="left-menu-list-js">
		<div class="lefe-menu-list__area active">
			<h3 class="left-menu-title">회원관리1</h3>
			<ul class="left-menu-sub">
        <li onclick="javascript:subMenuHandler('/loginInfo.do', 1, 1)">로그인기록 관리</li>
        <li onclick="javascript:subMenuHandler('/board.do', 1, 2)">menu1-2</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu1-3</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area">
			<h3 class="left-menu-title">회원관리2</h3>
			<ul class="left-menu-sub">
        <li onclick="javascript:subMenuHandler('/main.do')">menu2-1</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu2-2</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu2-3</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area">
			<h3 class="left-menu-title">회원관리3</h3>
			<ul class="left-menu-sub">
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-1</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-2</li>
        <li onclick="javascript:subMenuHandler('/main.do')">menu3-3</li>
      </ul>
		</div>
		<div class="lefe-menu-list__area">
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
