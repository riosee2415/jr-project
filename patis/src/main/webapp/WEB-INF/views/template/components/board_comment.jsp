<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="board-comment__box">
	<div class="comment-write__box">
			<form action="/commentWrite.do" method="post" id="frm-comment-write">
				<div class="write-input__box">
					<textarea class="write-input" id="write-input-js"></textarea>
					<button type="button" class="write-button" id="write-button-js">등록</button>		
				</div>
			</form>
	</div>
	<div class="comment-list__area">
		<div class="comment-list__box">
			<div class="list-top__box">
				<ul>
					<li class="data-user">
						<i class="fa fa-user-o" aria-hidden="true"></i>
						<span>테스터</span>
					</li>
					<li class="data-time">
						<i class="fa fa-clock-o" aria-hidden="true"></i>
						<span>2020-03-11 22:00:00</span>
					</li>
				</ul>
			</div>
			<div class="list-bottom__box">
				<div class="comment-desc">댓글 <br/>테스트 중</div>
				<div class="comment-btn">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>
		</div>
		<div class="comment-list__box">
			<div class="list-top__box">
				<ul>
					<li class="data-user">
						<i class="fa fa-user-o" aria-hidden="true"></i>
						<span>테스터</span>
					</li>
					<li class="data-time">
						<i class="fa fa-clock-o" aria-hidden="true"></i>
						<span>2020-03-11 22:00:00</span>
					</li>
				</ul>
			</div>
			<div class="list-bottom__box">
				<div class="comment-desc">댓글 <br/>테스트 중</div>
				<div class="comment-btn">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>
		</div>
		
	</div>
</div>