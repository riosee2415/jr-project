$(document).ready(function() {
	$('#family-area-js .family__box').on('click', function() {
		$(this).toggleClass('active');
		
		if($(this).hasClass('active')) {
			$(this).siblings('.family__list').show();
			$(this).find('.fa').removeClass('fa-caret-down');
			$(this).find('.fa').addClass('fa-caret-up');
		} else {
			$(this).siblings('.family__list').hide();
			$(this).find('.fa').removeClass('fa-caret-up');
			$(this).find('.fa').addClass('fa-caret-down');
		}
	});
	
	$('#family-area-js .family__list li').on('click', function() {
		$(this).parent().hide();
		$(this).parent().siblings('.family__box').find('.fa').removeClass('fa-caret-up');
		$(this).parent().siblings('.family__box').find('.fa').addClass('fa-caret-down');
	})
});