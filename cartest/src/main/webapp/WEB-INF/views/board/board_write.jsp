<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 글쓰기 </title>
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
 <form method="post" onsubmit="return write_check();">
 <%-- action속성을 생략하면 이전 매핑주소인 board_write가 액션 매핑주소가 된다. 같은 컨트롤러 클래스 내에서 메서드가
 오버로딩이 된 경우는 동일 메서드명은 사용 가능하고, 같은 매핑주소도 사용가능하다. 
 동일 매핑주소 구분은 get or post 메서드 방식으로 구분한다. --%>
  <h2>스프링 MVC 게시판 입력폼</h2>
  글쓴이 : <input name="writer" id="writer" size="14"><br><br>
  <%-- input 태그에서 type속성을 생략하면 기본값으로 text이다. --%>
 글제목 : <input name="title" id="title" size="14" ><br><br>
  <%--input태그의 네임 피라미터 이름과 빈클래스 변수명은 반드시 같게 한다.이유는 그렇게 해야지만 스프링 컨트롤러에서
  BoardVO b라고만 해도 b객체에 글쓴이,글제목,글내용이 저장되어 있다. --%> 
 글내용 : <textarea name="content" id="content" rows="10" cols="36"></textarea>
 <hr>
  <input type="submit" value="글쓰기" >
  <input type="Reset" value="취소" onclick="$('#writer').focus();" >
  <input type="button" value="목록"
  onclick="location='/controller/board/board_list?page=${page}';" >
  <%-- 페이징에서 책갈피 기능을 구현하기 위해서 board_list?page=쪽번호를 get방식으로 전달하면 내가 본 페이지 번호로
  바로 이동한다. --%>
  
  <%--
    문제) 브라우저 주소창에 /board/board_write매핑주소를 get방식으로 실행해서 제대로 뷰페이지가 띄워지고 유효성 검증이
    되는 개발자 테스트과정(디버깅)을 해보자.
   --%>    
 </form>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>