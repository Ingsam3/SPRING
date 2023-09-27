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

<%-- 고객센터 메뉴 --%>
<div id="sub_menu">
 <ul>
  <li><h2><a href="${path}/service/service_center">고객센터</a></h2></li>
  <li><h2><a href="${path}/service/service_question">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
  <li><h2><a href="${path}/service/service_qboard">1대1문의</a></h2></li>
 </ul>
</div>


<main>
<div class="qpwdCheck">
<form method="post" action="qpwdCheck_ok">

	<input type="hidden" name="cq_no" value="${cq_no}" >
	<input type="hidden" name="page" value="${page}" >
	<input type="hidden" name="state" value="${state}" >
	
	<table class="qpwdCheck-table">
	<caption class="main_title">비밀번호 재확인</caption>
	<caption class="ex">회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인해주세요.</caption>
		<tr>
			<th>회원 아이디</th>
			<td>${q.cq_id}</td>
		</tr>
		<tr>
			<th>게시물 제목</th>
			<td>${q.cq_title}</td>
		<tr>
			<th>게시물 비밀번호&nbsp;<font style="color:red;">*</font></th>
			<td><input type="password" size="14" id="cq_pwd" name="cq_pwd"></td>
		</tr>
	</table>
	<input id="qpwdCheck" type="submit" value="확인"/>
</form>
<div class="clear"></div>
</div>
</main>


<jsp:include page="../include/footer.jsp"/>
</body>
</html>