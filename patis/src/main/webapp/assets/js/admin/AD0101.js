$(document).ready(function(){
	getPageContent(1);
});

function getPageContent(page){
	$.ajax({
		url 	: "/ad0101Init.do",
		type	: "get",
		data	: { "page" : page },
		success : function(data){
			$("#ajax-tbody").html(data);
		}
	});
}