function stopScroll() {
  $("#collap_menu").on("scroll touchmove mousewheel", function(event) {
    event.preventDefault();
    event.stopPropagation();
    return false;
  });
}

function mobileMenuHandler(menu) {
	
	var menuSelector = menu.parentNode;
	
	$(menuSelector).toggleClass("active");
}
