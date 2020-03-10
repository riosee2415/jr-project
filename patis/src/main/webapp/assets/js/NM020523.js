$(document).ready(function() {
  $("#sub-content-js .nm23-content")
    .eq(0)
    .show();

  $("#nm23-select-js li").on("click", function() {
    var index = $(this).index();
    $("#nm23-select-js li").removeClass("active");
    $(this).addClass("active");

    $("#sub-content-js .nm23-content").hide();
    $("#sub-content-js .nm23-content")
      .eq(index)
      .show();
  });
});
