$(document).ready(function(){
	$.ajax({
    		url 	: "/ad0101Init.do",
    		type	: "get",
    		data	: { "page" : 1 },
    		success : function(data){
    			$("#ajax-tbody").html(data);
    			
    		}
    	});
})

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