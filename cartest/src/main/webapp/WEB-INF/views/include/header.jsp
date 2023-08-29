<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>CarInDrive</title>
  <link rel="stylesheet" type="text/css" href="${path}/resources/css/main.css">
</head>
<body>
  <header>
    <div class="logo">
      <a href="${path}/">
        <img src="${path}/resources/images/logo.jpg" width="80" height="62" alt="carindrive">
      </a>
    </div>
    
    <nav>
      <ul>
        <li><a href="${path}/rent/rent">차량예약</a></li>
        <li><a href="${path}/rent">예약확인</a></li>
        <li><a href="${path}/guide">이용안내</a></li>
        <li><a href="${path}/insurance/insurance">보험안내</a></li>
        <li><a href="${path}/event">이벤트</a></li>
        <li><a href="${path}/service/service_center">고객센터</a></li>
        <li><a href="${path}/member">내정보</a></li>
      </ul>
    </nav>
    
    <div class="login">
    	<b><a href="${path}/member/m_login">로그인</a></b> | <b><a href="${path}/member/m_join">회원가입</a></b>
    </div>
  </header>
  
 <div class="clear"></div>