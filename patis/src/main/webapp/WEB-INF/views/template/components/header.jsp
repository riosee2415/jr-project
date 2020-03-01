<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="checkbox" id="menu_call" class="ck" />
    <header class="mobile header">
      <a href="" class="logo"></a>
      <label for="menu_call" class="lst">
        <div class="menuicon"></div>
        <div class="xicon"></div>
      </label>
    </header>
    <header class="desk header">
      <div class="deskbox">
        <a href="" class="logo"> </a>
        <nav id="deskmenu">
          <ul class="menu resmenu">
            
            <c:forEach var="menu" items="${menuList }">
            	<li>
	              <a class="resmenu__m" href=""><c:out value="${menu.VAL }${menu.DETAIL_CODE }"></c:out></a>
	              <ul class="sub">
	                <li class="sub1"><a href="">sub1</a></li>
	                <li><a href="">sub</a></li>
	                <li><a href="">sub</a></li>
	              </ul>
	            </li>
            </c:forEach>
          </ul>
        </nav>
      </div>
    </header>
    <nav id="collap_menu">
      <ul class="menu">
        <li><a href="">메인메뉴1</a></li>
        <li><a href="">메인메뉴2</a></li>
        <li><a href="">메인메뉴4</a></li>
        <li><a href="">메인메뉴4</a></li>
        <li><a href="">메인메뉴4</a></li>
        <li><a href="">메인메뉴3</a></li>
        <li><a href="">메인메뉴4</a></li>
      </ul>
    </nav>