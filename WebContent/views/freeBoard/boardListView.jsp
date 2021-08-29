<%@page import="java.util.ArrayList, com.kh.team3.freeBoard.model.vo.* , com.kh.team3.freeBoard.model.dao.*,com.kh.team3.freeBoard.model.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
	.box{
		width:800px;
		height:500px;
		margin:auto;
		margin-top:50px;
		
	}
	.board{
		border:1px solid white;
		text-align:center;
		
	}
	
	
	.board>tbody>tr:hover{
		cursor:pointer;
		
	}
	
	td {
  		color: rgb(232,180,81);
  	}
	table {
    	width: 100%;
    	
  	}
  	td {
    	border-bottom: 1px solid #444444;
    	padding: 10px;
    	font-size:11px;
    	height:30px;
  	}
  	th{
  		background-color: rgb(53,61,64);
  		color: rgb(255,255,255);
  	}
  	h1{
  		color: rgb(23,62,96);
  	} 
  	button{
  		background-color: rgb(53,61,64);
  		color: rgb(255,255,255);
  	}	
  	</style>
</head>
<body>
<%@ include file="../common/menubar.jsp"%>
	
	<div class="box">
		<br>
		
		<h1>자유 게시판</h1>
		<br>
		
		<table class="board"  align="center">
			<thead>
				<tr>
					<th  width="7%">글번호</th>
					<th width="6%">분류</th>
					<th width="55%">글제목</th>
					<th width="10%">작성자</th>
					<th width="7%">조회수</th>
					<th width="15%">작성일</th>
				</tr>
			<thead>
	
			<tbody>
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
				<% for(Board b : list){ %>
				<tr>
					<td><%= b.getBoardNo() %></td>
					<td><%= b.getCategoryName() %></td>
					<td class="link"><%= b.getBoardTitle() %></td>
					<td><%= b.getUserId() %></td>
					<td><%= b.getBoardCount() %></td>
					<td><%= b.getCreateDate() %></td>
				</tr>
				<%} %>
				<%} %>
			</tbody>
		</table>
		
		<br>
		<div align="right">
	
		<button onclick="location.href='<%=request.getContextPath()%>/insertForm.bo'">작성하기</button>

		</div>
	</div>
	
	<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 

		




<DIV class='aside_menu'>
  <FORM name='frm' method='GET' action='./list.bo'>
    <ASIDE align = 'center'>
      <SELECT name='type'> 
        <OPTION value='userId'>이름</OPTION>
        <OPTION value='BoardTitle'>제목</OPTION>
      </SELECT>
      <input type='text' name='search'>
      <button type='submit'>검색</button>    

    </ASIDE> 
  </FORM>
  <DIV class='menu_line' style='clear: both;'></DIV>
</DIV>


<script>
		
			$(function(){
				
				$(".board>tbody>tr").click(function(){
					
					var bno = $(this).children().eq(0).text();
					location.href = "<%=request.getContextPath()%>/detail.bo?bno="+bno;
				})
			})
		
	</script>
<%@include file = "../common/footer.jsp" %>
	
</body>
</html>