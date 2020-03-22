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
	
	$('#frm-findpw-type1 input[name=id]').val(id);
	$('#frm-findpw-type1 input[name=birth]').val(birth);
	$('#frm-findpw-type1 input[name=email]').val(email);
	$('#frm-findpw-type1').submit();
}