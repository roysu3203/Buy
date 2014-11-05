<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/Register/Save" method="POST" modelAttribute="registerFrom">
		<h2>註冊</h2>
		帳號：<form:input path="account" /><br>
		密碼：<form:password path="password" /><br>
		姓名：<form:input path="name" /><br>
		EMail：<form:input path="email" /><br>
		<input type="submit" value="送出">
	</form:form>
	
	<%-- 若驗證失敗, 顯示錯誤訊息 --%>
	<c:if test="${errorMessage != null}">
		<c:forEach var="message" items="${errorMessage}">
			<h3>${message}</h3>
		</c:forEach>
	</c:if>
</body>
</html>