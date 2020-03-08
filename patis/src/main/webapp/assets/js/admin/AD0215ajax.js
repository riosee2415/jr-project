function deleteBtnHandler(status, no, btn){
	
	if(status === 0) {
		btn.value = "해제";	
	} else {
		btn.value = "설정";	
	}
	
	$.ajax({
		url 	: "/ad0215Notice.do",
		type	: "get",
		data	: { "status" : status , "no" : no},
		success : function(data){
			
		}
	});
}