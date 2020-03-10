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
	if(e.length >= 30) {
		alert("검색할 내용이 너무 길어 데이터를 반영할 수 없습니다.");
	}
}