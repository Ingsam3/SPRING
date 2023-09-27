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
   <div id="bsW_wrap">
      <form method="post" action="qna_edit_ok"
         onsubmit="return write_check();" enctype="multipart/form-data">
  
          <%-- 자료실 번호 히든값--%>
          <input type="hidden" name="cq_no" value="${q.cq_no}" >
          <%--책갈피 페이지 번호 히든값 --%>
          <input type="hidden" name="page" value="${page}" >
          
	<table class="write-table">
	<caption class="main_title">1대1문의 수정</caption>
            <tr>
               <th>글쓴이</th>
               <td class="serivce" colspan="4">${cq_id}</td>
            </tr>
            <tr>
               <th>글제목</th>
               <td class="serivce" colspan="4">
               <input name="cq_title" id="cq_title" value="${q.cq_title}" /></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td class="serivce" colspan="4">
               <input type="password" name="cq_pwd" id="cq_pwd" /></td>
            </tr>
            <tr>
               <th>글내용</th>
               <td colspan="5">
               <textarea name="cq_cont" id="cq_cont">${q.cq_cont}</textarea></td>
            </tr>
            <tr>
               <th>파일첨부</th>
               <td class="serivce" colspan="4">
               <input type="file" name="cq_file" /><br>${q.cq_file}</td>
            </tr>
         </table>
         <div class="write-menu">
		<input type="submit" value="수정" /> 
		<input type="button"
               value="목록" onclick="location='service_qboard?page=${page}';">
         </div>
      </form>
   </div>
</main>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>