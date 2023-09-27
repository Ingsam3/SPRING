<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${path}/js/jquery.js"></script>
<script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
<link href="${path}/css/main.css" rel="stylesheet"/>
<link href="${path}/css/service.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div id="sub_img_center"></div>
<div class="clear"></div>

<%--서브 메인 이미지--%>
<div id="sub_img_member"></div>
<div class="clear"></div>

<h1 id="board_name">고객센터</h1>

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


<%-- 자주 묻는 질문 탭 영역 및 내용 펼쳐 보기 --%>
<div class="tab_content">
	<input type="radio" name="tabmenu" id="tab01" checked>
	<label for="tab01">전체</label>
	<input type="radio" name="tabmenu" id="tab02">
	<label for="tab02">가입/탈퇴</label>
	<input type="radio" name="tabmenu" id="tab03">
	<label for="tab03">예약/취소</label>
	<input type="radio" name="tabmenu" id="tab04">
	<label for="tab04">쿠폰/포인트</label>
	<input type="radio" name="tabmenu" id="tab05">
	<label for="tab05">요금/결제</label>
	<input type="radio" name="tabmenu" id="tab06">
	<label for="tab06">사용/반납</label>
	<input type="radio" name="tabmenu" id="tab07">
	<label for="tab07">보험/사고</label>
	<input type="radio" name="tabmenu" id="tab08">
	<label for="tab08">전기차</label>
	<input type="radio" name="tabmenu" id="tab09">
	<label for="tab09">법인</label>
	<input type="radio" name="tabmenu" id="tab10">
	<label for="tab10">기타</label>
	
	<div class="conbox con1">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">휴대폰 기기인증 실패</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
   <div class="conbox con2">
   		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">휴대폰 기기인증 실패</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
   <div class="conbox con3">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">예약한 차량의 댓글 내역 확인</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
      
   <div class="conbox con4">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">조기 반납 포인트</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
   <div class="conbox con5">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">그린카 요금 적용,결제 기준</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>

   <div class="conbox con6">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">분실물 발생 시</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
      <div class="conbox con7">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">사고접수 과정</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
      <div class="conbox con8">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">충전 후 반납형 전기차 문의</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
      <div class="conbox con9">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">법인용 결제와 일반 결제 차이점</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
   
      <div class="conbox con10">
		<div id="q">
			<input type="checkbox" name="accordian" id="answer01">
			<label for="answer01">세차서비스</label>
			<div><p>내용을 추가하세요1</p></div>
			<input type="checkbox" name="accordian" id="answer02">
			<label for="answer02">제목2</label>
			<div><p>내용을 추가하세요2</p></div>
			<input type="checkbox" name="accordian" id="answer03">
			<label for="answer03">제목3</label>
			<div><p>내용을 추가하세요3</p></div>
			<input type="checkbox" name="accordian" id="answer04">
			<label for="answer04">제목4</label>
			<div><p>내용을 추가하세요3</p></div>
		</div>
   </div>
</div>


<div id="page_control">
   <a href="#">Prev</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
   <a href="#">4</a> <a href="#">5</a> <a href="3">6</a> <a href="#">7</a>
   <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">Next</a>
</div>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>