$(document).ready(function() {
  var currentSlide = 1;
  var totalSlide = $("#slide-image-js li").length;
  var slideInterval;
  var slideSize;
  
  if (totalSlide > 0) slidePlay();

  setInterval(function() {
	    $(".loading-ani").fadeOut();
	  }, 2300);
  
  $("#slide-btn-js .slide-control").on("click", function(e) {
	e.stopImmediatePropagation();
	  
    var control = $(this).find("button");

    if (control.hasClass("pause")) {
      slidePause();
    } else {
      slidePlay();
    }
  });

  $("#slide-btn-js .slide-button").on("click", function(e) {
	e.stopImmediatePropagation();
	
    var idx = $(this).index();
    
    idx == 0 ? slidePrev() : slideNext();
  });

  function slidePlay() {
    slideInterval = setInterval(function() {
    	slideNext();
    }, 3000);
    $("#slide-btn-js .slide-control button").removeClass("play");
    $("#slide-btn-js .slide-control button").addClass("pause");
  }

  function slidePause() {
    clearInterval(slideInterval);
    $("#slide-btn-js .slide-control button").removeClass("pause");
    $("#slide-btn-js .slide-control button").addClass("play");
    isPlay = 0;
  }

  function slideNext() {
    clearInterval(slideInterval);
    
    if (currentSlide > totalSlide-1) currentSlide = 0;

    currentSlide++;
    
    slideSize = $("#slide-image-js li a")
      .css("width")
      .replace("px", "");
    var marginLeft = "-" + slideSize * (currentSlide - 1);
    $("#slide-image-js").animate({ "margin-left": marginLeft }, 500);

    slidePlay();
  }
  
  function slidePrev() {
    clearInterval(slideInterval);
    
    if (currentSlide < 1) currentSlide = totalSlide;

    currentSlide--;
    
    slideSize = $("#slide-image-js li a")
      .css("width")
      .replace("px", "");
    var marginLeft = "-" + slideSize * (currentSlide - 1);
    
    $("#slide-image-js").animate({"margin-left": marginLeft }, 500);
    
    slidePlay();
  }
  
  
});

function emailSelection() {
  $("select[name=emailSelection]").change(function() {
    if ($(this).val() == "1") {
      $(".emailBox").val("");
    } else {
      $(".emailBox").val($(this).val());

      $(".emailBox").attr("readonly", true);
    }
  });
}


function closeMainModal(id){	
	$("#"+id).css("display", "none");
}

