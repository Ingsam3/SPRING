<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/bbs.css" />
<script 
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <%--  CDN(Content Delivery Network의 약어) 방식으로 인터넷이 연결된 상태에서 온라인으로 jQuery라이브
 러리를 연결해서 사용하는 방식이다.로컬 pc로 jQuery라이브러리를 다운 받지 않고 사용가능하다. --%>
<script>
 function del_check(){
    if($.trim($("#del_pwd").val()) == ""){
       alert("삭제 비번을 입력하세요!");
       $("#del_pwd").val("").focus();
       return false;
    }
 }
</script>
</head>
<body>
   <div id="bsDel_wrap">
      <h2 class="bsDel_title">자료실 삭제</h2>
      <form method="post" action="bbs_del_ok?bbs_no=${b.bbs_no}" onsubmit="return del_check();">
      <%-- bbs_no는 get방식으로 전달되고, page와 del_pwd는 post방식으로 전달된다. --%>
          <input   type="hidden" name="page" value="${page}" />
         <table id="bsDel_t">
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="del_pwd" id="del_pwd"
                  size="14" /></td>
            </tr>
         </table>
         <div id="bsDel_menu">
            <input type="submit" value="삭제" /> <input type="reset" value="취소"
               onclick="$('#del_pwd').focus();" />
         </div>
      </form>
   </div>
</body>
</html>