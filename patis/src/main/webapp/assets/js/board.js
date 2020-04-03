$(document).ready(function() {
	boardSearchInit();
	boardCommentInit();
	
	if(!boardSearchStatus()) {
		var b_type = $(CURRENT_PAGE + ' #board-list-js').data('btype');
		if(!isEmpty(b_type)) {
			b_type = b_type.toLowerCase();
			if($(CURRENT_PAGE + ' #' + b_type + '-board-js').length > 0) 
				getPageContent(1);
		}
	} 
});

var search_type = '';
var search_keyword = '';

function getPageContent(paging){
	if($(CURRENT_PAGE + ' #board-list-js').length < 1) return;
	
	var b_type = $(CURRENT_PAGE + ' #board-list-js').data('btype').toLowerCase();
	var parent = numberFormat($(CURRENT_PAGE + ' #board-list-js').data('parent'), 2);
	var code = numberFormat($(CURRENT_PAGE + ' #board-list-js').data('code'), 2);
	var tab = $(CURRENT_PAGE).index() + 1;
	
	$.ajax({
		url 	: "/nm02" + parent + code + "Init.do",
		type	: "get",
		data	: {"tab": tab, "paging": paging, "search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			var page = data.split('-----');
			$(CURRENT_PAGE + " #" + b_type + "-board-js").html(page[0]);
			$(CURRENT_PAGE + " #" + b_type + "-board-m-js").html(page[1]);
			
			if($(CURRENT_PAGE + " #" + b_type + "-board-js tr").first().hasClass('row-empty')) {
				$(CURRENT_PAGE + " #" + b_type + "-paging-js").hide();
			} else {
				$(CURRENT_PAGE + " #" + b_type + "-paging-js").show();
			}
			$(CURRENT_PAGE + " #" + b_type + "-button-js").show();
		}
	});
	$.ajax({
		url 	: "/nm02" + parent + code + "Paging.do",
		type	: "get",
		data    : {"tab": tab, "search_type": search_type, "search_keyword": search_keyword},
		success : function(data){
			$(CURRENT_PAGE + " #" + b_type + "-paging-js").html(data);
			
			var total_page = $(CURRENT_PAGE + ' #board-pagination-js .page-number').length;
			$(CURRENT_PAGE + ' #board-pagination-js .page-number').removeClass('active');
			$(CURRENT_PAGE + ' #board-pagination-js .page-number').eq(paging-1).addClass('active');
			$(CURRENT_PAGE + ' #board-pagination-js .control-left').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(paging == 1 ? 1 : paging-1);
			});
			$(CURRENT_PAGE + ' #board-pagination-js .control-right').on('click', function(e) {
				e.stopImmediatePropagation();
				getPageContent(paging == total_page ? total_page : paging+1);
			});
		}
	});
}

function boardSearchHandler() {
	var flag = validationInputLength($(CURRENT_PAGE + ' .search-keyword').val());
	if(flag) {
		$(CURRENT_PAGE + ' .search-keyword').val('');
		$(CURRENT_PAGE + ' .search-keyword').focus();
		return;
	}
	search_type = $(CURRENT_PAGE + ' #search-type-list-js li.active').data('type');
    search_keyword = $(CURRENT_PAGE + ' .search-keyword').val();
    
    getPageContent(1);
}

function boardSearchEnterHandler() {
    if (event.keyCode == 13) {
      boardSearchHandler();
    }
}

function boardListMoveHandler(b_type, s_type, s_keyword) {
	b_type = b_type.toLowerCase();
	$(CURRENT_PAGE + ' #frm-' + b_type + ' input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + ' input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type).submit();
}

function boardDetailMoveHandler(b_type, b_no, rownum, type, keyword) {
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	
	boardHitUp(b_type, b_no);
	b_type = b_type.toLowerCase();
	$(CURRENT_PAGE + ' #frm-' + b_type + '-detail input[name=b_no]').val(b_no);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-detail input[name=rownum]').val(rownum);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-detail input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-detail input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-detail').submit();
}

function boardWriteMoveHandler(b_type, type, keyword, b_no) {
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	
	b_type = b_type.toLowerCase();
	
	if(!isEmpty(b_no))
		$(CURRENT_PAGE + ' #frm-' + b_type + '-write input[name=b_no]').val(b_no);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write').submit();
}

