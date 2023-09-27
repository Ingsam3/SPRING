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

<%--서브 메인 이미지--%>
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


<%-- 1대1문의 목록 보기 --%>
<main>

<form method="get" action="service_qboard">
		<div id="center_nlist">
			<table class="qna-table">
			<caption class="main_title">1대1문의 목록</caption>
			<tr>
				<th class="nlist-type">번호</th>
				<th class="nlist-title">제목</th>
				<th class="nlist-id">작성자</th>
				<th class="nlist-date">날짜</th>
			</tr>

			<c:if test="${!empty qnalist}">
			<c:forEach var="q" items="${qnalist}">
			<tr class="qnalist">
				<td>
				<c:if test="${q.qna_replytype == 0}">
				<%--원본글일때만 글그룹 번호가 출력되고,답변글일때는 그룹번호가 출력 안됨.--%>
					&lt;${q.qna_replygroup}&gt;
				</c:if>
				</td>

				<td>
				<c:if test="${q.qna_replytype != 0}"> 
				<%-- 답변글일때만 실행, 계단형 게시판  --%>
                  		<c:forEach begin="1" end="${q.qna_replytype}" step="1">
                 		  &nbsp;
				<%--빈공백 처리함으로써 2번째 답변글이면 2칸의 빈공백을 띄움 --%>
                  		</c:forEach>
                		  <img src="./images/AnswerLine.gif" > <%--답변글 이미지 출력 --%>
             			</c:if>							      
				<a href="service_qpwdCheck?cq_no=${q.cq_no}&state=cont&page=${page}">${q.cq_title}</a>
				</td>
				<td align="center">${q.cq_id}</td>
				<td align="center">${fn:substring(q.cq_date,0,10)}</td>
				<%-- 0이상 10미만 사이의 년월일만 반환 --%>
			</tr>
			</c:forEach>
			</c:if>

			<c:if test="${empty qnalist}">
			<tr>
				<th colspan="4">자료실 목록이 없습니다.</th>
			</tr>
			</c:if>
			</table>
			<div id="write-button">
			</div>

		<%--페이징(쪽나누기)--%>
		<div id="page_control">
			<%--검색전 페이징 --%>
			<c:if test="${(empty find_field)&&(empty find_name)}">
				<c:if test="${page <=1}">[이전]&nbsp;</c:if>
				<c:if test="${page >1}">
					<a href="service_qboard?page=${page-1}">[이전]</a>&nbsp;
  				</c:if>

				<%--쪽번호 출력부분 --%>
				<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
					<c:if test="${a == page}"><${a}></c:if>
					<c:if test="${a != page}">
						<a href="service_qboard?page=${a}">[${a}]</a>&nbsp;
  					</c:if>
				</c:forEach>
				<c:if test="${page>=maxpage}">[다음]</c:if>
				<c:if test="${page<maxpage}"><a href="service_qboard?page=${page+1}">[다음]</a></c:if>
			</c:if>
			
			<%-- 검색후 페이징(쪽나누기) --%>
			<c:if test="${(!empty find_field) || (!empty find_name)}">
				<c:if test="${page <=1}">[이전]&nbsp;</c:if>
				<c:if test="${page >1}">
					<a href="service_qboard?page=${page-1}&find_field=${find_field}
						&find_name=${find_name}">[이전]</a>&nbsp;
 				</c:if>

			<%--쪽번호 출력부분 --%>
			<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				<c:if test="${a == page}"><${a}></c:if>
				<c:if test="${a != page}">
					<a href="service_qboard?page=${a}&find_field=${find_field}
						&find_name=${find_name}">[${a}]</a>&nbsp;
 				</c:if>
			</c:forEach>

			<c:if test="${page>=maxpage}">[다음]</c:if>
			<c:if test="${page<maxpage}">
				<a href="servicec_qboard?page=${page+1}&find_field=${find_field}
					&find_name=${find_name}">[다음]</a>
			</c:if>
		</c:if>
		</div>

		<div  class="write-menu">
		<c:if test="${(!empty find_field) && (!empty find_name)}">
			<input type="button" value="전체목록" onclick="location='service_qboard?page=${page}';" />
		</c:if>
		</div>

		<%--검색폼 추가 --%>
		<div id="bFind_wrap">
		<select name="find_field">
			<option value="cq_title" 
			<c:if test="${find_field == 'cq_title'}">${'selected'}</c:if>>
			제목</option>
			<option value="cq_cont"
			<c:if test="${find_field == 'cq_cont'}">${'selected'}</c:if>>
			내용</option>
		</select> 
		
		<input type="search" name="find_name" id="find_name"size="16" value="${find_name}" >
		<input type="submit" value="검색" >
		<input type="button" value="글쓰기" onclick="location='service_qwrite';" />
		</div>
	</div>
</form>
</main>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>