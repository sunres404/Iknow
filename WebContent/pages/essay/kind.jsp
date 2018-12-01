<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>分类</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<script type="text/javascript" src="onclick.js"></script>

</head>
<body >
<jsp:include page="/pages/include/head.jsp" flush="true" />
<div id="kind">
	<button type="button" id ="kind0" <c:if test="${sessionScope.kind == 0 }">class="on"</c:if> onclick="select('kind0')">C</button>
	<button type="button" id ="kind1" <c:if test="${sessionScope.kind == 1 }">class="on"</c:if> onclick="select('kind1')">C++</button>
	<button type="button" id ="kind2" <c:if test="${sessionScope.kind == 2 }">class="on"</c:if> onclick="select('kind2')">Java</button>
	<button type="button" id ="kind3" <c:if test="${sessionScope.kind == 3 }">class="on"</c:if> onclick="select('kind3')">Python</button>
	<button type="button" id ="kind4" <c:if test="${sessionScope.kind == 4 }">class="on"</c:if> onclick="select('kind4')">Android</button>
	<button type="button" id ="kind5" <c:if test="${sessionScope.kind == 5 }">class="on"</c:if> onclick="select('kind5')">Html</button>
	<button type="button" id ="kind6" <c:if test="${sessionScope.kind == 6 }">class="on"</c:if> onclick="select('kind6')">SQL</button>
</div>
<div id="otherkind">
	<button type="button" id="otherkind0" <c:if test="${sessionScope.order == 0 }">class="on"</c:if> onclick="selectother('otherkind0')">发布日期</button>
	<button type="button" id="otherkind1" <c:if test="${sessionScope.order == 1 }">class="on"</c:if> onclick="selectother('otherkind1')">文章热度↑</button>
	<button type="button" id="otherkind2" <c:if test="${sessionScope.order == 2 }">class="on"</c:if> onclick="selectother('otherkind2')">文章字数↑</button>
	<button type="button" id="otherkind3" <c:if test="${sessionScope.order == 3 }">class="on"</c:if> onclick="selectother('otherkind3')">随机☈</button>
</div>
<c:choose>
		<c:when test="${not empty sessionScope.page }">
			<c:choose>
				<c:when test="${not empty sessionScope.page.essaies }">
					<c:forEach var="essay" items="${sessionScope.page.essaies }">
						<div id="book">
							<div>
								<a id="title" href="${pageContext.request.contextPath }/EssayServlet?id=${essay.id}">${essay.essayName }</a>
								<a id="content" href="${pageContext.request.contextPath }/EssayServlet?id=${essay.id}">${essay.essayContent }</a>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					文章为空
				</c:otherwise>
			</c:choose>
			<div id="uldiv">
				<ul class="pagination">
					<li><a href="${pageContext.request.contextPath }/KindServlet?kind=1&nowPage=${page.nowPage - 1}&order=2" onclick="formPage()">«</a></li>
					<li><a class="page active" href="" onclick="page(this)">${page.nowPage}</a></li>
					<li><a href="${pageContext.request.contextPath }/KindServlet?kind=1&nowPage=${page.nowPage + 1}&order=2" onclick="nextPage()">»</a></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			没有返回页码
		</c:otherwise>
</c:choose>


<div id="uldiv">
	<ul class="pagination">
 	<li><a href="#" onclick="formPage()">«</a></li>
 	<li><a class="page active" href="#" onclick="page(this)">1</a></li>
	<li><a class="page" href="#" onclick="page(this)">2</a></li>
    <li><a class="page" href="#" onclick="page(this)">3</a></li>
  	<li><a class="page" href="#" onclick="page(this)">4</a></li>
  	<li><a class="page" href="#" onclick="page(this)">5</a></li>
  	<li><a class="page" href="#" onclick="page(this)">6</a></li>
  	<li><a class="page" href="#" onclick="page(this)">7</a></li>
  	<li><a href="#" onclick="nextPage()">»</a></li>
	</ul>
</div>
</body>
</html>