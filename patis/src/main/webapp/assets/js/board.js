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
	
	var b_type = $('#board-list-js').data('btype');
	if(!isEmpty(b_type)) {
		b_type = b_type.toLowerCase();
		if($('#' + b_type + '-board-js').length > 0) 
			getPageContent(1);
	}
});

var search_type = '';
var search_keyword = '';

function getPageContent(page){
	var b_type = $('#board-list-js').data('btype').toLowerCase();
	var parent = numberFormat($('#board-list-js').data('parent'), 2);
	var code = numberFormat($('#board-list-js').data('code'), 2);

	$.ajax({
		url 	: "/nm02" + parent + code + "Init.do",
		type	: "get",
		data	: { "page": page, "search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			$("#" + b_type + "-board-js").html(data);
		}
	});
	$.ajax({
		url 	: "/nm02" + parent + code + "Paging.do",
		type	: "get",
		data    : {"search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			var total_page = $('#board-pagination-js .page-number').length;
			$('#board-pagination-js .page-number').removeClass('active');
			$('#board-pagination-js .page-number').eq(page-1).addClass('active');
			$('#board-pagination-js .control-left').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(page == 1 ? 1 : page-1);
			});
			$('#board-pagination-js .control-right').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(page == total_page ? total_page : page+1);
			});
			
			$("#" + b_type + "-paging-js").html(data);
		}
	});
}

function boardSearchHandler() {
	search_type = $('#search-type-list-js li').data('type');
    search_keyword = $('#search-keyword-js').val();
}

function boardListMoveHandler(b_type) {
	b_type = b_type.toLowerCase();
	$('#frm-' + b_type).submit();
}

function boardDetailMoveHandler(b_type, b_no) {
	boardHitUp(b_no);
	b_type = b_type.toLowerCase();
	$('#frm-' + b_type + '-detail input[name=b_no]').val(b_no);
	$('#frm-' + b_type + '-detail').submit();
}

function boardHitUp(b_no) {
	$.ajax({
		url: '/collusion.apply.hitUp.do',
		type: 'post',
		dataType: 'json',
		data: {'b_no': b_no},
		success: function(data) {
			if(data < 1) {
				console.log('서버에 문제가 발생하여 조회수 증가 처리에 에러가 발생했습니다.');
			}
		},
		error: function() {
			console.log('error');
		}
	});
}