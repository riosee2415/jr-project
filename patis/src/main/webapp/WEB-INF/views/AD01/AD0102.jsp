<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
  $(document).ready(function() {
    $.datepicker.setDefaults($.datepicker.regional["ko"]);
    $("#startDate").datepicker({
      changeMonth: true,
      changeYear: true,
      nextText: "다음 달",
      prevText: "이전 달",
      dayNames: [
        "일요일",
        "월요일",
        "화요일",
        "수요일",
        "목요일",
        "금요일",
        "토요일"
      ],
      dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
      monthNamesShort: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월"
      ],
      monthNames: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월"
      ],
      dateFormat: "yy/mm/dd",
      maxDate: 0, // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
      onClose: function(selectedDate) {
        //시작일(startDate) datepicker가 닫힐때
        //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
        $("#endDate").datepicker("option", "minDate", selectedDate);
      }
    });
    $("#endDate").datepicker({
      changeMonth: true,
      changeYear: true,
      nextText: "다음 달",
      prevText: "이전 달",
      dayNames: [
        "일요일",
        "월요일",
        "화요일",
        "수요일",
        "목요일",
        "금요일",
        "토요일"
      ],
      dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
      monthNamesShort: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월"
      ],
      monthNames: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월"
      ],
      dateFormat: "yy/mm/dd",
      maxDate: 0, // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
      onClose: function(selectedDate) {
        // 종료일(endDate) datepicker가 닫힐때
        // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
        $("#startDate").datepicker("option", "maxDate", selectedDate);
      }
    });
  });
</script>

<!-- CONTENT HEADER -->
<div class="ad0101-header">
  <p>회원관리 > 접속통계 관리(AD0102)</p>
</div>

<div class="stis__area">
  <div class="stis_one">
    <div class="stis_one__title">
      <div id="sits-title-js">접속자 통계</div>
    </div>

    <div class="stis_one__desc">
      <div class="stis_one__desc__left">
        <p>통계</p>
      </div>
      <div class="stis_one__desc__right">
        <div class="stis_one__desc__right__data" id="sits-data-js">0</div>
        <div class="stis_one__desc__right__detail">
          <input
            type="submit"
            class="btn btn-sm btn-gray"
            value="자세히보기"
            onclick="javascript:openDetailModal(1)"
          />
        </div>
      </div>
    </div>
     <div class="stis_one__refer">
     	<ul>
     		<li>오늘 날짜기준 접속자 통계 데이터 입니다.</li>
     		<li>자세히보기 버튼을 누르면 접속자 상세 데이터를 확인할 수 있습니다.</li>
     	</ul>
     </div>
  </div>

  <div class="stis_one">
    <div class="stis_one__title">
      <p>접속자 통계 검색</p>
    </div>

    <div class="stis_one__desc">
      <div class="stis_one__desc__left">
        <p>검색기간</p>
      </div>
      <div class="stis_one__desc__right">
        <!-- date -->
        <div class="desc__right__dateArea">
          <label>시작일</label>
          <input type="text" id="startDate" readonly/>
          <i class="fa fa-calendar" aria-hidden="true"></i>
        </div>

        <div class="desc__right__dateArea">
          <span> ~ </span>
        </div>

        <div class="desc__right__dateArea">
          <label>종료일</label>
          <input type="text" id="endDate" readonly/>
          <i class="fa fa-calendar" aria-hidden="true"></i>
        </div>

        <div class="desc__right__dateArea">
          <input
            type="submit"
            class="btn btn-sm btn-gray"
            value="조회하기"
            onclick="javascript:getSearchData()"
          />
        </div>
      </div>
    </div>

    <div class="stis_one__desc">
      <div class="stis_one__desc__left">
        <p>통계</p>
      </div>
      <div class="stis_one__desc__right">
        <div class="stis_one__desc__right__data" id="sits-search-data-js">
          0
        </div>
        <div class="stis_one__desc__right__detail">
          <input
            type="submit"
            class="btn btn-sm btn-gray"
            value="자세히보기"
            onclick="javascript:openDetailModal(2)"
          />
        </div>
      </div>
    </div>
    <div class="stis_one__refer">
     	<ul>
     		<li>시작일과 종료일을 선택하여 통계 데이터를 조회합니다.</li>
     		<li>조회 후 자세히보기 버튼을 사용할 수 있습니다.</li>
     		<li>종료일보다 더 큰 시작일은 선택할 수 없습니다.</li>
     	</ul>
     </div>
  </div>
</div>

<div class="modal-02">
  <div class="modal_box">
    <header class="modal-header">
      <div>접속자 상세정보</div>
      <a href="javascript:closeModal()" class="modal-X">
        <i class="fa fa-times-circle" aria-hidden="true"></i>
      </a>
    </header>

    <div class="modal_box__main mm" id="modal_box__main">
      <ul class="mm__list" id="connect__list"></ul>
    </div>
  </div>
</div>

<script src="/assets/js/admin/AD0102.js"></script>
