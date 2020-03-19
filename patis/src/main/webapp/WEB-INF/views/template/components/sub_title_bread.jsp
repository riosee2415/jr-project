<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div class="subTitle sub_title-js">
  <c:forEach var="detail" items="${DetailMenuList }" varStatus="status">
    <c:if test="${param.code == detail.PARENT_CODE}">
      <c:set value="${menuCount + 1 }" var="menuCount" />
      <c:if test="${menuCount eq 1}">
        <c:out value="${detail.VAL }"></c:out>
      </c:if>
    </c:if>
  </c:forEach>
</div>
<ul class="bread">
  <li>
    <a href="${pageContext.request.contextPath }/main.do">HOME&nbsp;>&nbsp;</a>
  </li>
  <c:forEach var="menu" items="${menuList }" varStatus="status">	
    <c:if test="${param.parent == menu.DETAIL_CODE }">	
      <li><a href="${menu.URL}">${menu.VAL}&nbsp;>&nbsp;</a></li>	
    </c:if>	
  </c:forEach>
  <c:forEach var="subMenu" items="${subMenuList }" varStatus="status">
    <c:if
      test="${param.parent == subMenu.PARENT_CODE and param.code == subMenu.DETAIL_CODE}"
    >
      <li
        ><a
          href="${subMenu.URL}?parent=${subMenu.PARENT_CODE }&code=${subMenu.DETAIL_CODE}"
          >${subMenu.VAL}</a
        ></li
      >
    </c:if>
  </c:forEach>
</ul>
