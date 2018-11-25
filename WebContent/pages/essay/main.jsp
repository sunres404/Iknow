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
	<c:choose>
		<c:when test="${not empty sessionScope.page }">
			返回了页码
			当前页：${page.nowPage }<br>
			最大页：${page.maxPage }<br>
			<c:choose>
				<c:when test="${not empty sessionScope.page.essaies }">
					<c:forEach var="essay" items="${sessionScope.page.essaies }">
						id为---${essay.id}<br>
						<a href="${pageContext.request.contextPath }/EssayServlet?id=${essay.id}">标题为---${essay.essayName }</a><br>
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
	<jsp:include page="/pages/include/bottom.jsp" flush="true" />
</body>
</html>