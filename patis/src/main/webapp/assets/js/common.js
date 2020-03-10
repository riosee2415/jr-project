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
