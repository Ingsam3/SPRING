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
<script src="${path}/resources/js/member/s_id.js"></script>
</head>
<body>
<%-- include : main --%>
<%@ include file="../include/header.jsp" %>
<form action="serch_id_email_ck" method="post">
<div id="wrap">
	<div id="serchform"> 
		<div id="logo">
			
			<p id="logoP">아이디 찾기</p>
			아이디는 가입시 입력하신 이메일을 통해 찾을 수 있습니다.
			
		</div>
		<div id="name_form">
				<div id="id_name">
					<input id="m_name" name="m_name" placeholder="이름"
					onfocus="this.placeholder=''" onblur="this.placeholder='이름'">
				</div>
				<div id="email_form">
					<input id="m_email" name="m_email" placeholder="이메일"
					onfocus="this.placeholder=''" onblur="this.placeholder='이메일'">
				</div>
				<div id="button_form1">
					<input type="submit" id="btn01"  value="인증번호받기" onclick="return serch_email();">
				</div>
				
				<%-- 인증번호 받기 누르면 사용자 이메일로 가서 인증번호 받고, 
				입력받은 인증번호와 전송한 인증번호 비교하면 맞으면 찾기버튼 누르고  아이디 출력 창으로 이동 --%>
				
				
				<div id="ck_form">
					<input id="ck_email" name="ck_email" placeholder="인증번호"
					onfocus="this.placeholder=''" onblur="this.placeholder='인증번호'">
				</div>
				 <div id="button_form">
					<input type="submit" id="btn02" value="찾기" onclick="return last_ck();">
					<%--이메일 인증 안 되면 alert 이메일을 먼저 인증해주세요. --%>
				
			</div>
			</div>
	</div>
</div>
</form>
<%-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    function sendNumber(){
        $("#mail_number").css("display","block");
        $.ajax({
            url:"/mail",
            type:"post",
            dataType:"json",
            data:{"mail" : $("#mail").val()},
            success: function(data){
                alert("인증번호 발송");
                $("#Confirm").attr("value",data);
            },
	        }
        });
    }

    function confirmNumber(){
        var number1 = $("#number").val();
        var number2 = $("#Confirm").val();

        if(number1 == number2){
            alert("인증되었습니다.");
        }else{
            alert("번호가 다릅니다.");
        }
    }
</script>
<div layout:fragment="content">
    <form role="form" method="post" th:object="${memberFormDto}">
<div class="form-group">
  			<!-- 생략 -->
                <button type="button" id="sendBtn" name="sendBtn" onclick="sendNumber()">인증번호</button>
            </div>
                <br>
            <div id="mail_number" name="mail_number" style="display: none">
                <input type="text" name="number" id="number" style="width:250px; margin-top: -10px" placeholder="인증번호 입력">
                <button type="button" name="confirmBtn" id="confirmBtn" onclick="confirmNumber()">이메일 인증</button>

</div>
</form>--%>


<%-- include : footer --%>
<%@ include file="../include/footer.jsp" %>
</body>
</html>