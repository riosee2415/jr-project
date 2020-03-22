function numberFormat(number, length) {
	 var zero = '';
	 number = number.toString();
	
	 if (number.length < length) {
	  for (i = 0; i < length - number.length; i++)
	   zero += '0';
	 }
	 return zero + number;
}

function isEmpty(value){ 
	if( value == "" || value == null || value == undefined || 
	  ( value != null && typeof value == "object" && !Object.keys(value).length )){ 
		return true 
	} else{ 
		return false 
	}
};


function validationInputLength(e){
	var flag = false;
	
	if(e.length >= 30) {
		alert("검색할 내용이 너무 길어 데이터를 반영할 수 없습니다.");
		
		flag = true;
	}
	
	return flag;
}

function pageLink(url) {
	$('#frm-link').attr('action', url);
	$('#frm-link').submit();
}


function adminLogoutBtn(){
	var answer = confirm("로그아웃 하시겠습니까?");
	
	if(answer) {
		var mainFrm = document.getElementById("moveMainFrm");
		mainFrm.submit();
	} else {
		return;
	}

}



function moveMypageBtn(){
	var pageFrm = document.getElementById("moveMypageFrm");
	pageFrm.submit();
}