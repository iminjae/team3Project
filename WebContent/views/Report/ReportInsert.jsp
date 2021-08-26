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
<title>신고 작성</title>


</head>

<link rel="stylesheet" href="resources/css/report_css/reportInsert.css">

<body>
	<%@ include file="../common/menubar.jsp" %>


	<div class="Write_board">
        <br>
		<h1 align="center" class="Notice">신고 작성</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>
		
		<form action="<%= request.getContextPath()%>/ReportInsertServlet" method="post">
	        <table class="Write" border="1px">  
	            <tr>
	                <th>작성자</th>
	                <td><%=userId%></td>            
	               
	            </tr>
	             <tr>
	                <th>신고대상자</th>
	                <td colspan="3"><input type="text" name="reportNickName"></td>       
	               
	            </tr>
	            <tr>
	                <th>신고유형</th>
	                <td colspan="3"><input type="text" name="reportCategory"></td>
	            </tr>
	            <tr>
	                <th>신고 내용</th>
	                <td colspan="3"><input type="text" name="reportContent"></td>
	            </tr>
	           
	        </table>
	        
	        <br>
	         
			<div class="btn" align="center">
	        	<button type="submit" id="completion" >신고서 제출</button>
	        </div>
		</form>
    </div>
    
    
    
</body>
</html>