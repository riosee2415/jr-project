<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="confirmPw_page">
      <h3 class="confirmPw_title">
        <i class="fa fa-search" aria-hidden="true"></i> 비밀번호 찾기
      </h3>
      <div class="confirmPw_subtitle_wrap">
        <h3 class="confirmPw_subtitle">
          입력하신 이메일로 인증번호가 전송되었습니다.<br />
          전송된 인증번호를 입력해주세요.
        </h3>
      </div>
      <div class="confirmPw_com_warp">
        <ul class="search_result">
          <li>
            <label for="result_PW">인증번호 입력</label>
            <input
              type="text"
              id="result_PW"
              name="confirmPw"
              class="search_confirmPw"
              value=""
              placeholder="인증번호 입력"
            />
          </li>
        </ul>
      </div>
      <div class="need_findId">
        ㆍ아이디를 찾으시나요?
        <div class="go_findId" onclick="">
          아이디 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
        </div>
      </div>
      <div class="result_btn_wrap">
        <button type="button" class="go_login_btn" onclick="">확인</button>
      </div>
    </div>
  </div>
</div>
