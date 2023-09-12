/*join.js */
function joinCheck(){
	  if($.trim($("#m_id").val())== ""){
		  alert("아이디를 입력하세요!");
		  $("#m_id").val("").focus();
		  return false;
	  }
	  
	  //아이디 정규식 체크
 		let checkid = /^[a-zA-Z\d]{4,100}$/;
	  
	  if(!checkid.test(m_id.value)){
		  alert("아이디는 영문자+숫자 조합 \n 4이상~16자리 이하로만 사용해야합니다. ");
		  $("#m_id").val("").focus();
		  return false;
	  }
	  
	  if($.trim($("#m_pwd").val())== ""){
		  alert("비밀번호를 입력하세요!");
		  $("#m_pwd").val("").focus();
		  return false;
	  }
	  if($.trim($("#pwd_ck").val())== ""){
		  alert("비밀번호를 입력하세요!");
		  $("#pwd_ck").val("").focus();
		  return false;
	  }
	  //비밀번호 정규식 체크
	  let checkpwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
	  
	  if(!checkpwd.test(pwd_ck.value)){
		  alert("비밀번호는 영문자+숫자+특수문자 조합 \n 8이상~12자리 이하로만 사용해야합니다. ");
		  $("#pwd_ck").val("").focus();
		  return false;
	  }
	  
	  //비밀번호 일치 테스트
	 if(m_pwd.value !== pwd_ck.value ){
		 alert("비밀번호가 일치하지 않습니다!");
		  $("#pwd_ck").val("").focus();
		  return false;
	 }
	  
	  
	  if($.trim($("#m_name").val())== ""){
		  alert("이름을 입력하세요!");
		  $("#m_name").val("").focus();
		  return false;
	  }
	  if($.trim($("#m_birth").val())== ""){
		  alert("생년월일 8자리를 입력하세요!");
		  $("#m_birth").val("").focus();
		  return false;
	  }
	  if($.trim($("#m_email").val())== ""){
		  alert("이메일을 입력하세요!");
		  $("#m_email").val("").focus();
		  return false;
	  }
	  
	  if(!m_email_se){
          alert("이메일 선택된 항목이 없습니다.");
          $('#m_email_se').focus();
          return false;
      }
	 
	
	  let m_tel = $('#m_tel').val();

      if(!m_tel){
          alert("선택된 항목이 없습니다.");
          $('#m_tel').focus();
          return false;
      }
	
      if($.trim($("#m_phone").val())== ""){
		  alert("휴대폰번호를 입력하세요!");
		  $("#m_phone").val("").focus();
		  return false;
	  }
	  
}

//아이디 중복 체크
//중복아이디 검색
function id_check(){
 /* copy begin */
   $("#idcheck").hide();
   //아이디 영역을 숨김
   $m_id=$.trim($("#m_id").val());
   //1.입력글자 길이 체크
   if($m_id.length < 4){
      $newtext='<font color="red" size="3"><b>아이디는 4자 이상이어야 합니다.</b></font>';
      $("#idcheck").text('');
      //idcheck 아이디 영역 문자열을 초기화
      $("#idcheck").show();
      //idcheck 아이디 영역을 보이게 함.
      $("#idcheck").append($newtext);
      //idcheck영역에 문자열을 추가
      $("#m_id").val('').focus();
      return false;
   };
   if($m_id.length > 12){
      $newtext='<font color="red" size="3"><b>아이디는12자 이하이어야 합니다.</b></font>';
      $("#idcheck").text('');
      //idcheck 아이디 영역 문자열을 초기화
      $("#idcheck").show();
      //idcheck 아이디 영역을 보이게 함.
      $("#idcheck").append($newtext);
      //idcheck영역에 문자열을 추가
      $("#m_id").val('').focus();
      return false;
   };
   /*2.입력글자 확인
   if(!(validate_userid($m_id))){
      $newtext='<font color="red" size="3"><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>';
      $("#idcheck").text('');
      $("#idcheck").show();
      $("#idcheck").append($newtext);
      $("#m_id").val('').focus();
      return false;
   };*/
   //아이디 중복확인
    $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
        type:"POST",//데이터를 서버로 보내는 방법
       //url:"./member/member_idcheck.jsp",    
        url:"member_idcheck", //url 패턴 매핑주소 경로
        data: {"id":$m_id},  //좌측 id 피라미터 이름에 우측 $m_id변수값을 저장
        datatype:"int",//서버의 실행된 결과값을 사용자로 받아오는 자료형
        success: function (data) {//success는 아작스로 받아오는것이 성공했을경우
           //서버 데이터를 data변수에 저장
           if(data==1){//중복 아이디가 있다면
            $newtext='<font color="#EB0000" size="3"><b>중복 아이디입니다.</b></font>';
            $("#idcheck").text('');
           $("#idcheck").show();
           $("#idcheck").append($newtext);                
             $("#m_id").val('').focus();
             return false;
        
           }else{//중복 아이디가 아니면
            $newtext='<font color="#1E90FF" size="3"><b>사용가능한 아이디입니다.</b></font>';
            $("#idcheck").text('');
            $("#idcheck").show();
            $("#idcheck").append($newtext);
            $("#m_pwd").focus();
           }              
        },
         error:function(){//비동기식 아작스로 서버디비 데이터를
            //못가져와서 에러가 발생했을 때 호출되는 함수이다.
            alert("data error");
         }
      });//$.ajax
 /* end */   
}