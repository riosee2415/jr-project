$(document).ready(function(){
	getAllUser();
})

function getAllUser(){
	
	$.ajax({
		url 	: "/getAllUser.do",
		type	: "get",
		data	: {},
		success : function(data){
			$("#userList__tbody").html(data);
		}
	});
}

function trClickHandler(userId){
	$.ajax({
		url 	: "/getUserById.do",
		type	: "get",
		data	: {"userId" : userId},
		success : function(data){
			$("#userDetail-info").html(data);
		}
	});
}