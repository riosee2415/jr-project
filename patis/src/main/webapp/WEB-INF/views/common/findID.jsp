<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="findId_page">
      <h3 class="findId_title">
        <i class="fa fa-search" aria-hidden="true"></i> 아이디 찾기
      </h3>
      <div class="findId_subtitle_wrap">
        <h3 class="findId_subtitle_1">아이디를 모르시나요?</h3>
        <h3 class="findId_subtitle_2">
          아이디 찾기 방법 중 가능한 방법을 선택해주세요.
        </h3>
      </div>
      <div class="findId_com_wrap">
        <p>
          <input
            type="radio"
            id="find_Birth"
            name="searchType"
            class="how_find"
          />
          <label for="find_Birth">이름 / 생년월일 / 핸드폰 번호로 찾기</label>
        </p>
        <p>
          <input
            type="radio"
            id="find_Email"
            name="searchType"
            class="how_find"
          />
          <label for="find_Email">내 정보에 등록된 이메일로 찾기</label>
        </p>
      </div>
      <div class="need_findPw">
        ㆍ비밀번호를 찾으시나요?
        <div class="go_findPw" onclick="">
          비밀번호 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
        </div>
      </div>
    </div>
  </div>
</div>
