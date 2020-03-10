function intoComments(b_no, b_title, b_author) {
  $("#mm__list").html("");

  $(".modal").css("display", "block");

  $.ajax({
    url: "/ad0215Comments.do",
    type: "get",
    data: {
      p_no: b_no
    },
    success: function(dataList) {
      if (dataList.length == 0) {
        $("#mm__list").html(
          "<div class='mm__list__none'>조회 할 댓글이 없습니다.</div>"
        );
      } else {
        var tags = "";

        dataList.forEach(function(data) {
          tags += "<li class='mm__list__data mld'>";
          tags += "<div class='mld__no'>" + data.co_NO + "</div>";
          tags += "<div class='mld__type'>" + data.co_BOARD_TYPE + "</div>";
          tags += "<div class='mld__parent'>" + data.co_PARENT_NO + "</div>";
          tags += "<div class='mld__desc'>" + data.co_DESCRIPTION + "</div>";
          tags += "<div class='mld__useYn'>" + data.co_USE_YN + "</div>";
          tags += "<div class='mld__time'>" + data.co_CREATE_TIME + "</div>";

          tags += "</li>";
        });

        $("#mm__list").html(tags);
      }
    }
  });

  $("#mh__no").html(b_no);
  $("#mh__title").html(b_title);
  $("#mh__author").html(b_author);
}
function closeModal() {
  $(".modal").css("display", "none");
}
