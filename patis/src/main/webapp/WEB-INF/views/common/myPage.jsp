<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="myPageBox">
	<div class="myPageBox__basic ma">
		<div class="ma__title">기본정보</div>

		<div class="ma__infoArea">
			<div>
				<div>아이디</div>
				<div>${user.USER_ID }</div>
			</div>

			<div>
				<div>이름</div>
				<div>${user.USER_NAME }</div>
			</div>

			<div>
				<div>생년월일</div>
				<div>${user.USER_REGNO1 }</div>
			</div>

			<div>
				<div>권한</div>
				<div>${user.USER_RIGHT }</div>
			</div>

		</div>
	</div>
	<div class="myPageBox__option ma">
		<div class="ma__title">개인정보</div>

		<div class="ma__infoArea">
			<div>
				<div>이메일</div>
				<input type="text" value="${user.USER_EMAIL }" id="user-email">
			</div>

			<div>
				<div>전화번호</div>
				<input type="text" value="${user.USER_TEL }" id="user-tel">
			</div>

			<div>
				<div>핸드폰번호</div>
				<input type="text" value="${user.USER_MOBILE }" id="user-mobile">
			</div>

			<div>
				<div>주소</div>
				<div class="ma-add">
					<article class="ma-add-01">
						<input type="button" value="우편번호" onclick="javascript:openPost()"> <input type="text"
							value="${USER_ZONECODE }" id="user-zonecode" readonly>
					</article>
					<div>
						<input type="text" value="${user.USER_ADDR1 }" id="user-addr1" readonly>
					</div>
					<div>
						<input type="text" value="${user.USER_ADDR2 }" id="user-addr2">
					</div>
				</div>
			</div>
		</div>

		<div class="ma__button">
			<input type="button" value="수정">
		</div>
	</div>
</div>



<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/assets/js/myPage.js"></script>