<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<div class="user_detailData_area">
	<div><label>아이디</label></div>
	<div><input type="text" value="${user.USER_ID }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>이름</label></div>
	<div><input type="text" value="${user.USER_NAME }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>소속부서</label></div>
	<div><input type="text" value="${user.USER_DEPARTMENT }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>소속그룹</label></div>
	<div><input type="text" value="${user.USER_GROUP }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>권한</label></div>
	<div><input type="text" value="${user.USER_RIGHT }" readonly/></div>
	
	<div><label>권한변경</label></div>
	<div><select id="userRight_combo" name="userRight_combo">
	
	</select></div>
</div>

<div class="user_detailData_area">
	<div><label>전화번호</label></div>
	<div><input type="text" value="${user.USER_TEL }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>휴대폰번호</label></div>
	<div><input type="text" value="${user.USER_MOBILE }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>이메일</label></div>
	<div><input type="text" value="${user.USER_EMAIL }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>비밀번호 힌트</label></div>
	<div><input type="text" value="${user.PASS_HINT }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>비밀번호 힌트 답변</label></div>
	<div><input type="text" value="${user.HINT_ANSWER }" readonly/></div>
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