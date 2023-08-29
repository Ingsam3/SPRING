<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보험 안내</title>
<link rel="stylesheet" href="${path}/resources/css/ins.css" />
</head>
<body>
<%-- include : main --%>
<jsp:include page="../include/header.jsp"/>

<div id="wrap">
	<div id="form_1">
		<div id="form_2">
			<div id="ment">렌트카 보험 안내</div>
			<hr>
			<img alt="자차 보험 안내 이미지" src="${path}/resources/images/insurance.PNG">
			<div id="ins_txt">
			<div id="oltext">
				<ol>
					<li>모든차량은 종합보험(대인, 대물, 자손)에 가입되어 있습니다<br>
						<span>대인 : 무제한 / 대물 : 2,000만원 / 자손 : 1,500만원</span></li>
					<li>차량손해(자차)보험은 이용자의 선택사항입니다.</li>
					<li>보험 보상과 관련하여 임대차 계약서 뒷면 약관에 기재된 내용을 숙지바랍니다.</li>
				</ol>
			</div>
				<div id="ins_txt2">
					<p class="red">&#8251; 교통법규</p>
					<ul>
						<li>차량 운전자는 교통법규를 준수하셔야 하며, 제반사항은 임차인의 책임입니다.</li>
						<li>사고의 경우 도로교통법 위반 시에는 보험보상의 일부 혜택을 받지 못할 수도 있습니다.</li>
					</ul>
					<p class="red">&#8251; 계약연장</p>
					<ul>
						<li>계약기간을 연장하여 사용코자 할 경우에는 사전에 동의를 받아야 합니다.</li>
						<li>사전 동의 없이 연장사용 중에 발생한 보험 및 차량 손해에 대해서는 보상이나 면책을 받지 못할 수 있습니다.</li>
					</ul>
				</div><!--ins_txt2 end  -->
				<p id="ptxt" class="red">&#8251; 다음의 경우는 보험처리 및 차량손해(자차) 면책처리가 불가능합니다.</p>
				<div id="bul1">
					<ol>
						<li>임차인의 고의로 인한 사고</li>
						<li>무면허 운전사고</li>
						<li>음주운전, 약물중독운전 사고 - 렌트카를 경기용이나 연습용, 테스트용으로 사용하던 중 발생한 사고</li>
						<li>임차인(임차인과 기록된 공동임차인 포함) 이외의 제3자가 렌트카를 사용하여 발생한 사고</li>
						<li>본인 부주의로 인한 차량도난사고</li>
						<li>정원초과로 인한 사고</li>
						<li>사고 후 당사 미보고 사고</li>
						<li>1사고 1건 초과 사고</li>
						<li>타이어펑크 및 타이어파손 비용, 사고 후 견인, 현장출동(배터리방전, 키분실 등)비용은 자차에 적용되지 않습니다.<br>(고객부담)</li>				
					</ol>
				</div><!-- bul1 end-->
				<p id="ptxt" class="red">&#8251; 12대 중과실 항목 위반시에도 면책처리 불가능합니다.</p>
				<div id="bul2">
					<ol>
						<li>신호 및 지시 위반</li>
						<li>중앙선침범, 불법유턴</li>
						<li>제한속도보다 20KM이상 과속</li>
						<li>앞지르기 방법 위반</li>
						<li>철길건널목 통과방법위반</li>
						<li>횡단보도사고</li>
						<li>무면허운전</li>
						<li>음주운전</li>
						<li>보도 침범 및 보도 횡단방법 위반</li>
						<li>승객추락방지 의무 위반</li>
						<li>어린이보호구역 안전운전 의무 위반</li>
						<li>자동차 화물이 떨어지지 않도록 필요한 조치를 하지 않고 운전</li>
					</ol>
				</div><!-- bul2 end-->
			</div><!-- ins_txt end -->
		</div><!-- form2 end -->
	</div><!-- form1 end -->
</div><!-- wrap end -->

<%-- include : footer --%>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>