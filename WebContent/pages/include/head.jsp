<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>head</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/MainServlet">首页</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }/pages/essay/kind.jsp">分类</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }/pages/user/user.jsp">我的</a>&nbsp;&nbsp;&nbsp;
<form action="${pageContext.request.contextPath }/ResultServlet" method="post">
	<input type="text" name="essayName">
	<input type="submit" value="查询">
</form>
</body>
</html>