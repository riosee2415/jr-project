$(document).ready(function(){
	
	getPopupList();
})


function getPopupList(){
	$.ajax({
		url 	: "/getPopupList.do",
		type	: "get",
		data	: {},
		success : function(data){
			$("#popupAreaDesc").html(data);
			
		}
	});
}


function useHandler(val, name){
	
	console.log(val);
	console.log(name);
	
	$.ajax({
		url 	: "/useHandler.do",
		type	: "get",
		data	: {"value" : val,
					"name" : name},
		success : function(data){
			
			getPopupList();
		}
	});
}