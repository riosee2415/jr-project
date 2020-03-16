<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div class="board-comment__box">
  <div class="comment-write__box">
    <form action="/commentWrite.do" method="post" id="frm-comment-write">
      <div class="write-input__box">
        <textarea class="write-input" id="write-input-js"></textarea>
        <button
          type="button"
          class="write-button"
          id="write-button-js"
          onclick="javascript:boardCommentWrite('${sessionScope.loginNo}')"
        >
          등록
        </button>
      </div>
    </form>
  </div>
  <div class="comment-list__wrap" id="comment-list-js"></div>
</div>
