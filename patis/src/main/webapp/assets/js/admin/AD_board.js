$(document).ready(function() {
	getPageContent(1);
	
	getRight("COLLUSION")
});


function getRight(type){
	
	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);
	
	var adCode = mc + sc;
	
	
	$.ajax({
		url : "/ad" + adCode + "GetRight.do",
		type : "get",
		data : {
			"type" : type
		},
		success : function(data) {
			$("#rightArea__content__right").html(data);
		}
	});
}


function enterCheck() {
	
	var flag = validationInputLength($("#searchValue-js").val());
	
	if(flag){
		$("#searchValue-js").val("");
		$("#searchValue-js").focus();
		return;
	}
	
	if (event.keyCode == 13) {
		$("#search-btn-js").trigger("click");
	}
}

var search_type = '';
var search_keyword = '';
var currentPage = '';

function getPageContent(page) {
	
	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);
	currentPage = page;
	
	var adCode = mc + sc;


	$.ajax({
		url : "/ad" + adCode + "Init.do",
		type : "get",
		data : {
			"page" : page,
			"search_type" :search_type,
			"search_keyword" : search_keyword
		},
		success : function(data) {
			$("#ajax-tbody").html(data);
		}
	});
	
	$.ajax({
		url : "/ad" + adCode + "Pagination.do",
		type : "get",
		data : {
			"search_type" :search_type,
			"search_keyword" : search_keyword
		},
		success : function(data) {
			$("#ad0101-paging").html(data);
		}
	});
}


function serachData() {

	search_keyword = $("#searchValue-js").val();
	search_type = $("#serach-type-text").text();

	getPageContent(1);
}

function allDelete() {

	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);

	var adCode = mc + sc;

	var delConfirm = confirm("데이터를 삭제할 경우 복원이 어렵습니다. 삭제하시겠습니까?");
	if (delConfirm) {
		var checkArr = [];
		$("input[name='ab']:checked").each(function(i) {
			checkArr.push($(this).val());
		});
		
		if(checkArr.length == 0) {
			alert("삭제할 데이터를 선택해주세요.")
			 return;
		} else {
			$.ajax({
				url : "/ad"+adCode+"DeleteAll.do",
				type : "get",
				data : {
					noArr : checkArr
				},
				success : function(data) {
					if (data === 1) {
						alert("일괄삭제 처리가 완료되었습니다.");
					} else {
						alert("일괄삭제 처리에 실패했습니다.");
					}
					getPageContent(1);
				}
			});
		}
	} else {
		alert("삭제가 취소되었습니다.");
	}
}

$(document).ready(function() {
	$("#search-type-js").on("click", function() {
		$(this).toggleClass("active");

		if ($(this).hasClass("active")) {
			$("#search-type-list-js").show();
		} else {
			$("#search-type-list-js").hide();
		}
	});

	$("#search-type-list-js li").on("click", function() {
		var selectedType = $(this).text();
		$("#search-type-js").removeClass("active");
		$("#search-type-js .search-type-text").text(selectedType);
		$("#search-type-list-js li").removeClass("active");
		$(this).addClass("active");
		$(this).parent().hide();
	});
});
