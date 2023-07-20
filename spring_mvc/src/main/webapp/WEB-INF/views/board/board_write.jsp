<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 글쓰기</title>
<script src="../resource/js/jquery.js"></script>
<script>
	function write_check() {
		if($.trim($("#witer").val())==""){
			alert("글쓴이를 입력하세요");
			$("#writer").val("").focus();
			return false;
		}
		if($.trim($("#title").val())==""){
			alert("글제목를 입력하세요");
			$("#title").val("").focus();
			return false;
		}
		if($.trim($("#content").val())==""){
			alert("글내용 입력하세요");
			$("#content").val("").focus();
			return false;
		}
	}
</script>
</head>
<body>
<form method="post" onsubmit="return write_check();">
<%-- action 속성을 생략하면 이전 매핑 주소인board_write가 액션 매핑주소가 된다 --%>
<h2>게시판</h2>
글쓴이 : <input name ="writer" id="writer" size="14"><br><br>
글제목 : <input name ="title" id="title" size="14"><br><br>
글내용 : <textarea name="content" id="content" rows="10" cols="36"></textarea>
<hr>
<input type="submit"value="글쓰기">
<input type="reset"value="취소" onclick="$('#writer').focus();">
<%--파라미터이름과 빈클래스 변수명을 같게하면 BoardVo b 라고만 해도 b객체에 내용이 저장되어있음 --%>

</form>


</body>
</html>