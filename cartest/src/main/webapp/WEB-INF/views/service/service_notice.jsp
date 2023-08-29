<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery.js"></script>
<script src="https://kit.fontawesome.com/ce494e5de1.js" crossorigin="anonymous"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
<link href="${path}/resources/css/service.css" rel="stylesheet"/>
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
  <li><h2><a href="${path}/service/service_qna">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
 </ul>
</div>

<div id="table_search">
	<form class="table-form">
		<fieldset>
			<legend class="hidden">공지사항 검색 필드</legend>
			<label class="hidden">검색분류</label>
			<select name="f">
				<option value="title">제목</option>
				<option value="writerId">작성자</option>
			</select>
			<label class="hidden">검색어</label>
			<input type="text" class="notice_box" placeholder="찾을 내용을 입력하세요."> 
		</fieldset>
	</form>
</div>


<table id="notice">
	<tr>
	   <th class="tno">no.</th>
	   <th class="ttitle">title</th>
	   <th class="twrite">writer</th>
	   <th class="tdate">date</th>
	   <th class="tread">read</th>
	</tr>
</table>
     

<div class="clear"></div>

<div id="page_control">
   <a href="#">Prev</a> 
   <a href="#">1</a> 
   <a href="#">2</a> 
   <a href="#">3</a>
   <a href="#">4</a> 
   <a href="#">5</a> 
   <a href="3">6</a> 
   <a href="#">7</a>
   <a href="#">8</a> 
   <a href="#">9</a> 
   <a href="#">10</a> 
   <a href="#">Next</a>
</div>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>