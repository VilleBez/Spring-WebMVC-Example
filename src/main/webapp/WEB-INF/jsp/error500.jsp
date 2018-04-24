<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="kiben" content="no-cache">
<meta http-equiv="X-Content-Type-Options" content="nosniff">
<meta http-equiv="X-XSS-Protection" content="1">
<meta http-equiv="Strict-Transport-Security" content="max-age=31536000">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>Oops</title>
</head>
<body style="height: 350px;">
  <div id="warning">
    <div class="content">
      <h1><span>O</span>ops!</h1>
      <p>
        抱歉！<br/>
        <c:if test="${empty exception}">
        查無符合條件的資料，<br/>
        請輸入其他條件再試一次，<br/>
        </c:if>
        <c:if test="${not empty exception}">
        	<c:if test="${exception.getClass().name == 'javax.ws.rs.NotAuthorizedException'}">
        		Token 驗證失敗!!<br/>
        	</c:if>
        	<c:if test="${exception.getClass().name != 'javax.ws.rs.NotAuthorizedException'}">
        		內容無法呈現，<br/>
        	</c:if>
        
        請連絡相關人員 p.w.chen0627@gmail.com<br/>
        </c:if>
        謝謝<br/>
        
      </p>
    </div>
  </div>
	<!--
    Failed URL: ${url}
    Exception:  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>
  -->
  <script>
    parent.postMessage(document.body.scrollHeight, "*");
  </script>
</body>
</html>
