<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 공지사항 수정폼 </title>
<script src="../resources/js/jquery.js"></script>
<script>
  function write_check(){
	  if($.trim($("#gongji_name").val())== ""){
		  alert("공지 작성자를 입력하세요!");
		  $("#gongji_name").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#gongji_title").val())== ""){
		  alert("공지제목을 입력하세요!");
		  $("#gongji_title").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#gongji_cont").val())== ""){
		  alert("공지내용을 입력하세요!");
		  $("#gongji_cont").val("").focus();
		  return false;
	  }
  }
</script>
</head>
<body>
 <form method="post" action="gongji_update_ok" onsubmit="return write_check();">
 <input type="hidden" name="gongji_no" value="${eb.gongji_no}" >
 <input type="hidden" name="page" value="${page}" >
 <%--페이징에서 책갈피 기능때문에 쪽번호 전달 --%>
 
  <h2>스프링 MVC 공지사항 수정폼</h2>
  공지작성자 : <input name="gongji_name" id="gongji_name" size="14" value="${eb.gongji_name}"><br><br>
  <%-- input 태그에서 type속성을 생략하면 기본값으로 text이다. --%>
 공지제목 : <input name="gongji_title" id="gongji_title" size="14" value="${eb.gongji_name}"><br><br>
  <%--input태그의 네임 피라미터 이름과 빈클래스 변수명은 반드시 같게 한다.이유는 그렇게 해야지만 스프링 컨트롤러에서
  GongjiVO g라고만 해도 g객체에 공지작성자,공지제목,공지내용이 저장되어 있다. --%> 
 공지내용 : <textarea name="gongji_cont" id="gongji_cont" rows="10" cols="36">${eb.gongji_cont}</textarea>
 <hr>
  <input type="submit" value="공지수정" >
  <input type="Reset" value="수정취소" onclick="$('#gongji_name').focus();" >
  <input type="button" value="목록"
  onclick="location='/controller/gongji/gongji_list?page=${page}';" >
  <%-- 페이징에서 책갈피 기능을 구현하기 위해서 gongji_list?page=쪽번호를 get방식으로 전달하면 내가 본 페이지 번호로
  바로 이동한다. --%>  
 </form>
</body>
</html>