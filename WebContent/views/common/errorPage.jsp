<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String message = (String)request.getAttribute("msg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#homebtn{
		background:rosybrown;
		color:white;
		height:40px;
	}
	h1{
		color:rosybrown;
	}
</style>
</head>
<body>
	<h1 align="center"><%=message %></h1>
	<div align = "center">
	
		<button id="homebtn" onclick = "location.href='<%= request.getContextPath() %>/views/common/index.jsp" style = "width:50%">홈으로 돌아가기</button>
	
	</div>
</body>
</html>