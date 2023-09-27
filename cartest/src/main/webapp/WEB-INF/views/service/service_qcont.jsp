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
<div id="bsC_wrap">
	<table class="write-table">
	<caption class="main title">1:1문의 보기</caption>
		<tr>
			<th>제목</th>
			<td class="serivce" colspan="2" name="cq_title" id="cq_title" >${q.cq_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="serivce" colspan="2">${q.cq_cont}</td>
		</tr>
		<c:if test="${!empty q.cq_file}">
			<%--첨부파일이 있는경우--%>
			<tr>
				<th>첨부이미지</th>
				<td class="serivce" colspan="3" name="cq_file" id="cq_file"><img src="./upload${q.cq_file}"/></td>
			</tr>
		</c:if>
	</table>
	<div  class="write-menu">
		<input type="button" value="수정"
			onclick="location='service_qcont?cq_no=${q.cq_no}&page=${page}&state=edit';" />
		<input type="button" value="삭제"
			onclick="location='service_qcont?cq_no=${q.cq_no}&page=${page}&state=del';" />
		<input type="button" value="목록"
			onclick="location='service_qboard?page=${page}';" />
	</div>
</div>
</main>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>