<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 수정폼 </title>
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
 <form method="post" action="board_edit_ok" onsubmit="return write_check();">
	<!-- action 속성 생성함 이전과 다름 -->
	<input type="hidden" name="bno" value="${eb.bno}">
	<input type="hidden" name="page" value="${page}">
	<!-- 페이징에서 책갈피 기능 때문에 쪽번호 전달 -->
  <h2>스프링 MVC 게시판 수정폼</h2>
	  글쓴이 : <input name="writer" id="writer" size="14" value="${eb.writer}"><br><br>
	  
	 글제목 : <input name="title" id="title" size="14" value="${eb.title}"> <br><br>
	 
	 글내용 : <textarea name="content" id="content" rows="10" cols="36" >${eb.content}</textarea>
	 <hr>
	 <input type="submit" value="글수정" >
	 <input type="Reset" value="취소" onclick="$('#writer').focus();" >
	 <input type="button" value="목록" onclick="location='/controller/board/board_list?page=${page}';" >
 </form>
</body>
</html>