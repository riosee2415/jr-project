<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="join-page">
      <div class="join-box">
        <h3 class="join-title">정보입력</h3>
        <div class="join-title__content">
          도시재생 포털사이트의 다양한 서비스를 이용 하실 수 있습니다.
        </div>
        <div class="join-box__info">
          <div class="join-info__text">
            <span class="red">*&nbsp;</span>는 필수 항목입니다.
          </div>
          <div class="join-box__infobox">
            <ul class="join-left">
              <li><span class="red">*&nbsp;</span>아이디</li>
              <li><span class="red">*&nbsp;</span>이름</li>
              <li><span class="red">*&nbsp;</span>비밀번호</li>
              <li><span class="red">*&nbsp;</span>비밀번호 확인</li>
              <li>주소 <span class="red">*</span></li>
              <li><span class="red">*&nbsp;</span>이메일</li>
              <li><span class="red">*&nbsp;</span>휴대폰 번호</li>
              <li>&nbsp;&nbsp;전화번호</li>
            </ul>
            <ul class="join-right">
              <li>
                <div>
                  <input type="text" /><button class="overlap" type="button">
                    중복확인
                  </button>
                </div>
                <span>8 에서 14 사이의 값을 입력하세요.</span>
              </li>
              <li><input type="text" /></li>
              <li>
                <input type="text" />
                <span>비밀번호 길이는 8 에서 14 사이의 값을 입력하세요. </span>
              </li>
              <li><input type="text" /></li>
              <li>
                <div class="post-up">
                  <button type="button" class="postNum">우편번호찾기</button>
                  <input class="post-box-01" type="text" />
                </div>
                <div class="post-down">
                  <input class="post-box-02" type="text" />
                  <input class="post-box-02" type="text" />
                </div>
              </li>
              <li>
                <input type="text" />@<input class="emailBox" type="text" />
                <select
                  onclick="javascript:emailSelection()"
                  class="email"
                  name="emailSelection"
                >
                  <option selected="selected" value="1">직접입력</option>
                  <option value="naver.com">naver.com</option>
                  <option value="google.com">google.com</option>
                  <option value="daum.net">daum.net</option>
                </select>
              </li>
              <li>
                <input type="text" />-<input type="text" />-<input
                  type="text"
                />
              </li>
              <li>
                <input type="text" />-<input type="text" />-<input
                  type="text"
                />
              </li>
            </ul>
          </div>
          <div class="join-button">
            <button type="button" class="join-btn-01">가입</button>
            <button type="button" class="join-btn-02">취소</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
