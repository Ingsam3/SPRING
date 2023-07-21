<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 게시판 목록</title>
<script src="../resources/js/jquery.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="5">스프링 게시판 목록</th>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<span style="font-weight: bolder;">총 게시물 수 :${totalCount}개</span>
			</td>
		</tr>
		<tr>
			<th>번호</th><th>제목</th><th>글쓴이</th><th>조회수</th><th>등록날짜</th>
		</tr>
			<c:if test="${!empty blist}"> <!-- 목록이 있는 경우 실행 -->
				<c:forEach var="b" items="${blist }">
					<tr>
						<th>${b.bno }</th>
						<th>${b.title }</th>
						<th>${b.writer }</th>
						<th>${b.viewcnt }</th>
						<th>${b.regdate }</th>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty blist }">
				<tr>
					<th colspan="5">게시물 목록이 없습니다</th>
				</tr>
			</c:if>
		<%--페이징(쪽나누기)시작 --%>
		<tr>
			<th colspan="5">
				<c:if test = "${page <=1}">
				[이전] &nbsp; 
				</c:if>
				<c:if test = "${page>1 }">
					<a href="/controller/board/board_list?page=${page-1 }">[이전]</a>&nbsp;
				</c:if>
				<%--쪽번호 출력 부분 --%>
				<c:forEach var="a" begin="${ startpage}" end="${endpage }" step="1">
					<c:if test="${a == page }"><%-- 현재쪽번호가 선택된경우--%>
					<${a}>
					</c:if>
					<c:if test="${a != page }"><%-- 현재쪽번호가 선택 안된경우--%>
					<a href="/controller/board/board_list?page=${a}">[${a}]</a>&nbsp;
					<%--get 방식으로 전달 --%>
					</c:if>
				</c:forEach>
				<c:if test="${page>=maxpage }">
				[다음]
				</c:if>
				<c:if test="${page<maxpage }">
				<a href="/controller/board/board_list?page=${page+1 }">[다음]</a>
				</c:if>
			</th>
		</tr>
		
		
		<%--페이징끝  --%>
	
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글쓰기" onclick="location='/controller/board/board_write';">
				<%-- 자바스크립트 location 객체에 의해서 이동하는 것은 get --%>
			</td>
		</tr>
	</table>
 <script type="text/javascript">
   $msg = "${msg}";//자바스크립트에서 JSP문법인 el(표현언어) 또는 jstl사용가능. BoardController.java스프링
   //컨트롤러에서 msg키이름에 저장된 success문자를 EL로 가져온다.
   
   alert($msg);
   
   if($msg == 'success'){
	 alert('게시물 처리가 완료 되었습니다!');   
   }
 </script>
</body>
</html>