function findHandler(value) {
  if (value == "myBirth") {
    $("#info-birth-js").show();
    $("#info-email-js").hide();
  } else if (value == "myEmail") {
    $("#info-birth-js").hide();
    $("#info-email-js").show();
  }
}
