<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">게시판 내용보기</th>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bc.title}</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>${bcont}</td><!-- 줄바꿈한 객체 가져옴 -->
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bc.viewcnt}</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="수정" 
				onclick="location='/controller/board/board_edit?bno=${bc.bno}&page=${page}';">
				<input type="button" value="삭제" 
				onclick="if(confirm('정말로 삭제?')==true){
				location='/controller/board/board_list?bno=${bc.bno}&page=${page}';}else{return;}" >
				<input type="button" value="목록" onclick="location='/controller/board/board_list?page=${page}';">
			</th>
			<!-- <td>${bc.viewcnt}</td> -->
		</tr>
	</table>
</body>
</html>