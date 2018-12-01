<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>写文章</title>
<link type="text/css" rel="stylesheet" href="style.css" >
<script type="text/javascript">

function select(kind){
	
	for(var i=1;i<=7;i++){
		var str=document.getElementById('kind'+i);
		if(str!=document.getElementById(kind)){
			str.style.backgroundColor='#c0c0c0';
		}else{
			document.getElementById(kind).style.backgroundColor='#595959';
		}
		
	}
}
function selectother(otherkind){
	
	for(var i=1;i<=4;i++){
		var str=document.getElementById('otherkind'+i);
		if(str!=document.getElementById(otherkind)){
			str.style.backgroundColor='#c0c0c0';
		}else{
			document.getElementById(otherkind).style.backgroundColor='#595959';
		}
		
	}
}


</script>
</head>
<body>
<jsp:include page="/pages/include/head.jsp" flush="true" />
<c:choose>
	<c:when test="${not empty sessionScope.writeEssay }">
		<form action="${pageContext.request.contextPath }/WriteServlet?way=3&id=${sessionScope.writeEssay.id }&" method="post">
			<div id="user">
					<p>题目：</p>
					<input type="text" name="essayName" placeholder="${sessionScope.writeEssay.essayName }">
				</div>
				<div id="kind">
					<input type="radio" <c:if test="${writeEssay.essayKind == 0 }">checked</c:if> name="essayKind" value="0">C&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 1 }">checked</c:if> name="essayKind" value="1">C++&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 2 }">checked</c:if> name="essayKind" value="2">Java&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 3 }">checked</c:if> name="essayKind" value="3">Python&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 4 }">checked</c:if> name="essayKind" value="4">Android&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 5 }">checked</c:if> name="essayKind" value="5">Html&nbsp;&nbsp;
					<input type="radio" <c:if test="${writeEssay.essayKind == 6 }">checked</c:if> name="essayKind" value="6">SQL
				</div>
				<div id="label">
					<p>
						正文：
					</p>
				</div>
				<div id="artical">
					<textarea rows="3" cols="20" name="essayContent">
						${sessionScope.writeEssay.essayContent }
					</textarea>
				</div>
				<div id="label">
					<p>
						附加信息：
					</p>
				</div>
				<div id="extramessage">
					<textarea rows="3" cols="20" name="otherInfo">
						${sessionScope.writeEssay.otherInfo }
					</textarea>
				</div>
				<div id="user_button">	
					<input type="submit" value="确认提交">
				</div>	
		</form>
	</c:when>
	<c:otherwise>
		<form action="${pageContext.request.contextPath }/WriteServlet?way=2&" method="post">
			<div id="user">
					<p>题目：</p>
					<input type="text" name="essayName" placeholder="">
				</div>
				<div id="kind">
					<input type="radio" name="essayKind" value="0">C&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="1">C++&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="2">Java&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="3">Python&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="4">Android&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="5">Html&nbsp;&nbsp;
					<input type="radio" name="essayKind" value="6">SQL
				</div>
				<div id="label">
					<p>
						正文：
					</p>
				</div>
				<div id="artical">
					<textarea rows="3" cols="20"  name="essayContent"></textarea>
				</div>
				<div id="label">
					<p>
						附加信息：
					</p>
				</div>
				<div id="extramessage">
					<textarea rows="3" cols="20"  name="otherInfo"></textarea>
				</div>
				<div id="user_button">	
					<input type="submit" value="确认提交">
				</div>	
		</form>
	</c:otherwise>
</c:choose>


</body>
</html>