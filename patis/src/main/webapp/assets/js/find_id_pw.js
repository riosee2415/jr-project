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