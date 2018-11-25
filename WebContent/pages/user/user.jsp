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
<jsp:include page="/pages/include/head.jsp" flush="true" />
<c:choose>
	<c:when test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/pages/user/login.jsp">用户登陆</a>
	</c:when>
	<c:otherwise>
		用户名: ${sessionScope.user.userName }<br>
		密码： ${sessionScope.user.userPassword }<br>
		注册日期：${sessionScope.user.registerDate }<br>
		发布文章数量: ${sessionScope.uesr.essayCount }<br>
		浏览量： ${sessionScope.user.seeEssayCount }<br>
		<c:if test="${sessionScope.user.userKind == 1 }">
			管理员认证！<br>
		</c:if>
		
		所写文章信息：<br>
		<c:choose>
			<c:when test="${empty sessionScope.essaylist }">
				你没写任何文章
			</c:when>
			
			<c:otherwise>
				<c:forEach var="essay" items="${ sessionScope.essaylist }">
					${essay.essayName }<br>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<br>
	<a href="${pageContext.request.contextPath }/LogoutServlet">退出</a>
	</c:otherwise>
</c:choose>
</body>
</html>