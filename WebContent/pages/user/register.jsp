<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	else if(repasscode!=passcode) alert("两次密码不一致，你是要用两个密码吗");
	if(username!=""&&repasscode!=""&&passcode!=""&&repasscode==passcode){
		alert("恭喜"+username+"注册成功");
		window.location.href="../../../src/servlet/RegisterServlet?userName=lne?userPassword=n";
	}
}
</script>
</head>
<body>
<jsp:include page="/pages/include/head.jsp" flush="true" />

<div class="wrap" id="wrap" style="height:450px;">
<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
	<div class="logGet">

			<!-- 头部提示信息 -->

			<div class="logD logDtip">

				<p class="p1">新用户注册</p>

			</div>

			<!-- 输入框 -->

			<div class="lgD">

				<img src="userName.jpg" width="20" height="20" alt=""/>

				<input type="text" name="userName"

					placeholder="输入用户名" id="username"/>

			</div>

			<div class="lgD">

				<img src="code.png" width="20" height="20" alt=""/>

				<input type="password"  name="userPassword"

					placeholder="输入用户密码" id="passcode"/>

			</div>
			<div class="lgD">

				<img src="code.png" width="20" height="20" alt=""/>

				<input type="password"

					placeholder="重复输入密码" id="repasscode"/>

			</div>

			<div class="logC">

				<a onclick="registerChack()" target="_self"  type="submit" ><button>注册</button></a>

			</div>
			<a href="${pageContext.request.contextPath }/pages/user/login.jsp" style="margin-left:80%;">立即登录</a>

		</div>
</form>
</div>
<div id="foot">

</div>
</body>
</html>
