/*
login.jsp
*/


function loginCk(){

	
	if($.trim($("#m_id").val()) ==""){
		alert("아이디를 입력하세요!");
		$("#m_id").val("").focus();
		return false;
	}
	if($.trim($("#g_pwd").val()) ==""){
		alert("비밀번호를 입력하세요!");
		$("#g_pwd").val("").focus();
		return false;
	}
	/*
	
	$("#m_pwd").click(function(){//아이디 빈 상태에서 비밀번호 누르면 글자 출력
	if($.trim($("#m_id").val()) ==""){
		$("#nonetxt").html("<b style='color:red; font-size :10px; text-align: left;'>아이디가 입력되지 않았습니다</b>");
		$("#m_id").val("").focus();
		return false;
	}
	
	if($.trim($("#m_id").val()) !=""){ //아이디 입력되면 삭제
		$("#nonetxt").hide();
		return false;
	}
		});	
	 */

	
	
	
}
