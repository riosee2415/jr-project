$(document).ready(function() {
	$('#search-type-js').on('click', function() {
		$(this).toggleClass('active');
	
		if($(this).hasClass('active')) {
			$('#search-type-list-js').show();
		} else {
			$('#search-type-list-js').hide();
		}
	});
	
	$('#search-type-list-js li').on('click', function() {
		var selectedType = $(this).text();
		$('#search-type-js').removeClass('active');
		$('#search-type-js .search-type-text').text(selectedType);
		$('#search-type-list-js li').removeClass('active');
		$(this).addClass('active');
		$(this).parent().hide();
	});
	
	if($('#collusion-board-js').length > 0) getCollusionPageContent(1);
	if($('#statute-board-js').length > 0) getStatutePageContent(1);
});

function getCollusionPageContent(page){
	var total_page = $('#board-pagination-js .page-number').length;
	$('#board-pagination-js .page-number').removeClass('active');
	$('#board-pagination-js .page-number').eq(page-1).addClass('active');
	$('#board-pagination-js .control-left').on('click', function(e) {
		e.stopImmediatePropagation();
		getCollusionPageContent(page == 1 ? 1 : page-1);
	});
	$('#board-pagination-js .control-right').on('click', function(e) {
		e.stopImmediatePropagation();
		getCollusionPageContent(page == total_page ? total_page : page+1);
	});
	$.ajax({
		url 	: "/nm021164Init.do",
		type	: "get",
		data	: { "page" : page },
		success : function(data){
			$("#collusion-board-js").html(data);
		}
	});
}

function goCollusionListHandler() {
	$('#frm-collusion').submit();
}

function goCollusionDetailHandler(b_no) {
	$('#frm-collusion-detail input[name=b_no]').val(b_no);
	$('#frm-collusion-detail').submit();
}

function getStatutePageContent(page){
	var total_page = $('#board-pagination-js .page-number').length;
	$('#board-pagination-js .page-number').removeClass('active');
	$('#board-pagination-js .page-number').eq(page-1).addClass('active');
	$('#board-pagination-js .control-left').on('click', function(e) {
		e.stopImmediatePropagation();
		getStatutePageContent(page == 1 ? 1 : page-1);
	});
	$('#board-pagination-js .control-right').on('click', function(e) {
		e.stopImmediatePropagation();
		getStatutePageContent(page == total_page ? total_page : page+1);
	});
	$.ajax({
		url 	: "/nm0204131Init.do",
		type	: "get",
		data	: { "page" : page },
		success : function(data){
			$("#statute-board-js").html(data);
		}
	});
}