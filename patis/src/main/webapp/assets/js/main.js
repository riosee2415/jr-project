$(document).ready(function() {
  var currentSlide = 1;
  var totalSlide = $("#slide-image-js li").length;
  var slideInterval;
  var slideSize;
  var slideMove = 1;
  var isPlay = 0;
  
  if (totalSlide > 0) slidePlay();

  $("#slide-btn-js .slide-control").on("click", function() {
    var control = $(this).find("button");

    if (control.hasClass("pause")) {
      slidePause();
    } else {
      slidePlay();
    }
  });

  $("#slide-btn-js .slide-button").on("click", function() {
    var idx = $(this).index();
    
    slideMove = idx == 0 ? -1 : 1;
    if(isPlay == 0) slidePlay();
  });

  function slidePlay() {
    slideInterval = setInterval(function() {
    	slideMove == -1 ? slidePrev() : slideNext(); 
    }, 3000);
    $("#slide-btn-js .slide-control button").removeClass("play");
    $("#slide-btn-js .slide-control button").addClass("pause");
    isPlay = 1;
  }

  function slidePause() {
    clearInterval(slideInterval);
    $("#slide-btn-js .slide-control button").removeClass("pause");
    $("#slide-btn-js .slide-control button").addClass("play");
    isPlay = 0;
  }

  function slideNext() {
    clearInterval(slideInterval);
    if (currentSlide > totalSlide) currentSlide = 1;

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

  function slideMove(idx) {
    slidePause();

    currentSlide = idx + 1;

    slideSize = $("#slide-image-js li a")
      .css("width")
      .replace("px", "");
    var marginLeft = "-" + slideSize * (currentSlide - 1);
    $("#slide-image-js").animate({ "margin-left": marginLeft }, 500);

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
