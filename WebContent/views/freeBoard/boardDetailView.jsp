<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.team3.freeBoard.model.vo.* ,com.kh.team3.member.model.vo.*" %>  

<%
	Board b = (Board)request.getAttribute("b");
	Member loginUser = (Member)session.getAttribute("loginUser");
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
	
	
	.outer>table{
		width:100%;

	}
	
	.outer>table p{
		height:230px;
		margin:0;
	}
	
	.replyArea{
		width:800px;
		color:white;
		background:dimgray;
		margin:auto;
	}
	#addReply{
		color:white;
		background:gray;
	}
	
	table {
    	width: 100%;
    	border-bottom: 1px solid #444444;
    	border-collapse: collapse;
  	}
  
	/* 글 내용의 경계선 표시 */
	.content{
		border: 1px dotted #cecece;
	}
	/* 글 내용안에 있는 이미지의 크기 제한 */
	.content img{
		max-width: 100%;
	}
	/* 댓글에 관련된 css */
	.comments ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.comments ul li{
		border-top: 1px solid #888; /* li 의 윗쪽 경계선 */
	}
	.comments dt{
		margin-top: 5px;
	}
	.comments dd{
		margin-left: 26px;
	}
	.comments form textarea, .comments form button{
		float: left;
	}
	.comments li{
		clear: left;
	}
	.comments form textarea{
		width: 85%;
		height: 80px;
	}
	.comments form button{
		width: 15%;
		height: 80px;
	}
	/* 댓글에 댓글을 다는 폼과 수정폼을 일단 숨긴다. */
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		width: 8px;
		height: 8px;
		position: absolute;
		top: 10px;
		left: 30px;
	}
	.comments .user-img{
		width: 20px;
		height: 20px;
		border-radius: 50%;
	}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		
		<h2>자유 게시판</h2>
		<br>
		
		<table align="center">
			
			<tr>
				
				 
				<th width="10%">[<%= b.getCategoryNo() %>]</th>
				<th colspan="2" align="left"><%= b.getBoardTitle() %></th>
				
			</tr>
			<tr>
				<td rowspan="2" height="100">프로필사진</td>
				<th width="100" colspan="2" height="70" align="left"><%= b.getUserId() %></th>
				
			</tr>
			<tr>
				<td><%= b.getCreateDate() %></td>
				<td align="right">조회수 : <%= b.getBoardCount() %></td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td><p><%= b.getBoardContent() %></p></td>
			</tr>
		</table>
		<br>
		<div class="btns" align="right">
			<button type="button" onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=1';">목록으로</button>
			
			<% if(loginUser != null && loginUser.getUserId().equals(b.getUserId())){ %>
				
				<button type="button" onclick="updateForm();">수정하기</button>
				<button type="button" onclick="deleteBoard();">삭제하기</button>
			<% } %>
		</div>
		
		<form action="" id="postForm" method="post">
			<input type="hidden" name="bno" value="<%= b.getBoardNo() %>">
		</form>
		<script>
			function updateForm(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/updateForm.bo");
				$("#postForm").submit();
			}
			
			function deleteBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/deleteB.bo");
				$("#postForm").submit();
			}
		</script>
		<br>
			<div class="comments">
		<!-- 원글에 댓글을 작성할 수 있는 폼 -->
		
		<div class="comment_form">
			<form action="comment_insert.do" method="post"> 
			<!-- 댓글의 그룹번호는 원글의 글번호가 된다. -->
				<input type="hidden" name="ref_group" value="rno"/>
			<!-- 댓글의 대상자는 원글의 작성자가 된다. -->
				<input type="hidden" name="target_id" value="rwriter"/>
				<textarea name="content"></textarea>
				<button type="submit">등록</button>
            </form>
            
		</div>
   	</div>
	</div>

</body>
</html>