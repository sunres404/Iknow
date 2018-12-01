<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>文章</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<script type="text/javascript">
function goWrite(){
	window.location.href="write.html";
}
</script>
</head>
<body>
<div id="blank">
文章发布系统
</div>
<div id="header">
	<div>
		<a href="${pageContext.request.contextPath }/MainServlet" id="vice">首页</a>
		<a href="${pageContext.request.contextPath }/pages/essay/kind.jsp" id="vice">分类</a>
		<a href="${pageContext.request.contextPath }/UserServlet" id="vice">我的</a>
	</div>
</div>
<div id="box">
	<form action="${pageContext.request.contextPath }/ResultServlet" method="post">
		<input type="text" name="essayName" placeholder="请输入关键字">
	    <button type="submit" id="search"  >搜索</button>
	</form>
</div>
</body>
</html>