<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <div class="sub-content-wrap">
      <div class="subHead">
        <%@ include file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>

      <div class="nm66-seachBox">
        <div class="nm66-seachBox__area">
          <select>
            <option value="제목" selected>제목</option>
            <option value="내용">내용</option>
          </select>

          <input type="text" />
          <button class="search"></button>
        </div>
      </div>

      <div class="nm66-contentBox">
        <table class="nm66-contentBox__table">
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>날짜</th>
              <th>조회</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>71</td>
              <td>제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td>제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td>제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>

            <tr>
              <td>71</td>
              <td>제목 테스</td>
              <td>관리</td>
              <td>2020-01-01</td>
              <td>412</td>
            </tr>
          </tbody>
        </table>
        <div class="table-number">
          <button class="before">«</button>
          <button class="number">1</button>
          <button class="after">»</button>
        </div>
      </div>
    </div>
  </div>
</div>
