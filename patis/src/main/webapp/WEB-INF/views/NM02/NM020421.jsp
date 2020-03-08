<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="subpage">
  <div class="sub-container" id="sub-container-js">
    <!-- 도시재생 뉴딜사업 유형 -->
    <div style="display:block;" class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
      <div class="nm22-tbl-style-01">
        <ul>
          <li class="greentext">사업유형</li>
          <li class="greentext">내용</li>
        </ul>

        <ul>
          <li>우리동네살리기(1)<br />(소규모 주거)</li>
          <li>
            생활권 내에 도로 등 기초 기반시설은 갖추고 있으나 인구유출, 주거지
            노후화로 활력을 상실한 지역에 대해
            <p>
              소규모 주택 정비사업 및 생활편의시설 공급 등으로 마을공동체 회복
            </p>
          </li>
        </ul>

        <ul>
          <li>주거지지원형(2)<br />(주거)</li>
          <li>
            원활한 주택개량을 위해 골목길 정비 등 소규모 주택정비의 기반을
            마련하고, 소규모주택 정비사업 및
            <p>생활편의시설 공급 등으로 주거지 전반의 여건 개선</p>
          </li>
        </ul>

        <ul>
          <li>일반근린형<br />(준주거)</li>
          <li>
            주거지와 골목상권이 혼재된 지역을 대상으로 주민공동체 활성화와
            골목상권 활력 증진을 목표로
            <p>
              주민 공동체 거점 조성, 마을가게 운영, 보행환경 개선 등을 지원하는
              사업
            </p>
          </li>
        </ul>

        <ul>
          <li>중심시가지형<br />(상업)</li>
          <li>
            원도심의 공공서비스 저하와 상권의 쇠퇴가 심각한 지역을 대상으로
            공공기능 회복과 역사·문화·관광과의 연계를 통한
            <p>상권의 활력 증진 등을 지원하는 사업</p>
          </li>
        </ul>

        <ul>
          <li>경제기반형<br />(산업)</li>
          <li>
            국가·도시 차원의 경제적 쇠퇴가 심각한 지역을 대상으로 복합앵커시설
            구축 등
            <p>新경제거점을 형성하고 일자리를 창출하는 사업</p>
          </li>
        </ul>
      </div>

      <table class="nm22-tbl-style-02">
        <caption>
          도시재생 뉴딜사업 유형
        </caption>
        <thead>
          <tr>
            <th rowspan="2">구분</th>
            <th colspan="2">주거재생형</th>
            <th rowspan="2">일반근린형</th>
            <th rowspan="2">중심시가지형</th>
            <th rowspan="2">경제기반형</th>
          </tr>
          <tr>
            <th>우리동네 살리기</th>
            <th>주거지지원형</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>법정 유형</td>
            <td>-</td>
            <td colspan="3">근린재생형</td>
            <td>경제기반형</td>
          </tr>
          <tr>
            <td>기존 사업유형</td>
            <td>(신규)</td>
            <td colspan="2">일반근린형</td>
            <td>중심시가지형</td>
            <td>경제기반형</td>
          </tr>
          <tr>
            <td>사업추진·지원근거</td>
            <td>(국가균형발전 특별법)</td>
            <td colspan="4">도시재생 활성화 및 지원에 관한 특별법</td>
          </tr>
          <tr>
            <td>활성화 계획 수립</td>
            <td>필요시 수립</td>
            <td colspan="4">수립 필요</td>
          </tr>
          <tr>
            <td>사업규모<br />(권장면적)</td>
            <td>소규모 주거<br />(5만㎡ 이하)</td>
            <td>주거<br />(5만~10만㎡ 내외)</td>
            <td>준주거, 골목상권<br />(10만~15만㎡ 내외)</td>
            <td>상업, 지역상권<br />(20만㎡ 내외)</td>
            <td>산업, 지역경제<br />(50만㎡ 내외)</td>
          </tr>
          <tr>
            <td>대상지역</td>
            <td>소규모 저층<br />주거밀집지역</td>
            <td>저층<br />주거밀집지역</td>
            <td>골목상권과 주거지</td>
            <td>상업, 창업, 역사,<br />관광, 문화예술 등</td>
            <td>역세권, 산단, 항만 등</td>
          </tr>
          <tr>
            <td>국비지원 한도<br />/ 집행기간</td>
            <td>50억 원 / 3년</td>
            <td>100억 원 / 3년</td>
            <td>100억 원 / 4년</td>
            <td>150억 원 / 5년</td>
            <td>250억 원 / 6년</td>
          </tr>
          <tr>
            <td>기반시설 도입</td>
            <td>주차장, 공동이용시설<br />등 생활편의시설</td>
            <td>골목길정비, 주차장,<br />공동이용시설 등<br />생활편의시설</td>
            <td>소규모 공공·복지·<br />편의시설</td>
            <td>중규모 공공·복지·<br />편의시설</td>
            <td>중규모 이상<br />공공·복지·<br />편의시설</td>
          </tr>
        </tbody>
      </table>
      <div class="nm22-table-caption">
        ※ ‘우리동네살리기’는 향후 「도시재생활성화 및 지원에 관한 특별법」에
        포함, 법정화 할 계획임
      </div>
    </div>

    <!-- 서울형 도시재생사업 유형 -->
    <div style="display:block;" class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
      <table class="nm22-tbl-style-03">
        <caption>
          서울형 도시재생사업 유형
        </caption>
        <thead>
          <tr>
            <th>서울형 도시재생 유형</th>
            <th>일자리거점 육성형</th>
            <th>생활중심지 특화형</th>
            <th>주거지 재생형</th>
            <th>거점확산형(비법정유형)</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>재생방향</td>
            <td>
              정부·민간부문과 협력적<br />추진일자리와<br />미래 성장동력 창출
            </td>
            <td>
              쇠퇴산(상)업 지역,<br />역사자원 지역을<br />지역혁신거점으로 특화
            </td>
            <td>주거환경정비 및<br />지역공동체 회복</td>
            <td>혁신거점공간 조성을<br />통한 주변지역 활성화</td>
          </tr>
          <tr>
            <td>재생대상</td>
            <td>대규모(저이용) 가용지를<br />보유한 지역</td>
            <td>
              기존의 산업 또는 상업의<br />재활성화가 필요한 지역<br />지역역사·문화·자연자산의<br />활용가치가
              높은 지역
            </td>
            <td>노후(쇠퇴)하고 공동체 회복이<br />필요한 저층주거지 대상</td>
            <td>
              유휴 국공유지 등<br />주변으로 파급효과가<br />큰 필지 및 구역단위
            </td>
          </tr>
          <tr>
            <td>규모</td>
            <td>50만㎡ 내외</td>
            <td>20만㎡ 내외</td>
            <td>20만㎡ 미만</td>
            <td>필지, 소규모 구역단위</td>
          </tr>
          <tr>
            <td>법적유형</td>
            <td>경제기반형</td>
            <td>근린재생 중심시가지형</td>
            <td>근린재생 일반근린형</td>
            <td>-</td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 서울형도시재생현황 -->
    <div style="display:block;" class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
      <table class="nm22-tbl-style-04">
        <caption>
          서울형 도시재생 현황
        </caption>
        <thead class="greentext">
          <tr>
            <th>서울형유형</th>
            <th colspan="2">사업명</th>
            <th>관련법</th>
            <th>사업명</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="bold">일자리거점 육성형</td>
            <td colspan="2">경제기반형</td>
            <td rowspan="4">도시재생 황성화 및<br />지원에 관한 특별법</td>
            <td>
              경제적 쇠퇴가 심각한 지역을 대상으로 복합앵커시설을 구축하는 등<br />신(新)경제거점을
              형성하고 일자리를 창출하는 사업
            </td>
          </tr>
          <tr>
            <td class="bold">생활중심지 특화형</td>
            <td rowspan="3">근린<br />재생형</td>
            <td>중심시가지형</td>
            <td>
              원도심의 공공서비스 저하와 상권의 쇠퇴가 심각한 지역을 대상으로<br />공공기능
              회복과 역사·문화·관광과의 연계를 통한 상권의 활력 증진<br />등을
              지원하는 사업
            </td>
          </tr>
          <tr>
            <td class="bold" rowspan="6">주거지 재생형</td>
            <td>일반근린형</td>
            <td>
              주거지와 골목상권이 혼재된 지역을 대상으로 주민공동체 활성화와<br />골목상권
              활력 증진을 목표로 주민 공동체 거점 조성, 마을가게 운영,<br />보행환경
              개선 등을 지원하는 사업
            </td>
          </tr>
          <tr>
            <td>주거지지원형</td>
            <td>
              원활한 주택개량을 위해 골목길 정비 등 소규모 주택정비의 기반을<br />마련하고
              소규모주택 정비사업 및 생활편의시설 공급 등으로 주거지<br />전반의
              여건을 개선 등을 지원하는 사업
            </td>
          </tr>
          <tr>
            <td colspan="2">주거환경 개선사업</td>
            <td>도시 및 주거환경 정비법</td>
            <td>
              재개발 사업으로 개발이 어려운 지역에 공공시설, 주택개량을<br />수행하여
              주거환경을 더 좋게 만드는 사업
            </td>
          </tr>
          <tr>
            <td colspan="2">도시활력증진사업</td>
            <td rowspan="3">국가균형발전 특별법</td>
            <td>
              국토교통부에서 정부의 지역발전정책에 따라 지자체 스스로의
              발전을<br />유도하기 위하여 도시활력 증진지역에 해당하는 지자체에
              예산을<br />포괄적으로 지원하여 시행하는 사업
            </td>
          </tr>
          <tr>
            <td colspan="2">새뜰마을사업</td>
            <td>
              취약지역 주민의 기본적인 생활수준보장을 위해 안전·위생 등
              긴요한<br />생활인프라 확충 및 주거환경 개선, 주민역량 강화 등을
              지원하는 사업
            </td>
          </tr>
          <tr>
            <td colspan="2">우리동네살리기</td>
            <td>
              생활권 내에 도로 등 기초 기반시설은 갖추고 있으나 인구유출,<br />주거지
              노후화로 활력을 상실한 지역에 대해 소규모 주택 정비사업 및<br />생활편의시설
              공급 등으로 마을공동체 회복
            </td>
          </tr>
          <tr>
            <td class="bold" rowspan="2">거점확산형</td>
            <td colspan="2">서울형 재생사업</td>
            <td>개별법에 따라 추진</td>
            <td rowspan="2">
              민간 활력을 통해 행정 사각지대에 방치된 유휴공간을
              활성화함으로써<br />지역사회 전략적 재생 거점으로 활용하여, 새로운
              재생동력을 확보
            </td>
          </tr>
          <tr>
            <td colspan="2">골목길재생사업</td>
            <td>서울시 골목길 지원조례</td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 사업신청 절차 -->
    <div style="display:block;" class="sub-content-wrap">
      <div class="subHead">
        <%@ include
        file="/WEB-INF/views/template/components/sub_title_bread.jsp" %>
      </div>
      <div class="nm22-content-04__imgbox">
        <img
          src="/assets/images/image/sub-nm0421-04-01.png"
          alt="사업신청 절차"
        />
      </div>
    </div>
  </div>
</div>
