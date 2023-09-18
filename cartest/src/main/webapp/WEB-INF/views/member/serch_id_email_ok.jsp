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

<script type="text/javascript">

	console.dir(document.getElementById("ck_email"));
	console.dir(document.getElementById("userCodeOk"));
	console.dir('${code}');

	function code_ck() {
		
		const ck_email = document.getElementById('ck_email').value;
		if(ck_email === '${code}'){
			document.getElementById("userCodeOk").style.visibility ='visible';	
		}else{
			alert('인증 번호가 일치하지 않습니다!');
			
		}
	}

</script>

<%-- <script src="${path}/resources/js/member/s_id.js"></script>--%>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<form method="get" >
<div id="wrap">
	<div id="serchform"> 
		<div id="logo">
			
			<p id="logoP">아이디 찾기</p>
			인증번호를 입력해주세요.
			<div id="ck_form">
					<input id="ck_email" name="ck_email" placeholder="인증번호"
					onfocus="this.placeholder=''" onblur="this.placeholder='인증번호'">
				</div>
			<div id="button_form">
					<input type="button" id="btn02" value="확인" onclick="return code_ck();">
				
			<hr>
				<p id = "userIdOk" style="font-size: 20px;" >회원님의 아이디</p>
				<p id = "userCodeOk" style="visibility: hidden; font-size: 20px;"> ${userid}</p> 
			
					<input type="button" id="btn02" value="로그인 하기" onclick="location.href='m_login'">
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