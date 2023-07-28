<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script src="../resources/js/jquery.js"></script>
<script>
  function write_check(){
	  if($.trim($("#writer").val())== ""){
		  alert("글쓴이를 입력하세요!");
		  $("#writer").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#title").val())== ""){
		  alert("글제목을 입력하세요!");
		  $("#title").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#content").val())== ""){
		  alert("글내용을 입력하세요!");
		  $("#content").val("").focus();
		  return false;
	  }
  }
</script>
</head>
<body>
<form method="post" onsubmit="return write_check();">
 
  <h2>스프링 MVC 공지 입력폼</h2>
  공지작성자 : <input name="writer" id="writer" size="14"><br><br>
 
  공지제목 : <input name="title" id="title" size="14" ><br><br>
  
  공지내용 : <textarea name="content" id="content" rows="10" cols="36"></textarea>
 <hr>
  <input type="submit" value="공지작성" >
  <input type="Reset" value="취소" onclick="$('#writer').focus();" >
  <input type="button" value="목록" onclick="location='/controller/gongji/gongji_list?page=${page}';" >
 
 </form>

</body>
</html>