$(document).ready(function(){

	getToday();
});



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
	
	getTodaData(today);
	
}


function getTodaData(today){
	
	$.ajax({
		url 	: "/getTodayConnectData.do",
		type	: "get",
		data	: { "today" : today },
		success : function(data){
			
			$("#sits-data-js").text(data);
		}
	});
	
}