<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
<h1>Logout page</h1>

<form method="post" action="/customLogout">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 <%-- CSRF 토큰 처리 --%>
 <input type="submit" value="로그아웃" >
</form>
</body>
</html>