$(document).ready(function() {
	
	
	slideInterval = setInterval(function() {
		  nextAni();
	  }, 5000);
  function nextAni() {
    $(".main-cooper ul")
      .not(":animated")
      .animate({ "margin-left": "-200px" }, 500, function() {
        $(".main-cooper ul li")
          .eq(0)
          .appendTo($(".main-cooper ul"));
        $(".main-cooper ul").css("margin-left", "0px");
      });
  }
  function prevAni() {
    $(".main-cooper ul li")
      .eq(2)
      .prependTo($(".main-cooper ul"));
    $(".main-cooper ul").css("margin-left", "-200px");
    $(".main-cooper ul")
      .not(":animated")
      .animate({ "margin-left": "0px" }, 500);
  }
  $(".main-cooper-btn .prev").click(function() {
    prevAni();
  });
  $(".main-cooper-btn .next").click(function() {
    nextAni();
  });
  
  
  connectRecord();
  
  
});



function connectRecord(){
	
	$.ajax({
		url : "/connectRecord.do",
		type : "get",
		data : {
		},
		success : function(data) {
		}
	});
	
	
}