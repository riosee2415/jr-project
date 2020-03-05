$(document).ready(function() {
  function nextAni() {
    $(".main-container__slide")
      .not(":animated")
      .animate({ "margin-left": "-700px" }, 500, function() {
        $(".main-container__slide li")
          .eq(0)
          .appendTo($(".main-container__slide"));
        $(".main-container__slide").css("margin-left", "0px");
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
    $(".btn_box .btn").eq(0).addClass("on");
  });
});
