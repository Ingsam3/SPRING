<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>소셜로그인 예제</title>
</head>
<body>
<div>
    <p><a th:href="@{|${appleUrl}|}">애플로그인</a></p>
    <p><a th:href="@{|${kakaoUrl}|}">카카오로그인</a></p>
</div>
</body>
</html>