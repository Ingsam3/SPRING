<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${path}/resources/js/jquery.js"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
<link href="${path}/resources/css/rent.css" rel="stylesheet"/>
</head>
<body>
  <jsp:include page="../include/header.jsp"/>
  
  <div class="clear"></div>

<%-- 예약 선택 메뉴 --%>
<div class="mainmenu">
<div id="menu01">
	<input type="checkbox" name="accordian" id="car01">
	<label for="car01">2023.07.17 | 09:00</label>
	<div><p><input type="date"></p></div>
</div>
<div  id="menu02">
	<input type="checkbox" name="accordian" id="car02">
	<label for="car02">2023.07.17 | 09:00</label>
	<div><p><input type="date"></p></div>
</div>
<div  id="menu03">
	<input type="checkbox" name="accordian" id="car03">
	<label for="car03">전체</label>
	<div>
		<p><a href="#">전체</a></p><br>
		<p><a href="#">경형</a></p><br>
		<p><a href="#">소형</a></p><br>
		<p><a href="#">중형(세단)</a></p><br>
		<p><a href="#">중형(SUV)</a></p><br>
		<p><a href="#">전기차</a></p><br>
	</div>
</div>
<div  id="menu04">
	<input type="checkbox" name="accordian" id="car04">
	<label for="car04">대여시간</label>
	<div><p><input type="time">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;<input type="time"></p></div>
</div>
</div>

<div class="clear"></div>

<div class="carname">
	<div><h1>KIA 레이</h1></div>
	<table border="1">
		<tr>
			<td>
				<img src="${path}/resources/images/car/Gcar01.png">
			</td>
			<td id="sub">
				<p>차량명 : 2023 KIA 레이</p>
				<hr>
				<p>차량정보 : 가솔린 | 경형 RV | 2023년</p>
				<hr>
				<p>비고 :<br>나<br>는<br>레<br>이<br>임<br></p>
				<p><a href="${path}/rent/rent">차량 다시 선택</a></p>
			</td>
		</tr>
	</table>
	
	<div><h3>차량 예약하기</h3></div>
	<table border="1"  id="carpay">
		<tr>
			<td><td>
		</tr>
	</table>
	<hr>
대여관련 안내사항
<br><br><br><br><br><br>
보험적용 불가사항
<br><br><br><br>
취소/환불안내
<br><br><br><br><br>
취소 및 환불규정
<br><br><br><br><br><br>
</div>



<div class="clear"></div>


<jsp:include page="../include/footer.jsp"/>
</body>
</html>