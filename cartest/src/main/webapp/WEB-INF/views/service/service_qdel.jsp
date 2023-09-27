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
<script>
 function del_check(){
    if($.trim($("#del_pwd").val()) == ""){
       alert("삭제 비번을 입력하세요!");
       $("#del_pwd").val("").focus();
       return false;
    }
 }
</script>
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
<div id="bsDel_wrap">
<form method="post" action="qna_del_ok?cq_no=${q.cq_no}" onsubmit="return del_check();">
	<input type="hidden" name="page" value="${page}" />
	<table class="qpwdCheck-table">
	<caption class="main_title">비밀번호 재확인</caption>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="del_pwd" id="del_pwd"/></td>
            </tr>
         </table>
         <div class="write-menu">
		<input type="submit" value="삭제" /> 
		<input type="reset" value="취소" onclick="location='service_qboard?page=${page}';" />
         </div>
      </form>
</div>
</main>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>