<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文章内容页</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty sessionScope.essay }">
		<a href="${pageContext.request.contextPath }/WriteServlet?way=1&id=${sessionScope.essay.id }">修改此文章</a>
		${sessionScope.essay.essayName }<br>
		${sessionScope.essay.writerName }<br>
		${sessionScope.essay.essayContent }<br>
		${sessionScope.essay.issueDate }<br>
		${sessionScope.essay.lastChange }<br>
		${sessionScope.essay.otherInfo }<br>
		${sessionScope.essay.seeCount }<br>
	</c:when>
	<c:otherwise>
		没有获取到文章哦~
	</c:otherwise>
</c:choose>
</body>
</html>