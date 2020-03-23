var g_passCheck = false;
var g_password;

function findHandler(value) {
  if (value == "myBirth") {
    $("#info-birth-js").show();
    $("#info-email-js").hide();
  } else if (value == "myEmail") {
    $("#info-birth-js").hide();
    $("#info-email-js").show();
  }
}

function goFindPwHandler() {
	var id = $('#searchId_Id').val();
	var birth = $('#startDate').val();
	var email = $('#searchEmail').val();
	
	if(isEmpty(id) || isEmpty(birth) || isEmpty(email)) {
		alert('입력하지 않은 정보가 있습니다.');
		return;
	}
	
	$.ajax({
		type: 'post',
		url: '/sendFindPwMail.do',
		data: {'id': id, 'birth': birth, 'email': email},
		dataType: 'json',
		error: function() {
			console.log('error');
		}
	});
	$('#frm-find-pw-js input[name=id]').val(id);
	$('#frm-find-pw-js input[name=birth]').val(birth);
	$('#frm-find-pw-js input[name=email]').val(email);
	$('#frm-find-pw-js').submit();
}

function goConfirmPwHandler() {
	var emailKey = $('#confirm_PW').val();
	
	if(isEmpty(emailKey)) {
		alert('인증번호를 입력해주세요.');
		$('#confirm_PW').focus();
		return;
	}
	
	$('#frm-confirm-pw-js input[name=emailKey]').val(emailKey);
	$('#frm-confirm-pw-js').submit();
}

function goResultPwHandler() {
	var pw = $('#joinPass-1').val();
	
	if(!g_passCheck) {
		alert('변경할 비밀번호가 일치하지 않습니다.');
		$('#joinPass-2').focus();
		return;
	}
	$('#frm-result-pw-js input[name=userPw]').val(pw);
	$('#frm-result-pw-js').submit();
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
