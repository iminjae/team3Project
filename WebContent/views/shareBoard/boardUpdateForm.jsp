<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.team3.shareBoard.model.vo.* "%>
<%
	Board b = (Board)request.getAttribute("b");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:800px;
		height:500px;

		margin:auto;
		margin-top:50px;
	}
	
	#insertForm>table{
		width:100%;
		border:1px solid white;
	}
	
	#insertForm>table input, #insertForm>table textarea{
		width:100%;
		box-sizing:border-box;
	}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
	
	
	<div class="outer">
		<br>
		
		<h2>게시글 작성하기</h2>
		<br>
		
		<form id="insertForm" action="<%= request.getContextPath()%>/update.sbo" method="post" >
			<table align="center">
				<tr>
					<th width="100">분야</th>
					<td width="500">
						<select name="categoryNo">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>

						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"value="<%=b.getBoardTitle()%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" name="content" style="resize:none;"><%=b.getBoardContent()%></textarea>
					</td>
				</tr>
				
			</table>
			<input type="hidden" name="bno" value="<%= b.getBoardNo() %>">
			<br>
			
			<div class="btns" align="center">
				<button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			</div>
		</form>
	</div>
		<%@include file = "../common/footer.jsp" %>
</body>
</html>