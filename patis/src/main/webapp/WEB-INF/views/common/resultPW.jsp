<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="resultPw_page">
      <h3 class="resultPw_title">
        <i class="fa fa-search" aria-hidden="true"></i> 비밀번호 찾기
      </h3>
      <div class="resultPw_subtitle_wrap">
        <h3 class="resultPw_subtitle">
          비밀번호 변경페이지 입니다. <br />
          8자리 이상 영문, 숫자, 특수문자를 조합하세요.
        </h3>
        <h3 class="resultPw_subtitle_2">
          (단, 공백(), 콤마(,), 마침표(.), 콜론(:), 세미콜론(;), 슬러시(/)
          사용불가)
        </h3>
      </div>
      <div class="resultPw_com_warp">
        <ul class="search_result">
          <li>
            <label for="result_PW">변경할 비밀번호 입력</label>
            <input
              type="text"
              id="result_PW"
              name="resultPw"
              class="search_resultPw"
              value=""
              placeholder="비밀번호 입력"
            />
          </li>
          <li>
            <label for="check_result_PW">변경할 비밀번호 확인 </label>
            <input
              type="text"
              id="check_result_PW"
              name="resultPw"
              class="search_resultPw"
              value=""
              placeholder="비밀번호 확인"
            />
          </li>
        </ul>
      </div>
      <div class="need_findId">
        ㆍ아이디를 찾으시나요?
        <div class="go_findId" onclick="javascript:pageLink('/findId.do')">
          아이디 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
        </div>
      </div>
      <div class="result_btn_wrap">
        <button type="button" class="go_login_btn" onclick="">
          로그인 하러가기
        </button>
      </div>
    </div>
  </div>
</div>
