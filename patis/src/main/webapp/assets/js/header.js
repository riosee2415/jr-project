function stopScroll() {
  $("#collap_menu").on("scroll touchmove mousewheel", function(event) {
    event.preventDefault();
    event.stopPropagation();
    return false;
  });
}

function mobileMenuHandler(menu) {
	var menuSelector = menu.parentNode;
	
	if(!$(menuSelector).hasClass("active")) {
		$("#collap_menu .menu li").removeClass("active");
	}
	$(menuSelector).toggleClass("active");
}
