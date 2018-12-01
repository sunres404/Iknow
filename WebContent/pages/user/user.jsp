<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>用户界面</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<script type="text/javascript">


function doWrite(){
	window.location.href="../essay/write.jsp";
}

function goLogin(){
	window.location.href="login.jsp";
}
function goEssay(){
	window.location.href="essay.html";
}
</script>
</head>
<body>
<jsp:include page="/pages/include/head.jsp" flush="true" />
<c:choose>
	<c:when test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/pages/user/login.jsp">用户登陆</a>
	</c:when>
	<c:otherwise>
		<div id="mymessage">
			<p style="margin-left:100px;font-size:20px;">我的信息</p>
			<p>用户名：${sessionScope.user.userName }</p>
			<p>注册日期：${sessionScope.user.registerDate }</p>
			<p>发布文章数：${sessionScope.user.essayCount }</p>
			<p>浏览量： ${sessionScope.user.seeEssayCount }</p>
			<c:if test="${sessionScope.user.userKind == 1 }">
					<img src="success.png" style="width:120px;height:100px;margin-left:100px;margin-top:20px;"/>
			</c:if>
		</div>
		<div id="myartical">
			<p style="margin-left:100px;font-size:20px;">我的文章</p>
			
				所写文章信息：<br>
				<c:choose>
					<c:when test="${empty sessionScope.essaylist }">
						你没写任何文章
					</c:when>
					
					<c:otherwise>
						<c:forEach var="essay" items="${ sessionScope.essaylist }">
							<p>${essay.essayName }</p>
							<a href="${pageContext.request.contextPath }/WriteServlet?way=1&id=${essay.id }"><img src="editor.png"/></a>
							<a href="${pageContext.request.contextPath }/WriteServlet?way=4&id=${essay.id }"><img src="delete.png"/></a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		</div>
	</c:otherwise>
</c:choose>
<div id="mybutton">
	<img  src="submit.png" onclick="doWrite()" />
	<img src="quit.png" onclick="goLogin()"/>
</div>
</body>
</html>