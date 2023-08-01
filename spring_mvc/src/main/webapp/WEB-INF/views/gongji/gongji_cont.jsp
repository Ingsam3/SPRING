<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
<table border="1">
 <tr>
  <th colspan="2">스프링 MVC 공지사항 내용보기</th>
 </tr>
 <tr>
  <th>공지제목</th>
  <td>${gc.gongji_title}</td>
 </tr>
 <tr>
  <th>글내용</th>
  <td>${gcont}</td>
 </tr>
 <tr>
  <th>조회수</th> 
  <td>${gc.gongji_hit}</td>
 </tr>
 <tr>
  <th colspan="2">
   <input type="button" value="공지수정" 
   onclick="location='/controller/gongji/gongji_update?gno=${gc.gongji_no}&page=${page}';">
   <input type="button" value="공지삭제"
   onclick="if(confirm('정말로 삭제할까요?') == true){
	   location='/controller/gongji/gongji_del?gno=${gc.gongji_no}&page=${page}';}else{return;}" >
	   <%--자바스크립트의 confirm()내장함수는 확인/취소 버튼을 가진 창을 만든다. 확인을 클릭하면 true를 반호나해서
	   삭제창으로 이동하고
	   취소를 클릭하면 false를 반환해서 현재창에 그대로 있게 한다.다시 한번더 삭제 유무를 묻게 한다.  --%>
   <input type="button" value="공지목록"
    onclick="location='/controller/gongji/gongji_list?page=${page}';" >	   
  </th>
 </tr>
</table>
</body>
</html>