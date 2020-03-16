<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<div class="user_detailData_area">
	<div><label>아이디</label></div>
	<div><input id="userInfo-userId" type="text" value="${user.USER_ID }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>이름</label></div>
	<div><input type="text" value="${user.USER_NAME }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>소속부서</label></div>
	<div><input id="userInfo-userDept" type="text" value="${user.USER_DEPARTMENT }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>소속그룹</label></div>
	<div><input id="userInfo-userGroup" type="text" value="${user.USER_GROUP }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>권한</label></div>
	<div><input type="text" id="userInfo-userRight" value="${user.USER_RIGHT }" readonly/></div>
	
	<div><label>권한변경</label></div>
	<div><select id="userRight_combo" name="userRight_combo">
	
	</select></div>
</div>

<div class="user_detailData_area">
	<div><label>전화번호</label></div>
	<div><input id="userInfo-userTel" type="text" value="${user.USER_TEL }" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"/></div>
</div>

<div class="user_detailData_area">
	<div><label>휴대폰번호</label></div>
	<div><input id="userInfo-userMobile" type="text" value="${user.USER_MOBILE }" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"/></div>
</div>

<div class="user_detailData_area">
	<div><label>이메일</label></div>
	<div><input id="userInfo-userEmail" type="text" value="${user.USER_EMAIL }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>비밀번호 힌트</label></div>
	<div><input id="userInfo-userHint" type="text" value="${user.PASS_HINT }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>비밀번호 힌트 답변</label></div>
	<div><input id="userInfo-userAnswer" type="text" value="${user.HINT_ANSWER }" readonly/></div>
</div>


<div class="user_detailData_area">
	<input class="detailData_saveBtn" type='button' value="저장" onclick="javascript:saveBtnHandler()"/>
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


				var currentRight = $("#userInfo-userRight").val();

				switch(currentRight){
					case '개발자' :
						currentRight = 1;
						break;
					case '관리자' :
						currentRight = 2;
						break;
					case '관리자(운영)' :
						currentRight = 3;
						break;
					case '일반회원' :
						currentRight = 4;
						break;
					case '비회원' :
						currentRight = 5;
						break;
				}

				$("#userRight_combo").val(currentRight).attr("selected", "selected");

				
			}
		});
	}

		


</script>