var remove_file = new Array();
function boardWriteProcessHandler(b_type, mode, b_no) {
	var b_gubun = $(CURRENT_PAGE + ' #input-gubun-js').val();
	var b_author = $(CURRENT_PAGE + ' #input-author-js').val();
	var b_title = $(CURRENT_PAGE + ' #input-title-js').val();
	
	b_type = b_type.toLowerCase();
	
	if($(CURRENT_PAGE + ' #input-author-js').length > 0 && isEmpty(b_author)) {
		alert('작성자를 입력해주세요.');
		$(CURRENT_PAGE + ' #input-author-js').focus();
		return;
	}
	if(isEmpty(b_title)) {
		alert('제목을 입력해주세요.');
		$(CURRENT_PAGE + ' #input-title-js').focus();
		return;
	} 
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write-process input[name=b_gubun]').val(b_gubun);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write-process input[name=b_title]').val(b_title);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-write-process input[name=remove_file]').val(remove_file.join(','));
	
	var message = '';
	if(mode == 'WRITE') {
		message = '입력하신 내용으로 게시글을 등록하시겠습니까 ?';
	} else {
		message = '입력하신 내용으로 게시글을 변경하시겠습니까 ?';
	}
	if(confirm(message)) {
		var files = $('#tx_canvas iframe').contents().find('body').find('.txc-file');
		$.each(files, function(index, value) {
			var file = value.firstChild.getAttribute('ld');
			
			if(!isEmpty(file)) {
				var ext = file.slice(file.lastIndexOf('.') + 1).toLowerCase();
				var ext_array = ['mp4', 'mpg', 'mpeg', 'mpe', 'mkv', 'mov', 'wmv', 'asf', 'asx', 'flv', 'rm', 'ts', 'tp', 'dat', '3gp', 'avi']
				
				var isExist = false;
				ext_array.forEach(function(item, index, array) {
					if(item == ext) {
						isExist = true;
					}
				});
				if(isExist) {
					var html = '<video src="' + file + '" poster="/assets/images/image/default-thumbnail.png" controls preload="none" style="display: block; margin: 0 auto; width: 70%;"></video>';
					$('#tx_canvas iframe').contents().find('body').find('.txc-file').parent().html(html);
				}
				else
					$('#tx_canvas iframe').contents().find('body').find('.txc-file').remove();
			}
		});
		if(mode == 'WRITE')
			sendBoardWriteMail(b_type);
		Editor.save();
	}
}

function boardRemoveProcessHandler(b_type, b_no, type, keyword) {
	if(!confirm('해당 작성 글을 삭제하시겠습니까 ?')) {
		return;
	}
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	
	b_type = b_type.toLowerCase();
	
	$(CURRENT_PAGE + ' #frm-' + b_type + '-remove input[name=b_no]').val(b_no);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-remove input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-remove input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-remove').submit();
}


function boardRemoveFileHandler(obj, file_no) {
	event.stopPropagation();
	if(obj.previousSibling.previousSibling.classList.contains('remove')) {
		alert('이미 삭제한 첨부파일 입니다.');
	} else {
		if(confirm('선택한 첨부파일을 삭제하시겠습니까 ?')) {
			obj.previousSibling.previousSibling.classList.toggle('remove');
			remove_file.push(file_no);
		}
	}
}

