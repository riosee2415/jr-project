$(document).ready(function(){

	
	getToday();
});


var globalToday;
var globalStart;
var globalEnd;
var searchFlag = false;


function getToday(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; 
	var yyyy = today.getFullYear();
	
	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 
	
	today = yyyy+'/'+mm+'/'+ dd;
	$("#sits-title-js").text($("#sits-title-js").text() + " ( " + today + " ) ");
	
	globalToday = today;
	
	
	getTodaData(today);
	
}


function getTodaData(today){
	
	$.ajax({
		url 	: "/getTodayLoginData.do",
		type	: "get",
		data	: { "today" : today },
		success : function(data){
			
			$("#sits-data-js").text(data);
		}
	});
	
}

function getSearchData(){
	
	if($("#startDate").val() == "" || $("#startDate").val() == null){
		alert("기간을 입력해주세요.");
		return;
	} else if ($("#endDate").val() == "" || $("#endDate").val() == null){
		alert("기간을 입력해주세요.");
		return;
	} else {
		searchFlag = true;
		var start = $("#startDate").val();
		var end =  $("#endDate").val();
		
		globalStart = start;
		globalEnd = end;
		
		$.ajax({
			url 	: "/getSearchLoginData.do",
			type	: "get",
			data	: 	{ 	"start" : start,
							"end"	: end
						},
			success : function(data){
				
				$("#sits-search-data-js").text(data);
			}
		});
	}
	
}


function openDetailModal(modalCase){
	
	$("#connect__list").html("");
	
	if(modalCase == 1) {
		
		$(".modal-02").css("display", "block");
		
		$.ajax({
			url 	: "/getTodayDetailLoginData.do",
			type	: "get",
			data	: { "today" : globalToday },
			success : function(data){
				$("#connect__list").html(data);
			}
		});
	} else if(modalCase == 2) {
		
		if(!searchFlag) {
			alert("먼저 검색기간 설정 후 조회하세요.");
			return;
		} else {
			$(".modal-02").css("display", "block");
			
			$.ajax({
				url 	: "/getSearchDetailLoginData.do",
				type	: "get",
				data	: { 	"start" : globalStart,
								"end"	: globalEnd
						  },
				success : function(data){
					$("#connect__list").html(data);
				}
			});
		}
	}
	
}


function closeModal() {
	  $(".modal-02").css("display", "none");
	}