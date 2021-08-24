<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.kh.team3.Notice.model.vo.NoticeBoard" %>

<%
	NoticeBoard n = (NoticeBoard)request.getAttribute("NoticeBoard");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>


	<div class="board_DetailView">
		<br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>

        <table border="1" align="center">
	
			<tr>
				<td>제목</td>
				<td colspan="3"><%= n.getNoticeTitle() %></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%= n.getUser_id() %></td>
				<td>작성일</td>
				<td><%= n.getCreateDate() %></td>
			</tr>
			<tr>
				<td colspan="4">내용</td>
			
			</tr>
			<tr>
				<td colspan="4">
					<p><%= n.getNoticeContent() %></p>
				</td>
			</tr>	
			
		</table>
		
		<div class="btns" align="center">
		
			<a href="Notice_Manager.NM">목록으로</a> &nbsp;&nbsp;
				
			
			<% if(loginUser != null && loginUser.getUserId().equals("admin")) { %>
			<a href="updateForm.no?nno=<%=n.getNoticeNo()%>">수정하기</a> &nbsp;&nbsp;
			<a href="delete.no?nno=<%=n.getNoticeNo()%>">삭제하기</a>
		
			<% } %>
			
		</div>
</body>
</html>