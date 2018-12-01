<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>查询结果页</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<script type="text/javascript" src="onclick.js"></script>

</head>
<body>
<jsp:include page="/pages/include/head.jsp" flush="true" />
<div id="otherkind">
<a href="${pageContext.request.contextPath }/ResultServlet?essayName=${sessionScope.essayName}&order=0">
	<button type="button" <c:if test="${sessionScope.order == 0 }">class="on"</c:if> id="otherkind0" >发布日期</button>
</a><a href="${pageContext.request.contextPath }/ResultServlet?essayName=${sessionScope.essayName}&order=1">
	<button type="button" <c:if test="${sessionScope.order == 1 }">class="on"</c:if> id="otherkind1" >文章热度↑</button>
</a><a href="${pageContext.request.contextPath }/ResultServlet?essayName=${sessionScope.essayName}&order=2">
	<button type="button" <c:if test="${sessionScope.order == 2 }">class="on"</c:if> id="otherkind2" >文章字数↑</button>
</a><a href="${pageContext.request.contextPath }/ResultServlet?essayName=${sessionScope.essayName}&order=3">
	<button type="button" <c:if test="${sessionScope.order == 3 }">class="on"</c:if> id="otherkind3" >随机☈</button>
</a>
</div>

	<c:choose>
		<c:when test="${not empty sessionScope.page }">
			<c:choose>
				<c:when test="${not empty sessionScope.page.essaies }">
					<c:forEach var="essay" items="${sessionScope.page.essaies }">
						<div id="book">
							<div>
								<a id="title" href="${pageContext.request.contextPath }/EssayServlet?id=${essay.id}"> ${essay.essayName }</a>
								<a id="content" href="${pageContext.request.contextPath }/EssayServlet?id=${essay.id}">${essay.essayContent } </a>
							</div>
						</div>
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
			<div id="uldiv">
				<ul class="pagination">
				 	<li><a href="${pageContext.request.contextPath }/ResultServlet?essayName=${essayName }&nowPage=${page.nowPage - 1}">«</a></li>
				 	<li><a class="page active" href="#" onclick="page(this)">${page.nowPage }</a></li>
				  	<li><a href="${pageContext.request.contextPath }/ResultServlet?essayName=${essayName }&nowPage=${page.nowPage + 1}&order=2">»</a></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			没有返回页码
		</c:otherwise>
	</c:choose>
</body>
</html>