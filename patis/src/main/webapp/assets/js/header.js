function stopScroll() {
  $("#collap_menu").on("scroll touchmove mousewheel", function(event) {
    event.preventDefault();
    event.stopPropagation();
    return false;
  });
}

function mobileMenuHandler() {
  $(".collap-menu-sub")
    .parent()
    .toggleClass("active");
}
