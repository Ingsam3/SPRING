<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${path}/css/member/serch_id.css">
<script src="${path}/js/jquery.js"></script>

<script type="text/javascript">


	function code_ck() {
		
		if($.trim($("#ck_email").val()) ==""){
			alert("인증번호를 입력하세요!");
			$("#ck_email").val("").focus();
			return false;
		}
		
		const ck_email = document.getElementById('ck_email').value;
		
		if(ck_email === '${code}'){
			//인증번호 일치 시 보이기
			document.getElementById("userCodeOk").style.visibility ='visible';
			document.getElementById("userCodeOk01").style.visibility ='visible';
			document.getElementById("userCodeOk02").style.visibility ='visible';
			document.getElementById("ch_pwd").style.visibility ='visible';
			document.getElementById("ch_pwd02").style.visibility ='visible';
			document.getElementById("btn").style.visibility ='visible';
			document.getElementById("id").style.visibility ='visible';
			
			
		}else{
			alert('인증 번호가 다릅니다!');
			
		}
	}
	
	function empty_ck() {
		
		if($.trim($("#id").val()) ==""){
			alert("아이디를 입력하세요!");
			$("#id").val("").focus();
			return false;
		}
		if($.trim($("#ch_pwd").val()) ==""){
			alert("비밀번호를 입력하세요!");
			$("#ch_pwd").val("").focus();
			return false;
		}
		if($.trim($("#ch_pwd02").val()) ==""){
			alert("비밀번호를 입력하세요!");
			$("#ch_pwd02").val("").focus();
			return false;
		}
		
		//비밀번호 동일하면 비밀번호 변경
		
		const ch_pwd = document.getElementById('ch_pwd').value;
		const ch_pwd02 = document.getElementById('ch_pwd02').value;
				
		//비밀번호 정규식 체크
		  let checkpwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
		  
		  if(!checkpwd.test(ch_pwd)){
			  alert("비밀번호는 영문자+숫자+특수문자 조합 \n 8이상~12자리 이하로만 사용해야합니다. ");
			  $("#ch_pwd").val("").focus();
			  return false;
		  }
		
		if(ch_pwd != ch_pwd02){
			alert("비밀번호가 일치하지 않습니다!");
			$("#ch_pwd02").val("").focus();
			return false;
		}else{
			if(confirm("비밀번호를 변경 하시겠습니까?")){
				//alert("정상적으로 변경되었습니다.");
				location.href="pwd_change_ok";
				
			}else{
				alert("변경 실패");
			}
		}
		
	}
	
	
	
</script>

<%-- <script src="${path}/resources/js/member/s_id.js"></script>--%>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<form method="post" action="pwd_change_ok" id="p_form">
<div id="wrap" style="height: 800px;">
	<div id="serchform" style="height: 800px; margin-top: 20px; margin-bottom: 20px;"> 
		<div id="logo">
			
			<p id="logoP">비밀번호 변경</p>
			인증번호를 입력해주세요.
			<div id="ck_form">
					<input id="ck_email" name="ck_email" placeholder="인증번호"
					onfocus="this.placeholder=''" onblur="this.placeholder='인증번호'">
				</div>
			<div id="button_form">
					<input type="button" id="btn02" value="확인" onclick="return code_ck();">
				
			<hr>
			<%-- 임시 비밀번호 생성시에
			<p id = "userIdOk" style="font-size: 20px;" >임시비밀번호</p>
			<p id = "userCodeOk" style="visibility: hidden; font-size: 20px;"> ${userid}</p> 
			--%>
			
			<div id="pwd_form">
				<%--아이디 --%>
				<p id = "userCodeOk" style="font-size: 20px; visibility: hidden;" >아이디 입력</p>

				<input type="text" id="id" name="id" placeholder="아이디" 
				onfocus="this.placeholder=''" onblur="this.placeholder='아이디'" style="visibility: hidden;">
				
				<%--비밀번호 --%>
				<p id = "userCodeOk01" style="font-size: 20px; visibility: hidden;" >변경할 비밀번호</p>
				
				<input type="password" id="ch_pwd" name="ch_pwd" placeholder="비밀번호" 
				onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호'" style="visibility: hidden;">
				
				<%--비밀번호 확인--%>
				<p id = "userCodeOk02" style="font-size: 20px; visibility: hidden;" >비밀번호 확인</p>
				
				<input type="password" id="ch_pwd02" name="ch_pwd02" placeholder="비밀번호 확인" 
				onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호 확인'" style="visibility: hidden;">
				
			
				<input type="submit" id="btn" style="visibility: hidden;" value="비밀번호 변경하기"
				 onclick="return empty_ck();">
			</div>	
					
				</div>
			</div>	
				
			</div>
		</div>
</form>


<%-- include : footer --%>
<%@ include file="../include/footer.jsp" %>
</body>
</html>