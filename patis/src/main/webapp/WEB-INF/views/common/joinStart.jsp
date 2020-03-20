<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="login_page">
      <div class="login_container">
        <h2 class="login_tit">
          <span>중랑구청 도시재생지원포털</span>에 오신것을 환영합니다.
        </h2>
        <p class="normal_txt">
          중랑구청 도시재생지원포털의 정보는 14세 미만, 14세 이상 모두 사용할 수
          있습니다.
        </p>
        <!-- <p class="normal_txt">
          회원의 경우 로그인만으로 정보를 이용할 수 있으며, 비회원의 경우
          공공아이핀, 휴대폰 인증을 통해 정보를 이용 하실 수 있습니다.
        </p> -->

        <div class="login_content">
          <!-- 14세 미만 회원가입 -->
          <div class="none_mem_login">
            <ul class="ico_login_off">
              <li>
                <img
                  src="/assets/images/icons/ico_lonin_off.png"
                  alt="14세 미만 회원가입 이미지"
                />
              </li>
              <li class="center_tit">
                14세 미만 회원가입
              </li>
            </ul>

            <ul>
              <li class="login_des">
                한 번의 로그인 만으로 모든 서비스를<br />
                편리하게 이용하실 수 있습니다.
              </li>
            </ul>
            <!-- <ul>
              <li class="login_des">
                <span>아이핀&lpar;I-Pin&rpar;인증, 휴대폰 인증</span>
                중 하나를 선택하여<br />
                비회원으로 로그인 하실 수 있습니다.
              </li>
            </ul> -->
            <ul class="none_btn_com">
              <li class="btn_com">
                <a href="" class="none_mem_login_btn1">14세 미만 회원가입</a>
              </li>
            </ul>
            <ul class="gray_section">
              <li>
                <a href="">아이디 찾기</a>
              </li>
              <li>
                <a href="">비밀번호 찾기</a>
              </li>
              <li>
                <a href="">로그인</a>
              </li>
            </ul>
            <!-- <ul class="gray_section">
              <li>
                <p>
                  아이핀&lpar;I-Pin&rpar;, 휴대폰 인증은 인터넷상의
                  본인확인서비스이며,<br />대면확인이 어려운 인터넷에서 본인임을
                  확인할 수 있는 수단입니다.
                </p>
              </li>
            </ul> -->
          </div>

          <!-- 14세 이상 회원가입-->
          <div class="mem_login">
            <ul class="ico_login_on">
              <li>
                <img
                  src="/assets/images/icons/ico_lonin_on.png"
                  alt="회원 회원가입 이미지"
                />
              </li>
              <li class="center_tit">
                14세 이상 회원가입
              </li>
            </ul>
            <ul>
              <li class="login_des">
                한 번의 로그인 만으로 모든 서비스를<br />
                편리하게 이용하실 수 있습니다.
              </li>
            </ul>
            <ul class="mem_btn_com">
              <li class="btn_com">
                <a
                  href=""
                  onclick="javascript:openPhonePop()"
                  class="mem_login_btn1"
                >
                  14세 이상 회원가입
                </a>
              </li>
            </ul>
            <ul class="gray_section">
              <li>
                <a href="">아이디 찾기</a>
              </li>
              <li>
                <a href="">비밀번호 찾기</a>
              </li>
              <li>
                <a href="">로그인</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<form
  id="step2Frm"
  action="${pageContext.request.contextPath }/join-step-2.do"
  method="POST"
></form>

<script src="/assets/js/phoneAuth.js"></script>
