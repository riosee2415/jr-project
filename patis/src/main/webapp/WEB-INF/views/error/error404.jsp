<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container">
    <div class="error404_wrap">
      <h3 class="error404_mainTitle greentext">
        4<i class="fa fa-frown-o " aria-hidden="true"></i>4
      </h3>
      <h3 class="error404_com_1">
        죄송합니다.<br />현재 찾을 수 없는 페이지를 요청하셨습니다.
      </h3>
      <h3 class="error404_com_2">
        존재하지 않는 주소를 입력하셨거나,<br />
        요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.
      </h3>
      <h3 class="error404_com_3">
        궁금한 점 있으시면 언제든 중랑구청 도시재생지원센터에 문의해 주시기
        바랍니다.
      </h3>
      <a href="${pageContext.request.contextPath }/main.do">
        <button type="button" class="goBtn_500">메인으로 이동</button>
      </a>
    </div>
  </div>
</div>
