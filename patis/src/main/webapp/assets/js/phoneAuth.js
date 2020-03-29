// Global Variable Area
var g_joinId;
var g_dupleCheck = false;
var g_passCheck = false;
var g_password;

var zoneCode = document.getElementById("joinZondeCode");
var roadAddr = document.getElementById("joinRoadAddr");
var detailAddr = document.getElementById("joinDetailAddr");

var joinName = document.getElementById("joinName");

var joinEmail = document.getElementById("joinEmail");
var joinEmailAddr = document.getElementById("joinEmailAddr");

var joinMobile1 = document.getElementById("joinMobile-1");
var joinMobile2 = document.getElementById("joinMobile-2");
var joinMobile3 = document.getElementById("joinMobile-3");

var joinTel1 = document.getElementById("joinTel-1");
var joinTel2 = document.getElementById("joinTel-2");
var joinTel3 = document.getElementById("joinTel-3");

function openPhonePop() {
	event.preventDefault();
	window.open("/phonePop.do", '_blank', 'width=500px,height=700px,toolbars=no,scrollbars=no');
}


function nextStep(){
	
	$("#step2Frm").submit();
}


function sucTest(){
	
	opener.parent.nextStep();
	
	self.close();
}



function agreeChecked(){
	var chk1 = $("input:checkbox[id='chk-agree-1']").is(":checked");
	var chk2 = $("input:checkbox[id='chk-agree-2']").is(":checked");

	if(chk1 && chk2) {
		$("#step3Frm").submit();
	} else {
		alert("필수 동의사항에 모두 동의하여주십시오.");
		return;
	}
	
	
	
}



function idDupleCheckAjax(){
	
	var joinId = $("#joinId").val();
	var idValueFlag = false;
	
	// validation check1 (length)
	if(joinId.length < 8 || joinId.length > 14){
		alert("아이디 길이는 8자리에서 14자리 사이로 입력해주세요.");
		return;
	}
	
	for(var i = 0; i < joinId.length; i++){

		// space
		if(joinId.charCodeAt(i) == 32) {
			alert("공백은 사용할 수 없습니다.");
			return;
		}
		
		if( (joinId.charCodeAt(i) >= 48 && joinId.charCodeAt(i) <= 57) || (joinId.charCodeAt(i) >= 65 && joinId.charCodeAt(i) <= 90) || (joinId.charCodeAt(i) >= 97 && joinId.charCodeAt(i) <= 122) ){
			idValueFlag = true;
		} else {
			idValueFlag = false;
			break;
		}
		
	}
	
	
	if(idValueFlag) {
		$.ajax({
			url 	: "/idDupleCheckAjax.do",
			type	: "post",
			data	: { "joinId" : joinId},
			success : function(data){

				if(data == 0 ){
					alert("사용 가능한 아이디입니다.");
					g_joinId = joinId;
					g_dupleCheck = true;
					$("#joinId").css("border", "1.5px solid #6ab04c");
					
				} else {
					alert("사용 불가능한 아이디 입니다.");
					$("#joinId").focus();
					g_dupleCheck = false;
					$("#joinId").css("border", "1.5px solid #e74c3c");
					return;
				}
			}
		});
	} else {
		alert("아이디는 대문자, 소문자, 숫자만 입력 가능합니다.");
		$("#joinId").focus();
		return;
	}
}



function keyDownPassword(){
	
	var pass = $("#joinPass-1").val();
	
	var passwordRules = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

		
	if(passwordRules.test(pass)){
		$(".password_validation").css("color", "blue");
		$("#joinPass-1").css("border", "1.5px solid #6ab04c");
	} else {
		$(".password_validation").css("color", "#e74c3c");
		$("#joinPass-1").css("border", "1.5px solid #e74c3c");
	}

}

function keyDownCheck(){
	var pass = $("#joinPass-1").val();
	var pass2 = $("#joinPass-2").val();
	
	if(pass === pass2){
		g_password = pass2;
		g_passCheck = true;
		$("#joinPass-1, #joinPass-2").css("border", "1.5px solid #6ab04c");
	} else {
		g_passCheck = false;
		$("#joinPass-2").css("border", "1.5px solid #e74c3c");
	}
}


function openAddrPopup(){
	 new daum.Postcode({
	        oncomplete: function(data) {
	        	zoneCode.value = data.zonecode;
	        	roadAddr.value = data.roadAddress;
	        	detailAddr.focus();
	        	
	        }
	    }).open();
}


function joinBtnHandler(){
	
	if(g_dupleCheck && g_passCheck) {
		$(".loading").css("display", "block");
	}
	
	var proFlag = false;
	
	// ID CHECK
	if(g_dupleCheck) {
		proFlag = true;
	} else {
		proFlag = false;
		alert("아이디 중복검사는 필수입니다.");
		return;
	}
	
	// NAME CHECK
	if( (joinName.value == "" || joinName.value == null) ){
		proFlag = false;
		alert("이름은 필수입력사항 입니다.");
		joinName.focus();
		return;
	} else {
		proFlag = true;
	}
	
	// PASSWORD CHECK
	if(g_passCheck) {
		proFlag = true;
	} else {
		proFlag = false;
		alert("비밀번호가 일치하지 않습니다.");
		return;
	}
	
	// ADDRESS CHECK
	if( (zoneCode.value == "" || zoneCode.value == null) && (roadAddr.value == "" || roadAddr.value == null)){
		proFlag = false;
		alert("주소는 필수입력사항 입니다.");
		return;
	} else {
		proFlag = true;
	}
	
	
	// EMAIL CHECK
	if( (joinEmail.value == "" || joinEmail.value == null) && (joinEmailAddr.value == "" || joinEmailAddr.value == null) ){
		proFlag = false;
		alert("이메일은 필수입력사항 입니다.");
		joinEmail.focus();
		return;
	} else {
		proFlag = true;
	}
	
	// MOBILE CHECK
	if( (joinMobile1.value == "" || joinMobile1.value == null) && (joinMobile2.value == "" || joinMobile2.value == null) && (joinMobile3.value == "" || joinMobile3.value == null)){
		proFlag = false;
		alert("휴대폰 번호는 필수입력사항 입니다.");
		joinMobile1.focus();
		return;
	} else {
		proFlag = true;
	}
	
	
	// START JOIN US
	if(proFlag && g_dupleCheck){
		$.ajax({
			url 	: "/joinUs.do",
			type	: "post",
			data	: { 
						"joinId" : g_joinId,
						"joinName" : joinName.value,
						"joinPassword" : g_password,
						"joinZonecode" : zoneCode.value,
						"joinAddr1" : roadAddr.value,
						"joinAddr2" : detailAddr.value,
						"joinEmail" : joinEmail.value,
						"joinMobile" : joinMobile1.value + joinMobile2.value + joinMobile3.value,
						"joinTel" : joinTel1.value + joinTel2.value + joinTel3.value
					  },
			success : function(data){
				
				var firm = confirm("가입이 완료되었습니다. 로그인 하시겠습니까?");
				
				if(firm){
					$("#loginFrm").submit();
				} else {
					$("#mainFrm").submit();
				}
				
			}
		});
	} else {
		return;
	}
	
}


function moveFindIdJoin(){
	document.getElementById("findIdFrm").submit();

}

function moveFindPassJoin(){
	document.getElementById("findPassFrm").submit();
}

function moveFindLoginJoin(){
	document.getElementById("findLoginFrm").submit();
}

