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