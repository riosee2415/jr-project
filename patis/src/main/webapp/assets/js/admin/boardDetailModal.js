function intoComments(b_no, b_title, b_author) {
  var modalPop = $(".modal-pop");
  $(modalPop).click(function() {
    $(".modal").css("display", "block");
  });
  $(".modal-X").click(function() {
    $(".modal").css("display", "none");
  });
  
  
  $.ajax({
		url : "/ad0215Comments.do",
		type : "get",
		data : {
			"p_no" : b_no
		},
		success : function(dataList) {
			console.log("GO!");
			
			dataList.forEach(function(data){
				console.log(data);
			})
		}
	});
  
  $("#mh__no").html(b_no);
  $("#mh__title").html(b_title);
  $("#mh__author").html(b_author);
}
