<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 페이지</title>
<link rel="stylesheet" type="text/css" href="${path}/resources/css/member/serch_id.css">
<script src="${path}/resources/js/jquery.js"></script>
<%-- <script src="${path}/resources/js/member/s_id.js"></script>--%>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<form action="m_login">
<div id="wrap">
	<div id="serchform"> 
		<div id="logo">
			
			<p id="logoP">아이디 찾기</p>
			고객님의 정보와 일치하는 아이디입니다.
			<hr>
			
		</div>
		<div id="name_form">
				
				<div>
				<p id = "userIdOk">회원님의 아이디</p>
				<p id = "userIdOk"> ${userid}</p>
				</div>
			
				<div id="button_form">
					<input type="submit" id="btn02" value="로그인 하기" onclick="return last_ck();">
					<input type="button" id="btn02" value="비밀번호 찾기" onclick="location.href='serch_pwd'">
					
				</div>
			</div>
	</div>
</div>
</form>


<%-- include : footer --%>
<%@ include file="../include/footer.jsp" %>
</body>
</html>