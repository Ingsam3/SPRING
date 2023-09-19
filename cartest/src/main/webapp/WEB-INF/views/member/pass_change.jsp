<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
<link rel="stylesheet" type="text/css" href="${path}/css/member/change_pwd.css">
<script src="${path}/js/jquery.js"></script>
<script type="text/javascript" src="${path}/js/member/pwd_change.js"></script>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<div id="wrap">
	<div id="serchform"> 
		<div id="logo">
			
			<p id="logoP">비밀번호 변경</p>
			변경 할 비밀번호를 입력해주세요 
		</div>
		<div id="pwd_form">
					<input id="m_pwd" name="m_pwd" placeholder="변경 할 비밀번호"
					onfocus="this.placeholder=''" onblur="this.placeholder='변경 할 비밀번호'">
				<div id="ck_form">
					<input id="ck_pwd" name="ck_pwd" placeholder="비밀번호 확인"
					onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호 확인'">
				</div>
				<div id="button_form">
					<input type="button" id="btn" value="확인" onclick="return pwd_ck();">
					<%--이메일 인증 안 되면 alert 이메일을 먼저 인증해주세요. --%>
				</div>
			</div>
	</div>
</div>


<%-- include : footer --%>
<%@ include file="../include/footer.jsp" %>


</body>
</html>