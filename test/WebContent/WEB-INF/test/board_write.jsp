<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1번 (board_write)</title>
</head>
<body>
<form method="post" onsubmit="return write_check();">
 
  <h2>사용자 입력폼</h2>
  이름 : <input name="name" id="name" size="14"><br><br>
  주소 : <input name="addr" id="addr" size="14" ><br><br>
 <hr>
  <input type="submit" value="글쓰기" >
  <input type="Reset" value="취소" onclick="$('#name').focus();" >
 </form>
</body>
</html>