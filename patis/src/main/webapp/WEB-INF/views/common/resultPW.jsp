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
                      사용하실  새로운 비밀번호를 입력해주세요.<br />
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
              type="password"
              id="joinPass-1"
              name="resultPw"
              class="search_resultPw"
              value=""
              placeholder="비밀번호 입력"
              onkeyup="javascript:keyDownPassword()"
            />
            <div>
            <span class="password_validation"
                    >8자리 이상 영문, 숫자, 특수문자를 조합하세요.<br />
                    (공백( ), 콤마(,), 마침표(.), 콜론(;/:), 슬러시(/)
                    사용불가)</span
                  >
           </div>
          </li>
          <li>
            <label for="check_result_PW">변경할 비밀번호 확인 </label>
            <input
              type="password"
              id="joinPass-2"
              name="resultPw"
              class="search_resultPw"
              value=""
              placeholder="비밀번호 확인"
              onkeyup="javascript:keyDownCheck()"
            />
            <span class="" id="passCheckSpan"></span>
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
        <button type="button" class="go_login_btn" onclick="goResultPwHandler()">
          변경하기
        </button>
      </div>
    </div>
  </div>
  
  <form action="resultPass.do" method="post" id="frm-result-pw-js">
  	<input type="hidden" name="userId" value="${userId}" />
  	<input type="hidden" name="userPw" />
  </form>
</div>
