<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery.js"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
<link href="${path}/resources/css/rent.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<!-- 페이지 내용 -->

<!-- 예약 -->
<div class="mainmenu">
	<div id="menu01">
		<input type="checkbox" name="accordian" id="car01">
		<label for="car01">빌리는 날짜</label>
		<div><p><input type="date"></p></div>
	</div>
	<div id="menu02">
		<input type="checkbox" name="accordian" id="car02">
		<label for="car02">반납하는 날짜</label>
		<div><p><input type="date"></p></div>
	</div>
	<div id="menu03">
		<input type="checkbox" name="accordian" id="car03">
		<label for="car03">전체</label>
		<div>
			<p><a href="${path}/rent/rent">전체</a></p><br>
			<p><a href="${path}/rent/rent">경형</a></p><br>
			<p><a href="${path}/rent/rent">소형</a></p><br>
			<p><a href="${path}/rent/rent">중형(세단)</a></p><br>
			<p><a href="${path}/rent/rent">중형(SUV)</a></p><br>
			<p><a href="${path}/rent/rent">전기차</a></p><br>
		</div>
	</div>
	<div id="menu04">
		<input type="checkbox" name="accordian" id="car04">
		<label for="car04">대여시간</label>
		<div><p><input type="time">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;<input type="time"></p></div>
	</div>
	<div id="menu05">
		<a href="${path}/rent/rent"><img src="" alt="돋보기"></a>
	</div>
</div>

<br><br>

<jsp:include page="../include/footer.jsp"/>
</body>
</html>