<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 방명록 글수정 </title>
<script src="../resources/js/jquery.js"></script>
<script>
  function write_check(){
	  if($.trim($("#gname").val())== ""){
		  alert("글쓴이를 입력하세요!");
		  $("#gname").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#gtitle").val())== ""){
		  alert("글제목을 입력하세요!");
		  $("#gtitle").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#gcont").val())== ""){
		  alert("글내용을 입력하세요!");
		  $("#gcont").val("").focus();
		  return false;
	  }
  }
</script>
</head>
<body>
 <form method="post" action="guest_edit_ok" onsubmit="return write_check();">
 <input type="hidden" name="gno" value="${eb.gno}" >
 <input type="hidden" name="page" value="${page}" >
 <%--페이징에서 책갈피 기능때문에 쪽번호 전달 --%>
  
 <h2>스프링 MVC 방명록 수정폼</h2>
  글쓴이 : <input name="gname" id="gname" size="14" value="${eb.gname}"><br><br>
  <%-- input 태그에서 type속성을 생략하면 기본값으로 text이다. --%>
 글제목 : <input name="gtitle" id="gtitle" size="14" value="${eb.gtitle}"><br><br>
  <%--input태그의 네임 피라미터 이름과 빈클래스 변수명은 반드시 같게 한다.이유는 그렇게 해야지만 스프링 컨트롤러에서
  GuestVO g라고만 해도 g객체에 글쓴이,글제목,글내용이 저장되어 있다. --%> 
 글내용 : <textarea name="gcont" id="gcont" rows="10" cols="36">${eb.gcont}</textarea>
 <hr>
  <input type="submit" value="글수정" >
  <input type="Reset" value="취소" onclick="$('#gname').focus();" >
  <input type="button" value="목록"
  onclick="location='/controller/guest/guest_list?page=${page}';" >
  <%-- 페이징에서 책갈피 기능을 구현하기 위해서 guest_list?page=쪽번호를 get방식으로 전달하면 내가 본 페이지 번호로
  바로 이동한다. --%>
 </form>
</body>
</html>