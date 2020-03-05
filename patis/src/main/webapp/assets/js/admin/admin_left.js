$(document).ready(function() {
	$('#left-menu-icon-js ul li').on('click', function() {
		var menuIndex = $(this).index();
		$('#left-menu-icon-js ul li').removeClass('active');
		$(this).addClass('active');
		
		$('#left-menu-list-js .lefe-menu-list__area').removeClass('active');
		$('#left-menu-list-js .lefe-menu-list__area').eq(menuIndex).addClass('active');
	});
});