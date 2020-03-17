$(document).ready(function(){
	getBoardAdminRight();
})


function getBoardAdminRight(){
	$.ajax({
		url 	: "/getBoardAdminRight.do",
		type	: "get",
		data	: {},
		success : function(data){
			$("#manager-ul").html(data);
		}
	});
}


function boardNameClickHandler(boardName){
	$.ajax({
		url 	: "/getBoardAdminRightByName.do",
		type	: "get",
		data	: {"name" : boardName},
		success : function(data){
			
			$("#manager-content").html(data);
		}
	});
}


function boardAcceptRightModify(){
	
	var boardName = $("#manager-board-name").val();
	var boardRight = $("#manager-board-right").val();
	
	if(boardRight == "--선택--") {
		alert("변경할 권한을 선택하세요.");
		return;
	}
	
	$.ajax({
		url 	: "/boardAcceptRightModify.do",
		type	: "get",
		data	: {	"name" : boardName ,
			   		"right" : boardRight
		          },
		success : function(data){
			alert("권한이 변경되었습니다.");
			
			boardNameClickHandler(boardName);
		}
	});
}