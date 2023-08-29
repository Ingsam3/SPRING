<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery.js"></script>
<link href="${path}/resources/css/main.css" rel="stylesheet"/>
<link href="${path}/resources/css/service.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<h1 id="board_name">고객센터</h1>

<div id="sub_menu">
 <ul>
  <li><h2><a href="${path}/service/service_center">고객센터</a></h2></li>
  <li><h2><a href="${path}/service/service_qna">자주 묻는 질문</a></h2></li>
  <li><h2><a href="${path}/service/service_notice">공지사항</a></h2></li>
 </ul>
</div>


<main>
    <form method="post" action="reg">
        <div class="qna_write">
            <table class="qna_write-table">
		    <caption class="main title">1:1문의 등록</caption>
                <tbody>
                    <tr>
                        <th>제목</th>
                        <td class="qna" colspan="3">
                            <input type="text" name="qna-title" />
                        </td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td class="qna" colspan="3">
                        <input type="file" name="file" /> </td>
                    </tr>
                    <tr class="qna-content">
                        <td colspan="4"><textarea class="qna-content" name="qna-content"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="4" class="qna-lock">
                        <input class="qna-lock" type="checkbox" id="open" name="open" value="true">
                        <label for="open" class="margin-left">비밀글</label></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="qna-write-btns">
            <input class="btn-write-ok" type="submit" value="등록" />
            <a class="btn-write-cancel" href="list.html">취소</a>
        </div>
    </form>
</main>
  

<jsp:include page="../include/footer.jsp"/>
</body>
</html>