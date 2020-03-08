<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
  	<!-- 교육 연간일정표 -->
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <div class="board-search__area">
          <div class="board-search-type">
        		<div class="search-type__box" id="search-type-js">
        			<p class="search-type-text">전체</p>
        			<i class="fa fa-caret-down" aria-hidden="true"></i>
        		</div>
        		<ul class="search-type__list" id="search-type-list-js">
        			<li class="active">전체</li>
        			<li>제목</li>
        			<li>내용</li>
        		</ul>
          </div>
          <div class="board-search-keyword">
	          <input type="text" class="search-keyword" />
	          <button type="button" class="search-button"></button>
          </div>
        </div>
      </div>

      <div class="board-list__box">
        <table class="board-list__table">
          <thead>
            <tr>
              <th class="header-5">번호</th>
              <th class="header-title">제목</th>
              <th class="header-15">작성자</th>
              <th class="header-15">날짜</th>
              <th class="header-5">조회</th>
            </tr>
          </thead>

          <tbody>
          	<tr class="row-notice">
              <td>공지</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>
            
            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>
          </tbody>
        </table>
        <ul class="board-pagination">
        	<li class="page-control"><i class="fa fa-angle-double-left" aria-hidden="true"></i></li>
        	<li class="page-control"><i class="fa fa-angle-left" aria-hidden="true"></i></li>
        	<li class="page-number active">1</li>
        	<li class="page-number">2</li>
        	<li class="page-number">3</li>
        	<li class="page-control"><i class="fa fa-angle-right" aria-hidden="true"></i></li>
        	<li class="page-control"><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
        </ul>
      </div>
    </div>
    
    <!-- 교육 일정등록 및 신청 -->
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="board-search__box">
        <div class="board-search__area">
          <div class="board-search-type">
        		<div class="search-type__box" id="search-type-js">
        			<p class="search-type-text">전체</p>
        			<i class="fa fa-caret-down" aria-hidden="true"></i>
        		</div>
        		<ul class="search-type__list" id="search-type-list-js">
        			<li class="active">전체</li>
        			<li>제목</li>
        			<li>내용</li>
        		</ul>
          </div>
          <div class="board-search-keyword">
	          <input type="text" class="search-keyword" />
	          <button type="button" class="search-button"></button>
          </div>
        </div>
      </div>

      <div class="board-list__box">
        <table class="board-list__table">
          <thead>
            <tr>
              <th class="header-5">번호</th>
              <th class="header-title">제목</th>
              <th class="header-15">작성자</th>
              <th class="header-15">날짜</th>
              <th class="header-5">조회</th>
            </tr>
          </thead>

          <tbody>
          	<tr class="row-notice">
              <td>공지</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>
            
            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td class="header-title">제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>
          </tbody>
        </table>
        <ul class="board-pagination">
        	<li class="page-control"><i class="fa fa-angle-double-left" aria-hidden="true"></i></li>
        	<li class="page-control"><i class="fa fa-angle-left" aria-hidden="true"></i></li>
        	<li class="page-number active">1</li>
        	<li class="page-number">2</li>
        	<li class="page-number">3</li>
        	<li class="page-control"><i class="fa fa-angle-right" aria-hidden="true"></i></li>
        	<li class="page-control"><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
        </ul>
      </div>
    </div>
  </div>
</div>