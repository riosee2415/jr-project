function openPost(){
	 new daum.Postcode({
	        oncomplete: function(data) {
	        	
	        }
	    }).open();
}