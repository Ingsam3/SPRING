<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery.js"></script>
<script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/ce494e5de1.js" crossorigin="anonymous"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
<link href="${path}/resources/css/service.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div id="sub_img_center"></div>
<div class="clear"></div>

<%--서브 메인 이미지--%>
<div id="sub_img_member"></div>
<div class="clear"></div>

<h1 id="board_name">고객센터</h1>

<%-- 고객센터 메뉴 --%>
<div id="sub_menu">
 <ul>
  <li><h2><a href="${path}/service/service_center">고객센터</a></h2></li>
  <li><h2><a href="${path}/service/service_qna">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
 </ul>
</div>

<%-- 질문 검색바 --%>
<div class="search">
      <input type="text" class="input_box" placeholder="찾을 내용을 입력하세요.">
      <i class="fas fa-search"></i>
      <input type="button" class="box" value="검색">
      <input type="button" class="box" value="초기화">
      <ul class="search_word">
      	<li class="word1"><a href="${path}/service/service_qna">가입/탈퇴</a></li>
      	<li class="word2"><a href="${path}/service/service_qna">예약/취소</a></li>
      	<li class="word3"><a href="${path}/service/service_qna">쿠폰/포인트</a></li>
      	<li class="word4"><a href="${path}/service/service_qna">요금/결제</a></li>
      	<li class="word5"><a href="${path}/service/service_qna">사용/반납</a></li>
      	<li class="word6"><a href="${path}/service/service_qna">보험/사고</a></li>
      	<li class="word7"><a href="${path}/service/service_qna">전기차</a></li>
      	<li class="word8"><a href="${path}/service/service_qna">법인</a></li>
      	<li class="word9"><a href="${path}/service/service_qna">기타</a></li>
      </ul>
</div>

<%-- 고객센터 주요 기능 바로가기  --%>
<div class="shortcut">
	<div class="shortcut1">
		<i class="fa-solid fa-phone fa-2xl"></i><br>
		<b>1111-1111</b><p>365일 24시간 운영</p>
	</div>
	<div class="shortcut2">
		<i class="fa-regular fa-circle-question fa-2xl"></i><br>
		<a href="${path}/service/service_qna"><b>자주 묻는 질문</b></a>
	</div>
	<div class="shortcut3">
		<i class="fa-solid fa-comments fa-2xl"></i><br>
		<a href="${path}/service/service_qwrite"><b>1:1 문의 하기</b></a>
	</div>
</div>


<%--  --%>
<div class="notice-all-btn">
	<a a href="${path}/service/service_notice" class="notice-all">공지사항 전체 보기</a>
</div>
<br><br>


<jsp:include page="../include/footer.jsp"/>
</body>
</html>