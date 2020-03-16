<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<div class="user_detailData_area">
	<label>아이디</label>
	<input type="text" value="${user.USER_ID }" readonly/>
</div>

<div class="user_detailData_area">
	<label>이름</label>
	<input type="text" value="${user.USER_NAME }" readonly/>
</div>

<div class="user_detailData_area">
	<label>소속부서</label>
	<input type="text" value="${user.USER_DEPARTMENT }" />
</div>

<div class="user_detailData_area">
	<label>소속그룹</label>
	<input type="text" value="${user.USER_GROUP }" />
</div>

<div class="user_detailData_area">
	<label>권한</label>
	<input type="text" value="${user.USER_RIGHT }" readonly/>
	
	<label>권한변경</label>
	<select id="userRight_combo" name="userRight_combo">
	
	</select>
</div>

<div class="user_detailData_area">
	<label>전화번호</label>
	<input type="text" value="${user.USER_TEL }" />
</div>

<div class="user_detailData_area">
	<label>휴대폰번호</label>
	<input type="text" value="${user.USER_MOBILE }" />
</div>

<div class="user_detailData_area">
	<label>이메일</label>
	<input type="text" value="${user.USER_EMAIL }" />
</div>

<div class="user_detailData_area">
	<label>비밀번호 힌트</label>
	<input type="text" value="${user.PASS_HINT }" readonly/>
</div>

<div class="user_detailData_area">
	<label>비밀번호 힌트 답변</label>
	<input type="text" value="${user.HINT_ANSWER }" readonly/>
</div>





<script>
	$(document).ready(function(){
		 getCombo();

	});


	
	function getCombo(){
		$.ajax({
			url 	: "/getComboData.do",
			type	: "get",
			data	: {"code" : "RG_01"},
			success : function(data){
				$("#userRight_combo").html(data);

			}
		});
	}

		


</script>