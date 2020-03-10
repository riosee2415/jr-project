$(document).ready(function() {
  getPageContent(1);
});
function enterCheck() {
  if (event.keyCode == 13) {
    $("#search-btn-js").trigger("click");
  }
}

function getPageContent(page) {
	
	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);
	
	var adCode = mc + sc;
	
  $.ajax({
    url: "/ad" + adCode + "Init.do",
    type: "get",
    data: {
      page: page
    },
    success: function(data) {
      $("#ajax-tbody").html(data);
    }
  });
}

function serachData() {
	
	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);
	
	var adCode = mc + sc;
	
  var serachVal = $("#searchValue-js").val();
  var searchType = $("#serach-type-text").text();

  if (serachVal == "") {
    getPageContent(1);
  } else {
    $.ajax({
      url: "/ad" + adCode + "Search.do",
      type: "get",
      data: {
        serachVal: serachVal,
        searchType: searchType
      },
      success: function(data) {
        $("#ajax-tbody").html(data);
      }
    });
  }
}

function allDelete() {
	
	var mc = numberFormat($('#ad02-table').data('mc'), 2);
	var sc = numberFormat($('#ad02-table').data('sc'), 2);
	
	var adCode = mc + sc;
	
  var delConfirm = confirm(
    "데이터를 삭제할 경우 복원이 어렵습니다. 삭제하시겠습니까?"
  );
  if (delConfirm) {
    var checkArr = [];
    $("input[name='ab']:checked").each(function(i) {
      checkArr.push($(this).val());
    });

    $.ajax({
      url: "/adDeleteAll.do",
      type: "get",
      data: {
        noArr: checkArr
      },
      success: function(data) {
        if (data === 1) {
          alert("일괄삭제 처리가 완료되었습니다.");
        } else {
          alert("일괄삭제 처리에 실패했습니다.");
        }
        window.location.reload();
      }
    });
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
    $(this)
      .parent()
      .hide();
  });
});
