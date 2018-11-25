<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
	<jsp:include page="/pages/include/head.jsp" flush="true" />
	<form action="${pageContext.request.contextPath }/ResultServlet?essayName=算法" method="post">
				<input type="submit" value="搜索文章名为算法的文章">
	</form>
	<c:choose>
		<c:when test="${not empty sessionScope.page }">
			返回了页码
			当前页：${page.nowPage }<br>
			最大页：${page.maxPage }<br>
			<c:choose>
				<c:when test="${not empty sessionScope.page.essaies }">
					<c:forEach var="essay" items="${sessionScope.page.essaies }">
						id为---${essay.id}<br>
						标题为---${essay.essayName }<br>
						内容简略为---${essay.essayContent }<br>
						<br>---------------------------<br>
					</c:forEach>
				</c:when>
				<c:otherwise>
					文章为空
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			没有返回页码
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${not empty sessionScope.page }">
			当前页：${page.nowPage }<br>
			最大页：${page.maxPage }<br>
			<form action="${pageContext.request.contextPath }/ResultServlet?essayName=${essayName }&nowPage=${page.nowPage - 1}&order=2" method="post">
				<input type="submit" value="上一页">
			</form>
			<form action="${pageContext.request.contextPath }/ResultServlet?essayName=${essayName }&nowPage=${page.nowPage + 1}&order=2" method="post">
				<input type="submit" value="下一页">
			</form>
		</c:when>
		<c:otherwise>
			没有返回页码
		</c:otherwise>
</c:choose>
</body>
</html>