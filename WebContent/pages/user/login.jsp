<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		<input type="text" name="userName"><br>
		<c:if test="${! empty usererror }">
			用户名或密码有误！
		</c:if>
		<input type="text" name="userPassowrd"><br>
		<input type="submit" value="登陆">
	</form>
	<a href="${pageContext.request.contextPath }/pages/user/register.jsp">注册</a>
</body>
</html>