function boardHitUp(b_type, b_no) {
	$.ajax({
		url: '/' + b_type.toLowerCase() + '.hitUp.do',
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
	search_type = '';
	search_keyword = '';
	
	$(CURRENT_PAGE + ' .search-keyword').val('');
	
	boardSearchEventInit();
}

function boardSearchEventInit() {
	var btype = $(CURRENT_PAGE + ' #board-list-js').data('btype');
	if(btype == 'STATUTE' || btype == 'NOTICE') 
		$(CURRENT_PAGE + ' #search-type-gubun').show();
	$('.board-search-type #search-type-js').removeClass('active');
	$('.board-search-type #search-type-js').attr('onclick', '').unbind('click');
	$(CURRENT_PAGE + ' #search-type-js').on('click', function(e) {
		e.preventDefault();
		
		$(this).toggleClass('active');
		
		if($(this).hasClass('active')) {
			$(CURRENT_PAGE + ' #search-type-list-js').show();
		} else {
			$(CURRENT_PAGE + ' #search-type-list-js').hide();
		}
	});
	
	$('.board-search-type #search-type-list-js li').attr('onclick', '').unbind('click');
	$(CURRENT_PAGE + ' #search-type-list-js li').on('click', function(e) {
		e.preventDefault();
		
		var selectedType = $(this).text();
		$(CURRENT_PAGE + ' #search-type-js').removeClass('active');
		$(CURRENT_PAGE + ' #search-type-js .search-type-text').text(selectedType);
		$(CURRENT_PAGE + ' #search-type-list-js li').removeClass('active');
		$(this).addClass('active');
		$(this).parent().hide();
	});
}

function boardSearchStatus() {
	var result = false;
	var s_type = $(CURRENT_PAGE + ' #search-area-js').data('type');
	var s_keyword = $(CURRENT_PAGE + ' #search-area-js').data('keyword');
	if(!isEmpty(s_type) && !isEmpty(s_keyword)) {
		search_type = s_type;
		search_keyword = s_keyword;
		
		$(CURRENT_PAGE + ' #search-type-list-js li').removeClass('active');
		$.each($(CURRENT_PAGE + ' #search-type-list-js li'), function(index, value) {
			if($(this).data('type') == search_type) {
				$(this).addClass('active');
				$(CURRENT_PAGE + ' #search-type-js .search-type-text').text($(this).text());
			}
		});
		$(CURRENT_PAGE + ' .search-keyword').val(search_keyword);
		
		getPageContent(1);
		result = true;
	}
	return result;
}

function boardCommentInit() {
	if($(CURRENT_PAGE + ' #board-comment-js').length == 0) return;
	
	var b_type = $(CURRENT_PAGE + ' #board-comment-js').data('btype');
	var p_no = $(CURRENT_PAGE + ' #board-comment-js').data('pno');
	$.ajax({
		url: '/commentList.do',
		type: 'get',
		data: {'b_type': b_type, 'p_no': p_no},
		success: function(data) {
			$(CURRENT_PAGE + ' #comment-list-js').html(data);
		},
		error: function() {
			console.log('error');
		}
	});
}

var commentMode = 'WRITE';

function boardCommentWrite(loginNo, co_no) {
	if(isEmpty(loginNo)) {
		alert('로그인 후 이용 가능합니다.');
		return;
	}
	
	var desc = $(CURRENT_PAGE + ' #write-input-js').val();
	if(isEmpty(desc)) {
		alert('작성하실 댓글을 입력해주세요.');
		$(CURRENT_PAGE + ' #write-input-js').focus();
		return;
	}
	desc = desc.replace(/(?:\r\n|\r|\n)/g, '<br/>');
	
	if(commentMode == 'WRITE') {
		if(confirm('입력하신 내용으로 댓글을 작성하시겠습니까 ?')) {
			var b_type = $(CURRENT_PAGE + ' #board-comment-js').data('btype');
			var p_no = $(CURRENT_PAGE + ' #board-comment-js').data('pno');
			$.ajax({
				url: '/commentWrite.do',
				type: 'post',
				dataType: 'json',
				data: {'b_type': b_type, 'p_no': p_no, 'desc': desc, 'author': loginNo},
				success: function(data) {
					if(data.result == 0) {
						alert('댓글 작성에 실패했습니다.');
					} else {
						$(CURRENT_PAGE + ' #write-input-js').val('');
						boardCommentInit();
					}
				},
				error: function() {
					console.log('error');
				}
			});
		}
	} else {
		if(confirm('입력하신 내용으로 댓글을 변경하시겠습니까 ?')) {
			var co_no = $(CURRENT_PAGE + ' #write-button-js').data('no');
			$.ajax({
				url: '/commentModify.do',
				type: 'post',
				dataType: 'json',
				data: {'co_no': co_no, desc: desc},
				success: function(data) {
					if(data.result == 0) {
						alert('댓글 수정에 실패했습니다.');
					} else {
						commentMode = 'WRITE';
						$(CURRENT_PAGE + ' #write-input-js').val('');
						$(CURRENT_PAGE + ' #write-button-js').text('등록');
						boardCommentInit();
					}
				},
				error: function() {
					console.log('error');
				}
			});
		}
	}
}

function boardCommentModify(co_no, co_description) {
	co_description = co_description.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
	co_description = co_description.replace('</button>', '');
	
	$(CURRENT_PAGE + ' #write-input-js').val(co_description);
	$(CURRENT_PAGE + ' #write-input-js').focus();
	$(CURRENT_PAGE + ' #write-button-js').text('변경');
	$(CURRENT_PAGE + ' #write-button-js').data('no', co_no);
	commentMode = "MODIFY";
}

function boardCommentRemove(co_no) {
	if(confirm('해당 댓글을 삭제하시겠습니까 ?')) {
		$.ajax({
			url: '/commentRemove.do',
			type: 'post',
			dataType: 'json',
			data: {'co_no': co_no},
			success: function(data) {
				if(data.result == 0) {
					alert('댓글을 삭제 처리하는 중 문제가 발생했습니다.');
				} else {
					boardCommentInit();
				}
			},
			error: function() {
				console.log('error');
			}
		});
	}
}

function boardReplyMoveHandler(b_type, b_no, type, keyword) {
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	
	boardReplyHitUp(b_type, b_no);
	b_type = b_type.toLowerCase();
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply input[name=b_no]').val(b_no);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply').submit();
}

function boardReplyWriteProcessHandler(b_type, mode, b_no, type, keyword) {
	var b_reply = $(CURRENT_PAGE + ' #input-reply-js').val();
	
	b_type = b_type.toLowerCase();
	
	if(isEmpty(b_reply)) {
		alert('답변을 입력해주세요.');
		$(CURRENT_PAGE + ' #input-reply-js').focus();
		return;
	} 
	
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process input[name=mode]').val(mode);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process input[name=s_type]').val(type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process input[name=s_keyword]').val(keyword);
	
	var message = '';
	if(mode == 'WRITE') {
		message = '입력하신 내용으로 답변을 등록하시겠습니까 ?';
	} else {
		message = '입력하신 내용으로 답변을 변경하시겠습니까 ?';
	}
	if(confirm(message)) {
		var txt_reply = $(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process textarea[name=b_reply]').val();
		$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process textarea[name=b_reply]').val(txt_reply.replace(/(?:\r\n|\r|\n)/g, '<br />'));
		$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-write-process').submit();
		return;
	}
}

function boardReplyModifyHandler(b_type, mode, b_no, type, keyword) {
	var text = $(CURRENT_PAGE + " #reply-modify-js").text();
	
	if(text == '수정') {
		var b_reply = $(CURRENT_PAGE + " #reply-data-js").text().trim();
		var html = '<textarea name="b_reply" id="input-reply-js">' + b_reply + '</textarea>';
		
		$(CURRENT_PAGE + " #reply-modify-js").text('변경');
		$(CURRENT_PAGE + " #reply-data-js").html(html);
		$(CURRENT_PAGE + " #input-reply-js").focus();
	} else {
		var b_reply = $(CURRENT_PAGE + " #input-reply-js").text();
		if(isEmpty(b_reply)) {
			alert("답변을 입력해주세요.");
			$(CURRENT_PAGE + " #reply-modify-js").focus();
			return;
		}
		boardReplyWriteProcessHandler(b_type, mode, b_no, type, keyword);
	}
}

function boardReplyRemoveProcessHandler(b_type, b_no, type, keyword) {
	if(!confirm('해당 답변 글을 삭제하시겠습니까 ?')) {
		return;
	}
	var s_type = isEmpty(type) ? search_type : type;
	var s_keyword = isEmpty(keyword) ? search_keyword : keyword;
	
	b_type = b_type.toLowerCase();
	
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-remove input[name=b_no]').val(b_no);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-remove input[name=s_type]').val(s_type);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-remove input[name=s_keyword]').val(s_keyword);
	$(CURRENT_PAGE + ' #frm-' + b_type + '-reply-remove').submit();
}

function boardReplyHitUp(b_type, b_no) {
	$.ajax({
		url: '/' + b_type.toLowerCase() + '.replyHitUp.do',
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

function boardThumbnailCilckHandler() {
	$('#thumbnail-file-js').click();
}

function boardThumbnailFileHandler(obj) {
	var fileName = document.getElementById('thumbnail-file-js').value;
	fileName = fileName.slice(fileName.indexOf('.') + 1).toLowerCase();
	
	if(fileName != "jpg" && fileName != "png" &&  fileName != "gif" &&  fileName != "bmp"){
		alert('이미지만 업로드 할 수 있습니다.');
		return;
	}
	if (obj.files && obj.files[0]) {
	   var reader = new FileReader();
	   reader.onload = function(e) {
	       $('#thumbnail-image-js').attr('src', e.target.result);
	   }
	   reader.readAsDataURL(obj.files[0]);
	}
}

function fileDownload(fileNo, filePath, fileName, obj) {
	if(obj.classList.contains('remove')) {
		if(confirm('삭제하신 파일을 복구하시겠습니까 ?')) {
			obj.classList.toggle('remove');
			remove_file.splice(remove_file.indexOf(fileNo), 1);
		}
		return;
	}
	$("#frm-download input[name='filePath']").val(filePath);
	$("#frm-download input[name='fileName']").val(fileName);
	$("#frm-download").submit();
}

function sendBoardWriteMail(b_type) {
	$.ajax({
		url: '/sendBoardWriteMail.do',
		type: 'post',
		dataType: 'json',
		data: {'b_type': b_type},
		error: function(a, b, c) {
			console.log(a + b + c);
		}
	});
}