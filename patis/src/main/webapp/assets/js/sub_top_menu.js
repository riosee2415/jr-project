$(document).ready(function() {
	function applyTopMenuGrid() {
		var menuCount = $("#sub_top_subject-js li").length;
		var className = "";
		switch(menuCount) {
		case 1:
			className = "menu-one";
			break;
		case 2:
			className = "menu-two";
			break;
		case 3:
			className = "menu-three";
			break;
		default:
			className = "menu-more";
		}
		$("#sub_top_subject-js").addClass(className);
	}
	applyTopMenuGrid();
});

function _topMenuClickHandler(menuNumber, menuName) {
	$(".sub_title-js").text(menuName);
	$("#sub-container-js .sub-content-wrap").hide();
	$("#sub-container-js .sub-content-wrap").eq(menuNumber-1).show();
	$("#sub_top_subject-js li").removeClass("active");
	$("#sub_top_subject-js li").eq(menuNumber-1).addClass("active");
}
