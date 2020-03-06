$(document).ready(function() {
  var intv = setInterval(function() {
    nextAni();
  }, 2800);
  function nextAni() {
    $(".main-container__slide")
      .not(":animated")
      .animate({ "margin-left": "-700px" }, 500, function() {
        $(".main-container__slide li")
          .eq(0)
          .appendTo($(".main-container__slide"));
        $(".main-container__slide").css("margin-left", "0px");
        $(".btn_box li")
          .eq(0)
          .appendTo($(".btn_box"));
        $(".btn_box li")
          .eq(0)
          .addClass("on");
        $(".btn_box li")
          .not(":first-child")
          .removeClass("on");
      });
  }
  function prevAni() {
    $(".main-container__slide li")
      .eq(2)
      .prependTo($(".main-container__slide"));
    $(".main-container__slide").css("margin-left", "-700px");
    $(".main-container__slide")
      .not(":animated")
      .animate({ "margin-left": "0px" }, 500);
  }
  $(".btn_box .btn").click(function() {
    nextAni();
  });
});
