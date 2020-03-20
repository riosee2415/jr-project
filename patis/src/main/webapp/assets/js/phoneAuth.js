// Global Variable Area
var g_joinId;


function openPhonePop() {
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
				console.log(data);
			}
		});
	} else {
		alert("아이디는 대문자, 소문자, 숫자만 입력 가능합니다.");
		$("#joinId").focus();
		return;
	}
	
}







