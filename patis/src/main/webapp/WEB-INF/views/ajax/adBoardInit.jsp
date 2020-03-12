<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="board" items="${boardList }">
  <tr>
    <td
      ><input type="checkbox" class="ab" name="ab" value="${board.b_NO }"
    /></td>
    <td>${board.b_NO }</td>
    <td class="modal-pop" onclick="javascript:intoComments(`${board.b_NO}`, `${board.b_TITLE }`, `${board.b_AUTHOR }`)">${board.b_TITLE }</td>
    <td>${board.b_AUTHOR }</td>
    <td>${board.b_CREATE_TIME }</td>
    <td>${board.b_UPLOAD_TIME }</td>
    <td>${board.b_HIT }</td>
    <td>
      <c:if test="${board.b_NOTICE eq 0}"
        ><input
          class="btn btn-xs btn-blue"
          type="button"
          id="notice-btn"
          value="설정"
          onClick="javascript:noticeBtnHandler(${board.b_NOTICE}, ${board.b_NO}, this)"
      /></c:if>
      <c:if test="${board.b_NOTICE eq 1}"
        ><input
          class="btn btn-xs btn-orange"
          type="button"
          id="notice-btn"
          value="해제"
          onClick="javascript:noticeBtnHandler(${board.b_NOTICE}, ${board.b_NO}, this)"
      /></c:if>
    </td>
    <td>
      <c:if test="${board.b_DELETE_TIME eq null}">
        <input
          type="button"
          class="btn btn-xs btn-red"
          id="notice-btn"
          value="삭제"
          onClick="javascript:deleteBtnHandler(${board.b_NO}, this)"
        />
      </c:if>
    </td>
    <td>${board.b_DELETE_TIME }</td>
  </tr>
</c:forEach>


<script src="/assets/js/admin/AD_board_ajax.js"></script>
<script src="/assets/js/admin/boardDetailModal.js"></script>
