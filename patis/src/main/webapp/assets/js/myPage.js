var email = document.getElementById("user-email");
var tel = document.getElementById("user-tel");
var mobile = document.getElementById("user-mobile");
var zoneCode = document.getElementById("user-zonecode");
var addr1 = document.getElementById("user-addr1");
var addr2 = document.getElementById("user-addr2");
var id = document.getElementById("user-id");
var frm = document.getElementById("moveMyPage");


function openPost(){
	 new daum.Postcode({
	        oncomplete: function(data) {
	        	zoneCode.value = data.zonecode;
	        	addr1.value = data.roadAddress;
	        	addr2.focus();
	        }
	    }).open();
}



function saveInfoInMypage(){
	
	
	$.ajax({
		url 	: "/saveInfoInMypage.do",
		type	: "get",
		data	: { 
					"id" 		: id.text,
					"email" 	: email.value,
					"tel" 		: tel.value,
					"mobile" 	: mobile.value,
					"zoneCode" 	: zoneCode.value,
					"addr1" 	: addr1.value,
					"addr2" 	: addr2.value,
					
		},
		success : function(data){
			frm.submit();
		}
	});
	
}