<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery.js"></script>
<link href="${path}/resources/css/guide.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="l-ct">
	<h1 class="guideTitle">1. 대여자격</h1>
	<table class="guideTable">
		<colgroup>
			<col width="33%">
			<col width="33%">
			<col width="33%">
		</colgroup>
		<thead>
			<tr>
				<th>승용차량</th>
				<th>SUV</th>
				<th>고급 및 승합</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<p>- 만 21세 이상</p>
					<p>- 2종 보통 이상 운전면허 소지자</p>
					<p>- 면허 취득일 1년 이상 경과</p>
					<p><span class="point">- (sm3 전기차, sm6, 소나타디엔8, 3세대 k5은 만 26세 경력 1년이상 )</span></p>
				</td>
				<td>
					<p>- 만 26세 이상, 경력 1년 이상</p>
					<p>- 2종 보통 이상 운전면허 소지자</p>
					<p>- 면허 취득일 1년 이상 경과</p>
				</td>
				<td>
					<p>- 만 26세 이상</p>
					<p>- 1종 보통 이상 운전면허 소지자</p>
					<p>- 면허 취득일 1년 이상 경과</p>
					<p>(단,9인승차량은 2종보통면허 소지가능)</p>
				</td>
			</tr>
		</tbody>
	</table><!-- .guideTable -->
	<h1 class="guideTitle">2. 유의사항</h1>
	<ul class="guideInfo">
		<li>
			<span class="infoSubject">운전면허증</span>
			<span class="infoContent">실제 운전하실 분의 운전면허증을 필히 지참하셔야 하며, <br>
			운전은 대당 최고 2명까지 운전가능하며 제2운전자 역시 운전 면허증을 지참하셔야 가능합니다.<br>(외국인일 경우 제네바, 비엔나 협약국에서 발행한 국제 운전 면허증과 여권 소지자)</span>
		</li>
		<li>
			<span class="infoSubject">종합보험</span>
			<span class="infoContent">대인, 대물, 자손에 가입되어 있으며, 자차보험은 선택사항입니다.</span>
		</li>
		<li>
			<span class="infoSubject">교통법규</span>
			<span class="infoContent">임차중 발생한 교통법규 위반에 관한사항은 임차인의 책임입니다.</span>
		</li>
		<li>
			<span class="infoSubject">기타사항</span>
			<span class="infoContent">차량 반납 시 연료부족분(차량인수 기준)은 고객님께서 지불하셔야 합니다.<br> 애완동물 동반탑승시 대여불가</span>
		</li>
	</ul><!-- .guideInfo -->
	<h1 class="guideTitle" id="step">3. 대여/반납 절차</h1>
	<div class="guideStep">
		<p class="stepSubject">렌터카 <span>대여</span> 절차</p>
		<ul>
			<li>
				<i class="used-icon-1"></i>
				<p>서울 종로구 도착후</p>
			</li>
			<li>
				<i class="used-icon-2"></i>
				<p>단성사 빌딩 5층</p>
			</li>
			<li>
				<i class="used-icon-4"></i>
				<p>약관설명 및 계약서 작성<br>차량인수</p>
			</li>
		</ul>
		<p class="stepSubject">렌터카 <span>반납</span> 절차</p>
		<ul>
			<li>
				<i class="used-icon-5"></i>
				<p>carindrive<br>(종로구 돈화문로26) 본사</p>
			</li>
			<li>
				<i class="used-icon-6"></i>
				<p>차량 외관 및 연료 확인 후<br>반납완료</p>
			</li>
		</ul>
		<p class="stepSubject">시간안내 : <span>인수(07:45~22:00), 반납 (06:50~20:00)</span> 그전 차량반납은 상담원 문의하시기 바랍니다.</p>
	</div>
	<h1 class="guideTitle">4. 환불/취소</h1>
	<font style="color: #ff0000; padding-bottom: 10px; display: inline-block;">★아래 취소수수료는 carindrive 홈페이지에서 예약 접수된 건에 한해서만 적용되며, 	예약 접수처에 따라서 취소 수수료가 상이할 수있으므로 <br>
 최초 에약 접수처(예약사이트)로문의 바랍니다.</font>
	<div class="guideRefund">
		<p class="subject">환불안내</p>
		<div class="equipment-content">
			<p>환불/변경 신청은 유선상(111-111-1111)으로만 가능합니다.</p>
			<p>환불규정은 기간에 따라 환불 요금이 변동될 수 있으며, 당사 업무시간 내 (주중/주말 09:00~18:00 ) 에 취소 및 변경을 하셔야 적용됩니다.</p>
			<p>천재지변에 의해 취소가 될 경우에는 취소 확인할 수 있는 확인서를 보내주셔야 취소 수수료 없이 환불이 가능합니다.</p>
			<p>개인 사정으로 인해 취소 할 경우 취소 수수료가 부과됩니다.</p>
		</div>
		<p class="subject">취소 및 환불규정</p>
		<div class="equipment-content" style="padding: 0px; border: 0px;display: grid">
			<ul>
				<li>예약 취소일</li>
				<li>취소 수수료</li>
			</ul>
			<ul>
				<li>인수일기준  2 ~ 3일전</li>
				<li>총 대여금의 20% 수수료부과</li>
			</ul>
			<ul>
				<li>인수일기준 1 ~ 당일</li>
				<li>총 대여금의 24시간 수수료부과</li>
			</ul>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>