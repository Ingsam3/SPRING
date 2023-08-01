<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 이진파일 업로드</title>
</head>
<body>
<h1>스프링 MVC 이진파일 업로드</h1>
<form action="uploadFormAction" method="post" enctype="multipart/form-data">

<%-- 파일 첨부 기능인 자료실 기능 만들 때 주의사항
1. method =post 받기으로 해야함 => get은 파일 첨부 기능 X
2. form 태그 안에 enctype="multipart/form-data" 설정해야한다

 --%>

<input type="file" name="uploadFile" multiple>
<!-- 최근 브라우저에서는multiple 속성을 지원하는데 이를 사용하면 하나의 input type="file"로
다중 첨부 파일을 동시에 업로드 가능하다  -->
<input type="submit" value="파일 업로드">
</form>
</body>
</html>