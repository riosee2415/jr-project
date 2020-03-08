function deleteBtnHandler(status){
	$.ajax({
		url 	: "/ad0215Notice.do",
		type	: "get",
		data	: { "status" : status },
		success : function(data){
			
		}
	});
}