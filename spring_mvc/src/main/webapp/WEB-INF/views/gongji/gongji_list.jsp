<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL 코어 태그립 추가 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 공지 목록</title>
<script src="../resources/js/jquery.js"></script>
</head>
<body>
<table border="1">
 <tr>
  <th colspan="5">스프링 MVC 공지 목록</th>
 </tr>
 <TR>
  <td colspan="5" align="right">
  <span style="font-weight: bolder;">총 게시물수 : ${totalCount}개</span></td>
 </TR>
 <tr>
  <th>번호</th> <th>제목</th> <th>글쓴이</th> <th>조회수</th> <th>등록날짜</th>
 </tr>
 <c:if test="${!empty glist}"> <%--목록이 있는 경우 실행 --%>
  <c:forEach var="g" items="${glist}">
  <tr>
   <th>${g.gongji_no}</th>
   <th>
    <a href="/controller/gongji/gongji_cont?gno=${g.gongji_no}&page=${page}">${g.gongji_title}</a>
    <%-- gongji_cont?gno=번호값&page=쪽번호 get방식으로 gno에 번호,page에 쪽번호 2개의 피라미터 값이 전달됨.
    특히  쪽번호를 get으로 전달하는 이유는 책갈피 기능 구현 때문이다. --%>
   </th>   
   <th>${g.gongji_name}</th>
   <th>${g.gongji_hit}</th>
   <th>${fn:substring(g.gongji_date,0,10)}</th><%-- 0이상 10미만 사이의 년월일 만 표현 --%>
  </tr>
  </c:forEach>
 </c:if>
 <c:if test="${empty glist}">
  <tr>
   <th colspan="5">공지 목록이 없습니다.</th>
  </tr>
 </c:if>
 
 <%--페이징 (쪽나누기) 시작--%>
 <tr>
  <th colspan="5">
   <c:if test="${page <= 1}">
    [이전]&nbsp; <%-- &nbsp;은 한칸의 빈공백 처리 --%>
   </c:if>
   <c:if test="${page > 1}">
     <a href="/controller/gongji/gongji_list?page=${page-1}">[이전]</a>&nbsp;
   </c:if>
   
   <%--쪽번호 출력 부분 --%>
   <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
     <c:if test="${a == page}"> <%--현재 쪽번호가 선택된 경우 --%>
      <${a}>
     </c:if>
     <c:if test="${a != page}"> <%-- 현재 쪽번호가 선택 안된 경우 --%>
     <a href="/controller/gongji/gongji_list?page=${a}">[${a}]</a>&nbsp;
     <%-- guest_list?page=쪽번호가 웹주소창에 노출되는 get방식으로 전달된다. --%>
     </c:if>
   </c:forEach>
   
   <c:if test="${page >= maxpage}">
    [다음]
   </c:if>
   <c:if test="${page < maxpage}">
    <a href="/controller/gongji/gongji_list?page=${page+1}">[다음]</a>
   </c:if>
  </th>
 </tr>
 <%-- 페이징 끝 --%>
 
 <tr>
  <td colspan="5" align="right">
   <input type="button" value="글쓰기" onclick=
	   "location='/controller/gongji/gongji_insert?page=${page}';" >
	   <%--자바스크립트 location객체에 의해서 이동하는 것은 get방식이다. 페이징에서 내가 본 쪽번호로 바로 이동하는
	   책갈피 기능을 구현하기 위해서 gongji_insert?page=쪽번호 get방식으로 전달한다.--%>
  </td>
 </tr>
</table> 
</body>
</html>