<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="manager_desc_area">
	<div>
		<label>게시판 이름</label>
	</div>
	<div>
		<input type="text" id="manager-board-name" value="${data.BOARD_NAME }"
			readonly />
	</div>
</div>

<div class="manager_desc_area">
	<div>
		<label>현재 관리자 접속 권한</label>
	</div>
	<div>
		<input type="text" value="${data.BOARD_CONTROLL_RIGHT }" readonly />
	</div>
</div>

<div class="manager_desc_area">
	<div>
		<label>변경할 관리자 접속 권한</label>
	</div>
	<div>
		<select id="manager-board-right">
			<option selected="selected">--선택--</option>
			<option value="1">개발자</option>
			<option value="2">관리자</option>
			<option value="3">관리자(운영)</option>
		</select>
	</div>
</div>

<div class="manager_desc_area">
	<div>
		<input type="button" value="저장"
			onclick="javascript:boardAcceptRightModify()" />
	</div>
</div>

