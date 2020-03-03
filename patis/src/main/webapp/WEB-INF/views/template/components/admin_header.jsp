<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyyMMddHHmmddss" var="ver" />

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>관리자페이지</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/assets/images/commons/favicon.png"
    />
    <link rel="stylesheet" href="/assets/css/styles.css?ver=${ver}" />
  </head>
  <body>
  
  <h1>ADMIN HEADER</h1>