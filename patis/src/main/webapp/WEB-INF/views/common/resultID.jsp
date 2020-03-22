<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="resultId_page">
      <h3 class="resultId_title">
        <i class="fa fa-search" aria-hidden="true"></i> 아이디 찾기
      </h3>
      <div class="resultId_subtitle_wrap">
        <h3 class="resultId_subtitle">
          입력하신 정보와 일치하는 아이디 정보입니다. <br />
          아이디는 8자리 이상으로, 개인정보 보호를 위해 일부는 *로 표기됩니다.
        </h3>
      </div>
      <div class="resultId_com_warp">
        <ul class="search_result">
          <li>
            <span class="choice_result">
              <input
                type="radio"
                id="result_ID"
                name="resultID"
                class="search_resultID"
                value="search_result_ID"
              />
              <label for="result_ID">
                <span>나온 아이디</span>
              </label>
            </span>
          </li>
        </ul>
      </div>
      <div class="need_findPw">
        ㆍ비밀번호를 찾으시나요?
        <div class="go_findPw" onclick="">
          비밀번호 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
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
