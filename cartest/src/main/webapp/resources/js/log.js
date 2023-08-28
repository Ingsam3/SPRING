function logCk(){
	
	if($.trim($("#m_id").val()) ==""){
		alert("아이디를 입력하세요!");
		$("#m_id").val("").focus();
		return false;
	}
	if($.trim($("#m_pwd").val()) ==""){
		//alert("비밀번호를 입력하세요!");
		$("#m_pwd").val("").focus();
		return false;
	}
}