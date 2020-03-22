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
	<div><label>생년월일</label></div>
	<div><input id="userInfo-userRegno" type="text" value="${user.USER_REGNO1 }" readonly/></div>
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
	<div><label>우편번호</label></div>
	<div><input id="userInfo-userZonecode" type="text" value="${user.USER_ZONECODE }" readonly/></div>
</div>

<div class="user_detailData_area">
	<div><label>도로명 주소</label></div>
	<div><input id="userInfo-userAddr1" type="text" value="${user.USER_ADDR1 }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>상세주소</label></div>
	<div><input id="userInfo-userAddr2" type="text" value="${user.USER_ADDR2 }" /></div>
</div>

<div class="user_detailData_area">
	<div><label>로그인 실패 횟수</label></div>
	<div><input id="userInfo-login-try" type="text" value="${user.USER_LOGIN_TRY }" readonly/></div>
</div>




<div class="user_detailData_area">
	<input class="detailData_saveBtn" type='button' value="저장" onclick="javascript:saveBtnHandler()"/>
	<input class="detailData_saveBtn-red" type='button' value="회원탈퇴" onclick="javascript:deleteBtnHandler()"/>
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