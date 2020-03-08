$(document).ready(function(){
	$('.check-all').click(function() {
		$('.ab').prop('checked', this.checked);
	});
})


function noticeBtnHandler(status, no, btn){

	if (status === 0) {
		btn.value = "해제";
	} else {
		btn.value = "설정";
	}

	$.ajax({
		url : "/ad0215Notice.do",
		type : "get",
		data : {
			"status" : status,
			"no" : no
		},
		success : function(data) {

		}
	});
}

function deleteBtnHandler(no, btn){
	console.log('del btn');
}