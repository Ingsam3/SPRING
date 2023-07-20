<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 제목</title>
<script src="../resources/js/jquery.js"></script>
</head>
<body>
<script>
	$msg="${msg}"; 
	//자바스크립트 jsp문법인 EL 또는 jstl 사용가능 BoardController msg 에 저장된 suecces 문자를 가져옴
	alert(msg);
	if($msg == 'success'){
		alert('게시글 처리가 완료되었습니다');
	}
</script>

</body>
</html>