<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기식 아작스 파일첨부 연습</title>
<script type="text/javascript" src="./resources/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ //$ = jQuery
		
		$('#uploadBtn').on('click',function(e){
			
			var formData = new FormData(); // 폼데이터 객체 생성
			/*
			첨부파일을 업로드 하는 또 다른 방식은 jQuery 비동기식 아작스를 이용해서 폼데이터 객체를 이용하는 것이다
			이방식은 IE 10버전 이후에서만 지원된다. 폼데이터를 사용하려면 웹브라우저 제약이 발생한다.
			*/
			var inputFile = $("input[name='uploadFile']");//id, 선택자 방법이 있고 현재는 name 파라미터 이름으로 input type='file'에 접근하는 방식
			
			var files = inputFile[0].files; //첫번째 input type='file'로 첨부한 파일을 배열로 구한다
			 //첨부 파일을 폼데이터에 추가
			 
			 for(var i =0 ; i <files.length; i++){
				 formData.append('uploadFile',files[i]);
				 
			 }//for
			
			 $.ajax({
				url:'/controller/uploadAjaxAction',//서버 매핑주소
				processData:false,//컨텐트 타입에 맞게 반환여부 
				contentType:false, // 요청 컨텐트 타입
				data:formData, // 폼데이터 객체를 전송
				type:'POST',//보내는 방식
				success:function(result){
					//비동기식으로 받아오는 성공시 호출되는 콜백함수
					
				}
				 
				 
			 });//AJAX
		});//on
	});//ready


</script>
</head>
<body>
	<h1>Upload whit Ajax</h1>
	<input type="file" name="uploadFile" multiple>
	<%--multiple: 하나의 input 로 다중 첨부 파일을 동시에 서버로 업로드 할 수 있다 --%>
	<button type="button" id="uploadBtn">File Upload</button>
	
	
	
</body>
</html>