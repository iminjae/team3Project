<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.team3.member.model.vo.Member"%>
    
<%
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/Notice_css/Notice_BoardInsert.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>


	<div class="Write_board">
        <br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>
		
		<form action="<%= request.getContextPath()%>/insert.io" method="post">
	        <table class="Write" border="1px">  
	            <tr>
	                <th>작성자</th>
	                <td><%=userId%></td>            
	               
	            </tr>
	            <tr>
	                <th>제목</th>
	                <td colspan="3"><input type="text" name="title"></td>
	            </tr>
	            <tr>
	                <th>내용</th>
	                <td colspan="3"><input type="text" name="content"></td>
	            </tr>
	            <tr>
	                <th>첨부파일</th>
	                <td colspan="3"><input type="text" name="attachments"></td>
	            </tr>
	        </table>
	        
	        <br>
	         
			<div class="btn" align="center">
	        	<button type="submit" id="completion" >등록</button>
	        </div>
		</form>
    </div>
</body>
</html>