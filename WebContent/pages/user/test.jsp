<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<link type="text/css" rel="stylesheet" href="extraLogin.css" >
<script type="text/javascript">
function goLogin(){
	window.location.href="login.html";
}
function registerChack(){
	var username=document.getElementById("username").value;
	var passcode=document.getElementById("passcode").value;
	var repasscode=document.getElementById("repasscode").value;
	if(username="") alert("呵呵，你的用户名呢");
	if(repasscode!=passcode) alert("两次密码不一致，你是要用两个密码吗");
	else{
		alert("恭喜"+username+"注册成功");
		window.location.href="../../RegisterServlet?userName=lne&userPassword=lne";
	}
}
</script>
</head>
<body>
<div id="blank" style="margin-left:80px;margin-top:100px;">
文章发布管理系统
</div>
<div class="wrap" id="wrap" style="height:450px;">

	<div class="logGet">

			<!-- 头部提示信息 -->

			<div class="logD logDtip">

				<p class="p1">新用户注册</p>

			</div>

			<!-- 输入框 -->

			<div class="lgD">

				<img src="userName.jpg" width="20" height="20" alt=""/>

				<input type="text"

					placeholder="输入用户名" id="username"/>

			</div>

			<div class="lgD">

				<img src="code.png" width="20" height="20" alt=""/>

				<input type="password"

					placeholder="输入用户密码" id="passcode"/>

			</div>
			<div class="lgD">

				<img src="code.png" width="20" height="20" alt=""/>

				<input type="password"

					placeholder="重复输入密码" id="repasscode"/>

			</div>

			<div class="logC">

				<a onclick="registerChack()" target="_self" ><button>注册</button></a>

			</div>
			<a href="login.html" style="margin-left:80%;">立即登录</a>

		</div>

</div>
<div id="foot">

</div>
</body>
</html>