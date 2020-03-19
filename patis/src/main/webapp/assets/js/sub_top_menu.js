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
	$("#sub-container-js .sub-content-wrap").removeClass('active');
	$("#sub-container-js .sub-content-wrap").eq(menuNumber-1).addClass('active');
	$("#sub_top_subject-js li").removeClass("active");
	$("#sub_top_subject-js li").eq(menuNumber-1).addClass("active");

	setTitleName(menuName);
	boardSearchInit();
	getPageContent(1);
}

function _topMenuActiveInit(tab) {
	var menuName = $('#sub_top_subject-js li').eq(tab-1).find('span').text();
	$("#sub-container-js .sub-content-wrap").removeClass('active');
	$("#sub-container-js .sub-content-wrap").eq(tab-1).addClass('active');
	$("#sub_top_subject-js li").removeClass("active");
	$("#sub_top_subject-js li").eq(tab-1).addClass("active");
	
	setTitleName(menuName);
	boardSearchEventInit();
	getPageContent(1);
}

function setTitleName(name) {
	$(".sub_title-js").text(name);
}
