<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="/pages/include/head.jsp" flush="true" />
<c:choose>
	<c:when test="${not empty sessionScope.essay }">
		<div id="articaltitle">
			<span>${sessionScope.essay.essayName }</span>
			<textarea>
				${sessionScope.essay.essayContent }
			</textarea>
		</div>
		<div id="mymessage">
			<p style="margin-left:100px;font-size:20px;">文章信息</p>
			<p>题目：${sessionScope.essay.essayName }</p>
			<p>作者：${sessionScope.essay.writerName }</p>
			<p>所属编号：${sessionScope.essay.id }</p>
			<p>发布日期：${sessionScope.essay.issueDate }</p>
			<p>更新日期：${sessionScope.essay.lastChange }</p>
			<p>所属类别：${sessionScope.essay.essayKind }</p>
			<p>浏览量：${sessionScope.essay.seeCount }</p>
			<p>其他信息：${sessionScope.essay.otherInfo }</p>
			<c:if test="${sessionScope.user.userKind == 1 }">
				<a href="${pageContext.request.contextPath }/WriteServlet?way=1&id=${sessionScope.essay.id }"><img src="editor.png"/></a>
				<a href="${pageContext.request.contextPath }/WriteServlet?way=4&id=${sessionScope.essay.id }"><img src="delete.png"/></a>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		没有获取到文章哦~
	</c:otherwise>
</c:choose>

</body>
</html>