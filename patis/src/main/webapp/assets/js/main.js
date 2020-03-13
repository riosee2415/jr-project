$(document).ready(function() {
  var currentSlide = 1;
  var totalSlide = $("#slide-btn-js .slide-button").length;
  var slideInterval;
  var slideSize;

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
    slideMove(idx);
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
  }

  function slideNext() {
    if (currentSlide > totalSlide) currentSlide = 1;
    $("#slide-btn-js .slide-button")
      .find(".btn")
      .removeClass("on");
    $("#slide-btn-js .slide-button")
      .eq(currentSlide - 1)
      .find(".btn")
      .addClass("on");

    slideSize = $("#slide-image-js li a")
      .css("width")
      .replace("px", "");
    var marginLeft = "-" + slideSize * (currentSlide - 1);
    $("#slide-image-js").animate({ "margin-left": marginLeft }, 500);

    currentSlide++;
  }

  function slideMove(idx) {
    slidePause();

    currentSlide = idx + 1;
    $("#slide-btn-js .slide-button")
      .find(".btn")
      .removeClass("on");
    $("#slide-btn-js .slide-button")
      .eq(currentSlide - 1)
      .find(".btn")
      .addClass("on");

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
