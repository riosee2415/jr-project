$(document).ready(function() {
	$('#share-button-js').on('click', function() {
		$(this).toggleClass('active');
		
		if($(this).hasClass('active')) {
			$('#share-list-js').show();
		} else {
			$('#share-list-js').hide();
		}
	});
	
	$('#share-list-js li').on('click', function() {
		var sns = $(this).data('sns');
		alert(sns);
	});
});