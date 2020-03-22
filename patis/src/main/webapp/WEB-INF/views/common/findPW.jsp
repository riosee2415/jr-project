<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="findPw_page">
      <h3 class="findPw_title">
        <i class="fa fa-search" aria-hidden="true"></i> 비밀번호 찾기
      </h3>
      <div class="findPw_subtitle_wrap">
        <h3 class="findPw_subtitle_1">비밀번호를 모르시나요?</h3>
        <h3 class="findPw_subtitle_2">
          비밀번호 찾기 방법 중 가능한 방법을 선택해주세요.
        </h3>
      </div>
      <div class="findPw_com_wrap">
        <ul class="search_list">
          <!-- 이름/생년월일/핸드폰 번호로 찾기 -->
          <li>
            <span class="choice_comm">
              <input
                type="radio"
                onchange="findHandler(this.value)"
                id="find_Id"
                name="searchType"
                class="how_find"
                value="myBirth"
              />
              <label for="find_Id">아이디 / 이름 / 생년월일로 찾기</label>
            </span>
            <div class="info_form" id="info-birth-js">
              <span class="info_form_des">
                가입시 입력한 아이디 / 생년월일 / 이메일과 일치하는 비밀번호를
                찾습니다.
                <br />개인정보보호를 위해 비밀번호는 일부분만 보여드리며, *가
                무작위로 표기됩니다.
              </span>
              <div class="search_form search_PW">
                <!-- <label for="searchId_Id">아이디를 입력해주세요</label> -->
                <input
                  type="text"
                  id="searchId_Id"
                  name="searchID"
                  class="search_ID"
                  maxlength="30"
                  value=""
                  placeholder="아이디를 입력해주세요."
                />
                <br />

                <label for="searchId_Birth">생년월일을 입력해주세요.</label>
                <input
                  type="text"
                  id="startDate"
                  name="searchId_Birth"
                  class="search_ID_Birth"
                  maxlength="6"
                  value=""
                  placeholder="200322"
                />
                <br />
                <!-- <label for="searchBirth_name">이메일을 입력해주세요</label> -->
                <input
                  type="email"
                  id="searchEmail"
                  name="searchEmail"
                  class="search_Email"
                  value=""
                  placeholder="이메일을 입력해주세요."
                />
                <br />
              </div>
              <button type="button" class="find_btn">다음단계</button>
            </div>
          </li>
          <!-- 이름/이메일로 찾기 -->
          <!-- <li>
            <span>
              <input
                type="radio"
                onchange="findHandler(this.value)"
                id="find_Email"
                name="searchType"
                class="how_find"
                value="myEmail"
              />
              <label for="find_Email">내 정보에 등록된 이메일로 찾기</label>
            </span>
            <div class="info_form" id="info-email-js">
              <span class="info_form_des">
                가입시 입력한 이메일로 임시비밀번호를 보내드립니다.
              </span>
              <div class="search_form_2 search_PW_2">
                <label
                  for="searchName"
                  class="search_Name"
                  id="searachNameLabel"
                  >아이디를 입력해주세요</label
                >
                <input
                  type="text"
                  id="searchName"
                  name="searchName"
                  class="search_Name_2"
                  maxlength="30"
                  value=""
                  placeholder="아이디를 입력해주세요."
                />
                <br />
                <label
                  for="searchEmail"
                  class="search_Email"
                  id="searchEmailLabel"
                  >이메일을 입력해주세요</label
                >
                <input
                  type="email"
                  id="searchEmail"
                  name="searchEmail"
                  class="search_Email"
                  value=""
                  placeholder="이메일을 입력해주세요."
                />
              </div>
              <button type="submit" class="find_btn">다음단계</button>
            </div>
          </li> -->
        </ul>
      </div>
      <div class="need_findId">
        ㆍ아이디를 찾으시나요?
        <div class="go_findId" onclick="">
          아이디 찾기 <i class="fa fa-caret-right" aria-hidden="true"></i>
        </div>
      </div>
    </div>
  </div>
</div>
