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

<c:choose>
	<c:when test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/pages/user/login.jsp">用户登陆</a>
	</c:when>
	<c:otherwise>
		用户名: ${sessionScope.user.userName }
		密码： ${sessionScope.user.userPassword }
	</c:otherwise>
</c:choose>
<br>
<a href="${pageContext.request.contextPath }/LogoutServlet">退出</a>
</body>
</html>