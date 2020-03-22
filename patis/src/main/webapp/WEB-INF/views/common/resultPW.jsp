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
          입력하신 이메일로 임시 비밀번호를 발송하였습니다. <br />
          발급받은 비밀번호로 로그인 후 변경해주시길 바랍니다.
        </h3>
      </div>
      <div class="resultPw_com_warp">
        <ul class="search_result">
          <li>
            <span class="choice_result">
              <input
                type="radio"
                id="result_ID"
                name="resultPw"
                class="search_resultPw"
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
