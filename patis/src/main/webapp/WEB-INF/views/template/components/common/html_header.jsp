<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyyMMddHHmmddss" var="ver" />

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0,  user-scalable=yes, minimum-scale=1.0, maximum-scale=3.0"
    />
    <meta
      name="naver-site-verification"
      content="6410fa0dc4eed7c08c14e3d0dc8e548445d160e1"
    />
    <meta name="title" content="중랑구 도시재생지원포털" />
    <meta name="author" content="중랑구 도시재생지원포털" />
    <meta name="keywords" content="중랑구 도시재생지원포털" />
    <meta
      name="description"
      content="중랑구 도시재생, 도시재생사업 소개, 주민참여, 알림마당, 도시재생 교육, 도시재생 공모사업, 도시재생 빅데이터"
    />

    <!-- OG tag  -->
    <meta property="og:type" content="website" />
    <meta property="og:title" content="중랑구 도시재생지원포털" />
    <meta property="og:site_name" content="중랑구 도시재생지원포털 홈페이지" />
    <meta
      property="og:discription"
      content="중랑구 도시재생, 도시재생사업 소개, 주민참여, 알림마당, 도시재생 교육, 도시재생 공모사업, 도시재생 빅데이터"
    />
    <meta property="og:url" content="http://'.$SERVER['SERVERNAME']" />
    <meta
      property="og:image"
      content="http://'.$SERVER['SERVERNAME']/assets/images/commons/favicon.png"
    />
    <meta name="twitter:card" content="summary" />
    <title>중랑구 도시재생지원포털</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/assets/images/commons/favicon.png"
    />
    <link
      rel="stylesheet"
      href="/assets/plugins/font-awesome-4.7.0/font-awesome.min.css"
    />
    <link rel="stylesheet" href="/assets/plugins/daum-editor/css/editor.css" />
    <link rel="stylesheet" href="/assets/css/styles.css?ver=${ver}" />
  </head>
  <body></body>
</html>
