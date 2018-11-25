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
		<c:when test="${not empty sessionScope.page }">
			当前页：${page.nowPage }<br>
			最大页：${page.maxPage }<br>
			<form action="${pageContext.request.contextPath }/MainServlet?nowPage=${page.nowPage - 1}" method="post">
				<input type="submit" value="上一页">
			</form>
			&nbsp;&nbsp;&nbsp;&nbsp;AAA
			<form action="${pageContext.request.contextPath }/MainServlet?nowPage=${page.nowPage + 1}" method="post">
				<input type="submit" value="下一页">
			</form>
		</c:when>
		<c:otherwise>
			没有返回页码
		</c:otherwise>
</c:choose>
</body>
</html>