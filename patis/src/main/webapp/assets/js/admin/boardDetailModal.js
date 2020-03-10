function intoComments() {
  var modalPop = $(".modal-pop");
  $(modalPop).click(function() {
    $(".modal").css("display", "block");
  });
  $(".modal-X").click(function() {
    $(".modal").css("display", "none");
  });
}
