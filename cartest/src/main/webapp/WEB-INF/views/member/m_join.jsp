<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carindrive : 회원가입 페이지</title>
<link rel="stylesheet" type="text/css" href="${path}/resources/css/member/m_join.css">
<script type="text/javascript" src="${path}/resources/js/join.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap" rel="stylesheet">
<script src="${path}/resources/js/jquery.js"></script>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<form action="member_join_ok" method="post">
	<div id="logo">
		<hr>
		CARINDRIVE
		<hr>
	</div>
	<div id="wrap" >
		<!--아이디 & 비밀번호  -->
		<div id="form1">
			<div id="idform">
				<input id="m_id" name="m_id" placeholder="아이디"
				onfocus="this.placeholder=''" onblur="this.placeholder='아이디'">
				<br><span id="idcheck"></span>
			</div>
			<div id="checkid">
				<input type="button" id="ckidbtn" onclick="return id_check();" value="중복 확인">
			</div>
			<div id="pwdform">
				<input type="password" id="m_pwd" name="m_pwd" placeholder="비밀번호"
				onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호'">
				<span class="pwdck"></span>
			</div>
			<div id="pwdCKform">
				<input type="password" id="pwd_ck" name="pwd_ck" placeholder="비밀번호 확인"
				onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호 확인'">
				<span class="pwd_ck"></span>
			</div>
		
		<!-- 개인정보 -->
			<div id="nameform">
				<input id="m_name" name="m_name" placeholder="이름"
				onfocus="this.placeholder=''" onblur="this.placeholder='이름'">
				<span class="nameck"></span>	
			</div>
			<div id="birthform">
				<input id="m_birth" name="m_birth" placeholder="생년월일 8자리"
				onfocus="this.placeholder=''" onblur="this.placeholder='생년월일 8자리'">
				<span class="birthck"></span>
			</div>
			<div id="emailform">
				<input id="m_email" name="m_email" placeholder="이메일"
				onfocus="this.placeholder=''" onblur="this.placeholder='이메일'">
			</div>
			<div id="email_select_form">	
				<select id="m_email_se" name="m_email_se" class="select">
		    		<option value="">이메일 선택</option>
		    		<option value="naver">naver.com</option>
		    		<option value="gmail">gmail.com</option>
		    		<option value="daum">daum.net</option>
				</select>
				<span class="emailck"></span>
			</div>
			<div id="telform">
				<select id="m_tel" name="m_tel" class="select">
		    		<option value="">통신사 선택</option>
		    		<option value="SK">SK</option>
		    		<option value="KT">KT</option>
		    		<option value="LG">LGU+</option>
		    		<option value="알뜰">알뜰폰</option>
				</select>
			</div>
			<div id="phoneform">
				<input id="m_phone" name="m_phone" placeholder="휴대전화번호"
				onfocus="this.placeholder=''" onblur="this.placeholder='휴대전화번호'">
				<span class="phoneck"></span>
			</div>
			<!-- 유효성 검증 창 -->
			<span id="text"></span>
			<!-- 버튼 -->
			<div id="form3">
				  <input type="submit"  name="Y" id="btn1"  value="가입하기" onclick=" return joinCheck();">
				<!-- <input type="reset" value="취소"> -->
				<!--<button type="submit" value="Y" name="Y" id="btn1" onclick=" return joinCheck()" >가입하기</button>-->
			</div>
		</div><%--form1 end --%>
	</div> <%-- wrap end --%>
</form>
<%-- include : footer --%>
<%@ include file="../include/footer.jsp" %>
</body>
</html>

