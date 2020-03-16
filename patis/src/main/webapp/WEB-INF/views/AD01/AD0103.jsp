<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!-- CONTENT HEADER -->
<div class="ad0101-header">
  <p>회원관리 > 사용자 관리(AD0103)</p>
</div>

<div class="userAdmin_aera">

	<div class="userAdmin_aera__userList userList">
		<!-- 검색영역 -->
		<div class="userList__search">
			<select class="userList__search__combo">
				<option value="NAME" selected="selected">회원명</option>
				<option value="ID">회원아이디</option>
			</select>
			<input class="userList__search__input" type="text" />
			<input class="userList__search__btn" type="button" value="검색" />
		</div>
		
		<!-- 데이터영역 -->
		<div class="userList__dataList-area">
			<table class="userList__dataList">
				<thead>
					<tr>
						<th>이름</th>
						<th>아이디</th>
						<th>권한</th>
					</tr>
				</thead>
				
				<tbody id="userList__tbody">
				</tbody>
			</table>
		</div>
		
	</div>
	
	
	<div class="userAdmin_aera__userInfo">
		<div class="userAdmin_aera__userInfo__title">
			<p>사용자 상세정보</p>
		</div>
		
		<div class="userAdmin_aera__userInfo__data" id="userDetail-info">
		
		</div>
	</div>
</div>

<script src="/assets/js/admin/AD0103.js"></script>
