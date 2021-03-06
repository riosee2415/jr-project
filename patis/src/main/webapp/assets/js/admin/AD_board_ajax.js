$(document).ready(function() {
	$('.check-all').click(function() {
		$('.ab').prop('checked', this.checked);
	});
})

function noticeBtnHandler(status, no, btn) {
	var mc = numberFormat($("#ad02-table").data("mc"), 2);
	var sc = numberFormat($("#ad02-table").data("sc"), 2);

	var adCode = mc + sc;

	$.ajax({
		url : "/ad" + adCode + "Notice.do",
		type : "get",
		data : {
			"status" : status,
			"no" : no
		},
		success : function(data) {
			getPageContent(currentPage);
			alert("처리완료");
		}
	});
}

function deleteBtnHandler(no, btn) {
	var mc = numberFormat($("#ad02-table").data("mc"), 2);
	var sc = numberFormat($("#ad02-table").data("sc"), 2);

	var adCode = mc + sc;
	
	var delConfirm = confirm('데이터를 삭제할 경우 복원이 어렵습니다. 삭제하시겠습니까?');
	if (delConfirm) {
		$.ajax({
			url : "/ad" + adCode + "Delete.do",
			type : "get",
			data : {
				"no" : no
			},
			success : function(data) {
				alert("선택하신 데이터가 삭제되었습니다.");
				getPageContent(currentPage);
			}
		});
	} else {
		alert('삭제가 취소되었습니다.');
	}

}