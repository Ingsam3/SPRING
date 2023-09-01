/**
m_login.js
 */
 
 
 //유효성 체크
  function logCk(){
	
	if($.trim($("#m_id").val()) ==""){
		alert("아이디를 입력하세요!");
		$("#m_id").val("").focus();
		return false;
	}
	if($.trim($("#m_pwd").val()) ==""){
		alert("비밀번호를 입력하세요!");
		$("#m_pwd").val("").focus();
		return false;
	}
	var checkbox = document.getElementById('checkbox');
        if(checkbox.checked == false) {
            alert("로그인 상태 유지 여부를 선택하세요!")
            return false;
        }
}

//아이디 유무 체크

//비밀번호 유무 체크
