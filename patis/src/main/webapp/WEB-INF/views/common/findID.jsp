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
        <ul class="search_list">
          <li>
            <span class="choice_comm">
              <input
                type="radio"
                id="find_Birth"
                name="searchType"
                class="how_find"
                value="myBirth"
              />
              <label for="find_Birth"
                >이름 / 생년월일 / 핸드폰 번호로 찾기</label
              >
            </span>
            <div class="info_form">
              <span>
                가입시 입력한 이름 / 생년월일 / 핸드폰 번호와 일치하는 아이디를
                찾습니다.
              </span>
              <button type="button" class="find_btn">다음단계</button>
            </div>
          </li>
          <li>
            <span>
              <input
                type="radio"
                id="find_Email"
                name="searchType"
                class="how_find"
                value="myEmail"
              />
              <label for="find_Email">내 정보에 등록된 이메일로 찾기</label>
            </span>
            <div class="info_from">
              <span>
                가입시 입력한 이메일로 임시 비밀번호를 보내드립니다.
              </span>
              <div>
                <label
                  for="searchName"
                  class="search_Name"
                  id="searachNameLabel"
                  >이름을 입력해주세요</label
                >
                <input
                  type="text"
                  id="searchName"
                  name="searchName"
                  class=""
                  maxlength="30"
                  value=""
                />
              </div>
              <div>
                <label
                  for="searchEmail"
                  class="search_Email"
                  id="searchEmailLabel"
                  >이메일을 입력해주세요</label
                >
                <input
                  type="text"
                  id="searchEmail"
                  name="searchEmail"
                  class=""
                  value=""
                />
              </div>
              <button type="submit" class="find_btn">다음단계</button>
            </div>
          </li>
        </ul>
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
