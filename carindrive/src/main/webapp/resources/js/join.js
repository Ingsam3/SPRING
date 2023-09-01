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
	
	  let user_hp_type = $('#user_hp_type').val();

      if(!user_hp_type){
          alert("선택된 항목이 없습니다.");
          $('#user_hp_type').focus();
          return false;
      }
	
      if($.trim($("#m_phone").val())== ""){
		  alert("휴대폰번호를 입력하세요!");
		  $("#m_phone").val("").focus();
		  return false;
	  }
	  
}

//아이디 중복 체크
function checkid(){
	
}