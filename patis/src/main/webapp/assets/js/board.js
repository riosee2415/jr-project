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
	
	if(!boardSearchInit()) {
		var b_type = $('#board-list-js').data('btype');
		if(!isEmpty(b_type)) {
			b_type = b_type.toLowerCase();
			if($('#' + b_type + '-board-js').length > 0) 
				getPageContent(1);
		}
	} 
});

var search_type = '';
var search_keyword = '';

function getPageContent(paging){
	var b_type = $('#board-list-js').data('btype').toLowerCase();
	var parent = numberFormat($('#board-list-js').data('parent'), 2);
	var code = numberFormat($('#board-list-js').data('code'), 2);
 
	$.ajax({
		url 	: "/nm02" + parent + code + "Init.do",
		type	: "get",
		data	: {"paging": paging, "search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			$("#" + b_type + "-board-js").html(data);
			
			if($("#" + b_type + "-board-js tr").first().hasClass('row-empty')) {
				$("#" + b_type + "-paging-js").hide();
			} else {
				$("#" + b_type + "-paging-js").show();
			}
		}
	});
	$.ajax({
		url 	: "/nm02" + parent + code + "Paging.do",
		type	: "get",
		data    : {"search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			$("#" + b_type + "-paging-js").html(data);
			
			var total_page = $('#board-pagination-js .page-number').length;
			$('#board-pagination-js .page-number').removeClass('active');
			$('#board-pagination-js .page-number').eq(paging-1).addClass('active');
			$('#board-pagination-js .control-left').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(paging == 1 ? 1 : paging-1);
			});
			$('#board-pagination-js .control-right').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(paging == total_page ? total_page : paging+1);
			});
		}
	});
}

function boardSearchHandler() {
	var flag = validationInputLength($('#search-keyword-js').val());
	if(flag) {
		$('#search-keyword-js').val('');
		$('#search-keyword-js').focus();
		return;
	}
	search_type = $('#search-type-list-js li.active').data('type');
    search_keyword = $('#search-keyword-js').val();
    
    getPageContent(1);
}

function boardSearchEnterHandler() {
    if (event.keyCode == 13) {
      boardSearchHandler();
    }
}

function boardListMoveHandler(b_type, s_type, s_keyword) {
	b_type = b_type.toLowerCase();
	$('#frm-' + b_type + ' input[name=s_type]').val(s_type);
	$('#frm-' + b_type + ' input[name=s_keyword]').val(s_keyword);
	$('#frm-' + b_type).submit();
}

function boardDetailMoveHandler(b_type, b_no, rownum, type, keyword) {
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	boardHitUp(b_no);
	b_type = b_type.toLowerCase();
	$('#frm-' + b_type + '-detail input[name=b_no]').val(b_no);
	$('#frm-' + b_type + '-detail input[name=rownum]').val(rownum);
	$('#frm-' + b_type + '-detail input[name=s_type]').val(s_type);
	$('#frm-' + b_type + '-detail input[name=s_keyword]').val(s_keyword);
	$('#frm-' + b_type + '-detail').submit();
}

function boardHitUp(b_no) {
	$.ajax({
		url: '/collusion.apply.hitUp.do',
		type: 'post',
		dataType: 'json',
		data: {'b_no': b_no},
		success: function(data) {
			if(data.result < 1) {
				console.log('서버에 문제가 발생하여 조회수 증가 처리에 에러가 발생했습니다.');
			}
		},
		error: function() {
			console.log('error');
		}
	});
}

function boardSearchInit() {
	var result = false;
	var s_type = $('#search-area-js').data('type');
	var s_keyword = $('#search-area-js').data('keyword');
	if(!isEmpty(s_type) && !isEmpty(s_keyword)) {
		search_type = s_type;
		search_keyword = s_keyword;
		
		$('#search-type-list-js li').removeClass('active');
		$.each($('#search-type-list-js li'), function(index, value) {
			if($(this).data('type') == search_type) {
				$(this).addClass('active');
				$('#search-type-js .search-type-text').text($(this).text());
			}
		});
		$('#search-keyword-js').val(search_keyword);
		
		getPageContent(1);
		result = true;
	}
	return result;
}