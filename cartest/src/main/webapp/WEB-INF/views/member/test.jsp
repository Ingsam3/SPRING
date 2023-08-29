<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<c:out value="안녕하세요" />
<c:set var="test" value="안녕하세요"/>
<c:out value="${test }" /><br><hr>

<%
request.setAttribute("num1", 100);
request.setAttribute("num2", 100);
	
%>
${num1 } + ${num2 } = ${num1+num2}
num1+num2 = ${num1+num2} <br>

<hr>
<c:forEach var="a" begin="1" end="9" step="2"> 
${a}
</c:forEach><br>
<hr>

</body>
</html>