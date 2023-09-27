<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${path}/js/jquery.js"></script>
<script src="${path}/js/accordion.js" defer></script>
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
  <li><h2><a href="${path}/service/service_question">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
  <li><h2><a href="${path}/service/service_qboard">1대1문의</a></h2></li>
 </ul>
</div>


<%-- 질문 검색바 --%>
<form method="get" action="service_notice">
<div class="search">
      <input type="search" name="find_name" id="find_name" 
      class="input_box" placeholder="찾을 내용을 입력하세요." value="${find_name}" >
      <i class="fas fa-search"></i>
      <input type="submit" class="box" value="검색">                                                                                                                                                                                     
      <input type="reset" class="box" value="초기화">
      <ul class="search_word"> 
      	<li class="word3"><a href="${path}/service/service_question00">전체</a></li>
      	<li class="word3"><a href="${path}/service/service_question01">가입/탈퇴</a></li>
      	<li class="word3"><a href="${path}/service/service_question02">예약취소</a></li>
      	<li class="word4"><a href="${path}/service/service_question03">요금/결제</a></li>
      	<li class="word5"><a href="${path}/service/service_question04">사용/반납</a></li>
      	<li class="word6"><a href="${path}/service/service_question05">보험/사고</a></li>
      	<li class="word7"><a href="${path}/service/service_question06">전기차</a></li>
      	<li class="word9"><a href="${path}/service/service_question07">기타</a></li>
      </ul>
</div>
</form>

<c:if test="${!empty slist}">
	<c:forEach var="s" items="${slist}">
	<div class="accordion">
		<div class="accordion-item">
			<div class="accordion-item-header">
				${s.cs_title}
			</div>
			<div class="accordion-item-body">
				<div class="accordion-item-body-content">
					${s.cs_cont}
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</c:if> 


<jsp:include page="../include/footer.jsp"/>
</body>
</html>