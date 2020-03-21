$(document).ready(function(){
	getAllUser();
	
	$("#user-search-btn").focus();
})


function enterDown(){
	if (event.keyCode == 13) {
		$("#user-search-btn").trigger("click");
		$("#user-search-btn").focus();
	}
	
}

function getAllUser(){
	
	$.ajax({
		url 	: "/getAllUser.do",
		type	: "get",
		data	: {},
		success : function(data){
			$("#userList__tbody").html("");
			$("#userList__tbody").html(data);
		}
	});
}

function trClickHandler(userId){
	$.ajax({
		url 	: "/getUserById.do",
		type	: "get",
		data	: {"userId" : userId},
		success : function(data){
			$("#userDetail-info").html(data);
			
			$("#user-search-btn").focus();
		}
	});
}


function saveBtnHandler(){
	var userRight = $("#userInfo-userRight").val();
	var updateRight = $("#userRight_combo").val();
	var sessionRight = $("#sessionRight").val();
	
	
	switch(userRight){
	case '개발자' :
		userRight = 1;
		break;
	case '관리자' :
		userRight = 2;
		break;
	case '관리자(운영)' :
		userRight = 3;
		break;
	case '일반회원' :
		userRight = 4;
		break;
	case '비회원' :
		userRight = 5;
		break;
}
	
	// validation - 1
	if(userRight < sessionRight){
		alert("더 높은 권한을 가진 회원을 수정할 수 없습니다.");
		return;
	}
	
	// validation - 2
	if(userRight > updateRight){
		alert("더 높은 권한을 가진 회원으로 권한을 수정할 수 없습니다.");
		return;
	}
	
	var flag = confirm("사용자 정보를 수정/저장 하시겠습니까 ?");
	 
	if(flag){
		// update Data
		var userId = $("#userInfo-userId").val();
		var userDept = $("#userInfo-userDept").val();
		var userGroup = $("#userInfo-userGroup").val();
		var userRight = $("#userRight_combo").val();
		var userTel = $("#userInfo-userTel").val();
		var userMobile = $("#userInfo-userMobile").val();
		var userEmail = $("#userInfo-userEmail").val();
		var userZonecode = $("#userInfo-userZonecode").val();
		var userAddr1 = $("#userInfo-userAddr1").val();
		var userAddr2 = $("#userInfo-userAddr2").val();
		
		$.ajax({
			url 	: "/updateUserInfo.do",
			type	: "get",
			data	:	{
						"userId" : userId,
						"userDept" : userDept,
						"userGroup" : userGroup,
						"userRight" : userRight,
						"userTel" : userTel,
						"userMobile" : userMobile,
						"userEmail" : userEmail,
						"userZonecode" : userZonecode,
						"userAddr1" : userAddr1,
						"userAddr2" : userAddr2
						},
			success : function(data){
				
				alert("정보 수정/저장이 완료되었습니다.");
				$("#user-search-btn").focus();
				
			}
		});
	} else {
		return;
	}
}



function searchBtnHandler(){
	
	var searchType = $("#search-combo").val();
	var searchValue = $("#search-value").val();
	
	$.ajax({
		url 	: "/searchUserInfo.do",
		type	: "get",
		data	:	{
					"searchType" : searchType,
					"searchValue" : searchValue,
					},
		success : function(data){
			$("#userList__tbody").html("");
			$("#userList__tbody").html(data);
			
			$("#user-search-btn").focus();
		}
	});
}


