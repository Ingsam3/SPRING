<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기식 아작스 댓글연습</title>
<style type="text/css">
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute; /*절대위치지정*/
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000; /*속성이 absolute나 fixed 로 설정된 곳에서 사용한다
			이속성은 겹쳐지는 순서를 제어할 수 있다 숫자값이 큰 것이 먼저 앞에 나온다.*/
}
</style>
</head>
<body>
	<%--댓글 수정 화면 --%>
	<div id="modDiv" style="display: none;">
		<!-- 최초 실행시 댓글 수정화면을 안나오게 한다 -->
		<div class="modal-title"></div>
		<%--댓글번호 --%>
		<div>
			<textarea rows="3" cols="10" id="replytext"></textarea>
		</div>
		<div>
			<button id="replyModBtn">댓글 수정</button>
			<button id="replyDelBtn">댓글 삭제</button>
			<button id="colseBtn" onclick="modDivClose();">닫기</button>
		</div>
	</div>

	<h2>아작스 댓글 연습페이지</h2>
	<div>
		<div>
			댓글 작성자 : <input name="replyer" id="newReplyWriter">
		</div>
		<br>
		<div>
			댓글 내용 :
			<textarea rows="5" cols="30" name="replytext" id="newReplyText"></textarea>
		</div>
		<br>
		<button type="button" id="replyAddBtn">댓글 등록</button>
	</div>
	<br>
	<hr>
	<br>

	<%--댓글 목록 --%>
	<ul id="replies"></ul>

	<%--jQuery 라이브러리 읽어옴 --%>
	<script type="text/javascript" src="/controller/resources/js/jquery.js"></script>
	<script type="text/javascript">
			$bno =30; //게시판 번호를 임시적으로 할당한다.
			getAllList(); //댓글 목록 함수 호출
			function getAllList(){
				$.getJSON("/controller/replies/all/"+ $bno, function(data){
					/*get 방식으로 JSON 데이터를 처리하는 비동기식 jquery 아작스 함수로부터 가져온 
					데이터 목록은 data에 저장됨
					*/
					$result="";
					$(data).each(function(){//each 함수로 반복
						$result += "<li data-rno='"+this.rno+"' class='replyLi' >"
						+this.rno +": <span class='com' style='color:blue; font-wight:bolder;'>"
						+this.replytext +": </span> <button type='button'>댓글수정</button></li><br>";
					});
					$('#replies').html($result); // html() jquery 문자와 태그를 함께 반영  적용함.
				});

				
			}//getAllList()
			
			<%--댓글 추가 --%>
			$("#replyAddBtn").on("click",function(){
				var replyer = $("#newReplyWriter").val();//댓글 작성자
				var replytext = $("#newReplyText").val();//댓글내용
				$.ajax({
					type : 'post',
					url : '/controller/replies', //매핑주소
					headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST" //메서드 방식
				},
				dataType : 'text', //자료형 타입
				data : JSON.stringify({ //복수개 전달
					bno:$bno, //파라미터이름 : 값
					replyer:replyer,
					replytext:replytext //댓글내용
				}),
				success : function(result) {
				if (result == 'SUCCESS') { //비동기식으로 가져오는 것이 성공시 호출되는 콜백 함수, 받아온 자료는 result 매개변수에 저장
					alert(" 댓글이 등록 되었습니다."); 
					getAllList();//댓글목록 함수
				}
			}
		});//jQuery 비동기식 아작스
	});

			//댓글 수정화면
			$("#replies").on('click','.replyLi button',function(){
				var reply = $(this).parent(); // 부모인 li태그 구함
				var rno = reply.attr("data-rno"); //댓글 번호를 구함 => li태그의 댓글번호를 구함
				var replytext = reply.children('.com').text();// li 태그의 자식요소 중 클래스 선택자를 com구함
			
				
				$('.modal-title').html(rno); // 클래스 선택자 영역에 댓글번호를 변경적용
				$('#replytext').val(replytext);//textarea입력박스 영역에 댓글내용 표시
				$('#modDiv').show('slow');//댓글 수정화면을 천천히 보이게 함
					
			});
			
			//댓글 수정화면 닫기
			function modDivClose(){
				$('#modDiv').hide('slow');
			}
			//댓글수정 완료
			$('#replyModBtn').on('click',function(){
				$rno=$('.modal-title').html();//댓글번호
				$replytext = $('#replytext').val();//댓글 수정 내용
				
				$.ajax({
					type :'put',
					url :'/controller/replies/'+$rno,
					headers:{
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT" 
					},
					data : JSON.stringify({
						replytext: $replytext
						
					}),
					dataType :'text',
					success:function(result){
						if(result == 'SUCCESS'){
							alert('댓글이 수정되었습니다!');
							$('#modDiv').hide('slow');//댓글 수정화면을 닫고
							getAllList(); // 댓글 목록함수 호출
						}
					}
				});//ajax()
			});
			
			//댓글삭제
			$("#replyDelBtn").on("click",function(){
				var rno = $(".modal-title").html();//댓글번호
				$.ajax({
					type : 'delete',
					url : '/controller/replies/' +rno,//삭제 매핑 주소
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE" 
					},
					dataType : 'text',
					success : function(result) {
						if (result == 'SUCCESS') {
						alert("댓글이 삭제되었습니다"); 
						$("#modDiv").hide("slow");
						getAllList();
						}
					}
				});//ajax
			});

		</script>
</body>
</html>