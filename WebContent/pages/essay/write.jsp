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
	<form action="${pageContext.request.contextPath }/WriteServlet?way=2&id=${sessionScope.essay.id }&" method="post">
		id = ${sessionScope.essay.id }<br>
		标题<input type="text" name="essayName" value="${sessionScope.essay.essayName }"><br>
		作者<input type="text" name="writerName" value="${sessionScope.essay.writerName }"><br>
		内容<input type="text" name="essayContent" value="${sessionScope.essay.essayContent }"><br>
		发布日期<input type="text" name="issueDate" value="${sessionScope.essay.issueDate }"><br>
		最后修改<input type="text" name="lastChange" value="${sessionScope.essay.lastChange }"><br>
		其他信息<input type="text" name="otherInfo" value="${sessionScope.essay.otherInfo }"><br>
		被浏览量<input type="text" name="seeCount" value="${sessionScope.essay.seeCount }"><br>
		<input type="submit" value="确认提交">
	</form>
	</c:when>
	<c:otherwise>
		没有获取到文章哦~
	</c:otherwise>
</c:choose>
</body>
</html>