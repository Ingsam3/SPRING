<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 글수정 </title>
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
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
 <form method="post" action="board_edit_ok" onsubmit="return write_check();">
 <input type="hidden" name="bno" value="${eb.bno}" >
 <input type="hidden" name="page" value="${page}" >
 <%--페이징에서 책갈피 기능때문에 쪽번호 전달 --%>
  
 <h2>스프링 MVC 게시판 수정폼</h2>
  글쓴이 : <input name="writer" id="writer" size="14" value="${eb.writer}"><br><br>
  <%-- input 태그에서 type속성을 생략하면 기본값으로 text이다. --%>
 글제목 : <input name="title" id="title" size="14" value="${eb.title}"><br><br>
  <%--input태그의 네임 피라미터 이름과 빈클래스 변수명은 반드시 같게 한다.이유는 그렇게 해야지만 스프링 컨트롤러에서
  BoardVO b라고만 해도 b객체에 글쓴이,글제목,글내용이 저장되어 있다. --%> 
 글내용 : <textarea name="content" id="content" rows="10" cols="36">${eb.content}</textarea>
 <hr>
  <input type="submit" value="글수정" >
  <input type="Reset" value="취소" onclick="$('#writer').focus();" >
  <input type="button" value="목록"
  onclick="location='/controller/board/board_list?page=${page}';" >
  <%-- 페이징에서 책갈피 기능을 구현하기 위해서 board_list?page=쪽번호를 get방식으로 전달하면 내가 본 페이지 번호로
  바로 이동한다. --%>
 </form>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>