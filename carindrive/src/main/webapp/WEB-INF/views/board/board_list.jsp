<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 게시판 목록</title>
<script src="../resources/js/jquery.js"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<table border="1">
 <tr>
  <th colspan="5">스프링 MVC 게시판 목록</th>
 </tr>
 <TR>
  <td colspan="5" align="right">
  <span style="font-weight: bolder;">총 게시물수 : ${totalCount}개</span></td>
 </TR>
 <tr>
  <th>번호</th> <th>제목</th> <th>글쓴이</th> <th>조회수</th> <th>등록날짜</th>
 </tr>
 <c:if test="${!empty blist}"> <%--목록이 있는 경우 실행 --%>
  <c:forEach var="b" items="${blist}">
  <tr>
   <th>${b.bno}</th>
   <th>
    <a href="/controller/board/board_cont?bno=${b.bno}&page=${page}">${b.title}</a>
    <%-- board_cont?bno=번호값&page=쪽번호 get방식으로 bno에 번호,page에 쪽번호 2개의 피라미터 값이 전달됨.
    특히  쪽번호를 get으로 전달하는 이유는 책갈피 기능 구현 때문이다. --%>
    
    <c:if test="${b.replycnt != 0 }">	<%--댓글 개수가 있는 경우만 실행 --%>
     <strong>[댓글 개수 : ${b.replycnt}]</strong>
    </c:if>
   </th>
   <th>${b.writer}</th>
   <th>${b.viewcnt}</th>
   <th>${b.regdate}</th>
  </tr>
  </c:forEach>
 </c:if>
 <c:if test="${empty blist}">
  <tr>
   <th colspan="5">게시물 목록이 없습니다.</th>
  </tr>
 </c:if>
 
 <%--페이징 (쪽나누기) 시작--%>
 <tr>
  <th colspan="5">
   <c:if test="${page <= 1}">
    [이전]&nbsp; <%-- &nbsp;은 한칸의 빈공백 처리 --%>
   </c:if>
   <c:if test="${page > 1}">
     <a href="/controller/board/board_list?page=${page-1}">[이전]</a>&nbsp;
   </c:if>
   
   <%--쪽번호 출력 부분 --%>
   <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
     <c:if test="${a == page}"> <%--현재 쪽번호가 선택된 경우 --%>
      <${a}>
     </c:if>
     <c:if test="${a != page}"> <%-- 현재 쪽번호가 선택 안된 경우 --%>
     <a href="/controller/board/board_list?page=${a}">[${a}]</a>&nbsp;
     <%-- board_list?page=쪽번호가 웹주소창에 노출되는 get방식으로 전달된다. --%>
     </c:if>
   </c:forEach>
   
   <c:if test="${page >= maxpage}">
    [다음]
   </c:if>
   <c:if test="${page < maxpage}">
    <a href="/controller/board/board_list?page=${page+1}">[다음]</a>
   </c:if>
  </th>
 </tr>
 <%-- 문제) 게시판 목록 페이징 부분을 개발자 테스트 해보자. --%>
 <%-- 페이징 끝 --%>
 
 <tr>
  <td colspan="5" align="right">
   <input type="button" value="글쓰기" onclick=
	   "location='/controller/board/board_write?page=${page}';" >
	   <%--자바스크립트 location객체에 의해서 이동하는 것은 get방식이다. 페이징에서 내가 본 쪽번호로 바로 이동하는
	   책갈피 기능을 구현하기 위해서 board_write?page=쪽번호 get방식으로 전달한다.--%>
  </td>
 </tr>
</table>
 <script type="text/javascript">
   $msg = "${msg}";//자바스크립트에서 JSP문법인 el(표현언어) 또는 jstl사용가능. BoardController.java스프링
   //컨트롤러에서 msg키이름에 저장된 success문자를 EL로 가져온다.
   
   //alert($msg);
   
   if($msg == 'success'){
	 alert('게시물 처리가 완료 되었습니다!');   
   }
 </script>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>