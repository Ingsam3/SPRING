<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
	<label for="car01">빌리는 날짜</label>
	<div><p><input type="date"></p></div>
</div>
<div  id="menu02">
	<input type="checkbox" name="accordian" id="car02">
	<label for="car02">반납하는 날짜</label>
	<div><p><input type="date"></p></div>
</div>
<div  id="menu03">
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
<div  id="menu04">
	<input type="checkbox" name="accordian" id="car04">
	<label for="car04">대여시간</label>
	<div><p><input type="time">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;<input type="time"></p></div>
</div>
</div>

<div class="clear"></div>

<br><br>
<%-- 차종 선택별 메뉴 --%>
<div class="tab_content">
	<input type="radio" name="tabmenu" id="tab01" checked>
	<label for="tab01">전체</label>
	<input type="radio" name="tabmenu" id="tab02">
	<label for="tab02">경형</label>
	<input type="radio" name="tabmenu" id="tab03">
	<label for="tab03">소형</label>
	<input type="radio" name="tabmenu" id="tab04">
	<label for="tab04">중형(세단)</label>
	<input type="radio" name="tabmenu" id="tab05">
	<label for="tab05">중형(SUV)</label>
	<input type="radio" name="tabmenu" id="tab06">
	<label for="tab06">전기차</label>
	
	<div class="conbox con1"> <!-- 전체 -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar01.png" >
							<br><br><br>
							<hr>
							<b>KIA 레이</b><br><br>
							경형 RV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar02.png" >
							<br><br><br>
							<hr>
							<b>KIA 모닝</b><br><br>
							경형 해치백 | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar03.JPG" >
							<br><br><br>
							<hr>
							<b>현대 캐스퍼</b><br><br>
							경형 SUV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Scar01.png" >
							<br><br><br>
							<hr>
							<b>미니 해치백</b><br><br>
							소형 해치백 | 가솔린 | 2024<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Scar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 코나</b><br><br>
							소형 SUV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar01.png" >
							<br><br><br>
							<hr>
							<b>기아 K5</b><br><br>
							중형 세단 | LPG, 가솔린 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 쏘나타</b><br><br>
							중형 세단 | LPG, 가솔린 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar03.png" >
							<br><br><br>
							<hr>
							<b>BMW 3 시리즈</b><br><br>
							중형 세단 | 가솔린, 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar04.JPG" >
							<br><br><br>
							<hr>
							<b>폭스바겐 아테온</b><br><br>
							중형 세단 | 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar05.png" >
							<br><br><br>
							<hr>
							<b>아우디 A4</b><br><br>
							중형 세단 | 가솔린, 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar06.png" >
							<br><br><br>
							<hr>
							<b>현대 싼타페 하이브리드</b><br><br>
							중형 SUV | 가솔린, 하이브리드 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar07.png" >
							<br><br><br>
							<hr>
							<b>KIA 쏘렌토</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar08.png" >
							<br><br><br>
							<hr>
							<b>제네시스 GV70</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar09.png" >
							<br><br><br>
							<hr>
							<b>BMW X3</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar10.png" >
							<br><br><br>
							<hr>
							<b>아우디 SQ5</b><br><br>
							중형 SUV | 가솔린 | 2021<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar01.JPG" >
							<br><br><br>
							<hr>
							<b>현대 코나 Electric</b><br><br>
							소형 SUV | 전기 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 아이오닉6</b><br><br>
							중형 세단 | 전기 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar03.png" >
							<br><br><br>
							<hr>
							<b>KIA 니로 EV</b><br><br>
							소형 SUV | 전기 | 2024<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="conbox con2"> <!-- 경형 -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar01.png" >
							<br><br><br>
							<hr>
							<b>KIA 레이</b><br><br>
							경형 RV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar02.png" >
							<br><br><br>
							<hr>
							<b>KIA 모닝</b><br><br>
							경형 해치백 | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Gcar03.JPG" >
							<br><br><br>
							<hr>
							<b>현대 캐스퍼</b><br><br>
							경형 SUV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="conbox con3"> <!-- 소형 -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Scar01.png" >
							<br><br><br>
							<hr>
							<b>미니 해치백</b><br><br>
							소형 해치백 | 가솔린 | 2024<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Scar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 코나</b><br><br>
							소형 SUV | 가솔린 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="conbox con4"> <!-- 중형(세단) -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar01.png" >
							<br><br><br>
							<hr>
							<b>기아 K5</b><br><br>
							중형 세단 | LPG, 가솔린 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 쏘나타</b><br><br>
							중형 세단 | LPG, 가솔린 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar03.png" >
							<br><br><br>
							<hr>
							<b>BMW 3 시리즈</b><br><br>
							중형 세단 | 가솔린, 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar04.JPG" >
							<br><br><br>
							<hr>
							<b>폭스바겐 아테온</b><br><br>
							중형 세단 | 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar05.png" >
							<br><br><br>
							<hr>
							<b>아우디 A4</b><br><br>
							중형 세단 | 가솔린, 디젤 | 2019<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="conbox con5"> <!-- 중형(SUV) -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar06.png" >
							<br><br><br>
							<hr>
							<b>현대 싼타페 하이브리드</b><br><br>
							중형 SUV | 가솔린, 하이브리드 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar07.png" >
							<br><br><br>
							<hr>
							<b>KIA 쏘렌토</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar08.png" >
							<br><br><br>
							<hr>
							<b>제네시스 GV70</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar09.png" >
							<br><br><br>
							<hr>
							<b>BMW X3</b><br><br>
							중형 SUV | 가솔린, 디젤 | 2022<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Jcar10.png" >
							<br><br><br>
							<hr>
							<b>아우디 SQ5</b><br><br>
							중형 SUV | 가솔린 | 2021<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="conbox con6"> <!-- 전기차 -->
		<table>
			<tr>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar01.JPG" >
							<br><br><br>
							<hr>
							<b>현대 코나 Electric</b><br><br>
							소형 SUV | 전기 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar02.JPG" >
							<br><br><br>
							<hr>
							<b>현대 아이오닉6</b><br><br>
							중형 세단 | 전기 | 2023<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
				<td>
					<div id="box01">
						<a href="${path}/rent/rentOK">
							<br><br><br>
							<img id="imgC" src="${path}/resources/images/car/Icar03.png" >
							<br><br><br>
							<hr>
							<b>KIA 니로 EV</b><br><br>
							소형 SUV | 전기 | 2024<br><br>
							<p>\100,000</p>
							<div id="box02">예 약 하 기</div>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>


<br>
<br>
<br>
<br>
<br>

<div class="clear"></div>


<jsp:include page="../include/footer.jsp"/>
</body>
</html>