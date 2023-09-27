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
<script src="https://kit.fontawesome.com/ce494e5de1.js" crossorigin="anonymous"></script>
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

<div id="sub_menu">
 <ul>
  <li><h2><a href="${path}/service/service_center">고객센터</a></h2></li>
  <li><h2><a href="${path}/service/service_question">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
  <li><h2><a href="${path}/service/service_qboard">1대1문의</a></h2></li>
 </ul>
</div>


<%-- 공지사항 목록 보기 --%>
<form method="get" action="service_notice">
<div class="center_nlist">
	<table class="qna-table">
	<caption class="main_title">공지 목록</caption>
		<tbody>
		<tr>
			<th class="nlist-type">제목</th>
			<th class="nlist-title">제목</th>
			<th class="nlist-date">날짜</th>
		</tr>
		<c:forEach var="g" items="${slist}">
		<c:if test="${!empty slist}">
		<tr>
			<td>${g.cs_no }</td>
			<td>
				<a href="service_ncont?cs_no=${g.cs_no}"> 
				<c:if test="${fn:length(g.cs_title)>40}">
     						${fn:substring(g.cs_title,0,40)}...
    			</c:if> 
    			<c:if test="${fn:length(g.cs_title)<40}">
   				${g.cs_title}
    			</c:if>
				</a>
			</td>
			<td>${fn:substring(g.cs_date,0,10)}</td>
		</tr>
		</c:if>
		<c:if test="${empty slist}">
			<tr>
				<th colspan="2">공지 목록이 없습니다!</th>
			</tr>
		</c:if>
		</c:forEach>
		</tbody>
	</table>
</div>


<%--페이징(쪽나누기)--%>
<div id="page_control">
	<%--검색전 페이징 --%>
	<c:if test="${(empty find_field)&&(empty find_name)}">
		<c:if test="${page <=1}">[이전]&nbsp;</c:if>
		<c:if test="${page >1}">
			<a href="service_notice?page=${page-1}">[이전]</a>&nbsp;
				</c:if>

		<%--쪽번호 출력부분 --%>
		<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
			<c:if test="${a == page}"><${a}></c:if>
			<c:if test="${a != page}">
				<a href="service_notice?page=${a}">[${a}]</a>&nbsp;
					</c:if>
		</c:forEach>
		<c:if test="${page>=maxpage}">[다음]</c:if>
		<c:if test="${page<maxpage}"><a href="service_notice?page=${page+1}">[다음]</a></c:if>
	</c:if>
	
	<%-- 검색후 페이징(쪽나누기) --%>
	<c:if test="${(!empty find_field) || (!empty find_name)}">
		<c:if test="${page <=1}">[이전]&nbsp;</c:if>
		<c:if test="${page >1}">
			<a href="service_notice?page=${page-1}&find_field=${find_field}
				&find_name=${find_name}">[이전]</a>&nbsp;
			</c:if>

	<%--쪽번호 출력부분 --%>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
		<c:if test="${a == page}"><${a}></c:if>
		<c:if test="${a != page}">
			<a href="service_notice?page=${a}&find_field=${find_field}
				&find_name=${find_name}">[${a}]</a>&nbsp;
			</c:if>
	</c:forEach>

	<c:if test="${page>=maxpage}">[다음]</c:if>
	<c:if test="${page<maxpage}">
		<a href="service_notice?page=${page+1}&find_field=${find_field}
			&find_name=${find_name}">[다음]</a>
	</c:if>
</c:if>
</div>

<div  class="write-menu">
<c:if test="${(!empty find_field) && (!empty find_name)}">
	<input type="button" value="전체목록" onclick="location='service_notice?page=${page}';" />
</c:if>
</div>

<%--검색폼 추가 --%>
<div id="bFind_wrap">
<select name="find_field">
	<option value="cs_title" 
	<c:if test="${find_field == 'cs_title'}">${'selected'}</c:if>>
	제목</option>
	<option value="cs_cont"
	<c:if test="${find_field == 'cs_cont'}">${'selected'}</c:if>>
	내용</option>
</select> 

<input type="search" name="find_name" id="find_name" size="16" value="${find_name}" >
<input type="submit" value="검색" >
</div>
</form>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>