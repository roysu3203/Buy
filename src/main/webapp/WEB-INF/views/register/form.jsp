<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Buy - 註冊</title>
</head>

<body>
    <div class="row-fluid">
    	<div class="span4 offset4">
			<form:form class="form-signin" action="/Register/Save" method="POST" modelAttribute="registerFrom">
				<h2 class="form-signin-heading text-center">會員註冊</h2>
				<form:input path="account" class="input-block-level" placeholder="帳號" />
				<form:password path="password" class="input-block-level" placeholder="密碼" />
				<form:input path="name" class="input-block-level" placeholder="姓名" />
				<form:input path="email" class="input-block-level" placeholder="EMail" />
			
				<%-- 若驗證失敗, 顯示錯誤訊息 --%>
				<c:if test="${errorMessage != null}">
					<c:forEach var="message" items="${errorMessage}">
						<p class="text-center text-error">${message}</p>
					</c:forEach>
				</c:if>
				
				<input type="submit" class="btn btn-large btn-block btn-primary" value="送出">
			</form:form>
		</div>
	</div>
</body>
</html>