<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--JSTL 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h1>
		<c:out value="${result} " />
	</h1>
	username : <c:out value="${username }" /><hr>
	address : <c:out value="${address }" /><hr>
	<a href="mybatis_jpa">이름과 주소 등록</a>
</body>
</html>