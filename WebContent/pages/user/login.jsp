<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<link type="text/css" rel="stylesheet" href="extraLogin.css" >
<script type="text/javascript">
function goMain(){
	window.location.href="main.html";
}
function loginChack(){
	var username=document.getElementById("username").value;
	var passcode=document.getElementById("passcode").value;
	if(username==""){
		alert("用户名为空，你仿佛在逗我");
	}
else if(passcode==""){
		alert("密码为空，你丫账号不设密码的")
	}
}
</script>
</head>
<body>

<jsp:include page="/pages/include/head.jsp" flush="true" />
<div class="wrap" id="wrap" style="height:410px;">

<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
<div class="logGet">

			<!-- 头部提示信息 -->

			<div class="logD logDtip">

				<p class="p1">登录</p>

			</div>

			<!-- 输入框 -->
			

	

			<div class="lgD">

				<img src="userName.jpg" width="20" height="20" alt=""/>

				<input type="text" name="userName"

					placeholder="输入用户名" id="username"/>

			</div>

			<div class="lgD">

				<img src="code.png" width="20" height="20" alt=""/>

				<input type="password" name="userPassowrd"

					placeholder="输入用户密码" id="passcode"/>

			</div>

			<div class="logC">

				<a onclick="loginChack()" target="_self" type="submit"><button>登录</button></a>

			</div>
			<a href="${pageContext.request.contextPath }/pages/user/register.jsp" style="margin-left:80%;">注册</a>

		</div>
</form>
</div>


<div id="foot"></div>
</body>
</html>