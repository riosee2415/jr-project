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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="author" content="중랑구 도시재생지원센터" />
	<meta name="keywords" content="중랑구 도시재생지원센터" />
	<meta name="description" content="줄랑구 도시재생, 도시재생사업 소개, 주민참여, 알림마당, 도시재생 교육, 도시재생 공모사업, 도시재생 빅데이터" />
	
	<!-- OG tag  -->
	<meta property="og:type" content="website">
	<meta property="og:title" content="중랑구 도시재생지원센터" />
	<meta property="og:site_name" content="중랑구 도시재생지원센터">
	<meta property="og:discription" content="줄랑구 도시재생, 도시재생사업 소개, 주민참여, 알림마당, 도시재생 교육, 도시재생 공모사업, 도시재생 빅데이터" />
    <title>중랑구 도시재생지원센터</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/assets/images/commons/favicon.png"
    />
    <link rel="stylesheet" href="/assets/plugins/font-awesome-4.7.0/font-awesome.min.css" />
    <link rel="stylesheet" href="/assets/css/styles.css?ver=${ver}" />
  </head>
  <body>