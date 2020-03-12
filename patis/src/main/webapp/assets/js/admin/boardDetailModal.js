var no;
var title;
var author;

function intoComments(b_no, b_title, b_author) {
  no = b_no;
  title = b_title;
  author = b_author;

  $("#mm__list").html("");

  $(".modal-01").css("display", "block");

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
          tags += "<div class='mld__author'>" + data.co_AUTHOR + "</div>";
          tags += "<div class='mld__time'>" + data.co_CREATE_TIME + "</div>";

          if (data.co_USE_YN == 1) {
            tags +=
              "<div class='mld__useYn' id='mld__useYn'><input type='button' id='co_delBtn' class='btn btn-sm btn-red' value='삭제' onClick='commentsDeleteHandler(" +
              data.co_NO +
              ")'></input></div>";
          } else {
            tags +=
              "<div class='mld__useYn' id='mld__useYn'><input type='button' id='co_delBtn' class='btn btn-sm btn-orange' value='삭제처리' onClick='alert(\"이미 삭제된 댓글입니다.\");'></input></div>";
          }

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
  $(".modal-01").css("display", "none");
  $(".modal-02").css("display", "none");
}

function commentsDeleteHandler(co_no) {
  var mc = numberFormat($("#ad02-table").data("mc"), 2);
  var sc = numberFormat($("#ad02-table").data("sc"), 2);

  var adCode = mc + sc;

  $.ajax({
    url: "/ad" + adCode + "CommentDelete.do",
    type: "get",
    data: {
      co_no: co_no
    },
    success: function(data) {
      intoComments(no, title, author);
    }
  });
}
