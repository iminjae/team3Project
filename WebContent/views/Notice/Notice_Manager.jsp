<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.team3.Notice.model.vo.NoticeBoard"%>

<%
	ArrayList<NoticeBoard> list = (ArrayList<NoticeBoard>)request.getAttribute("list");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Notice_Manager</title>
<link href="resources/css/Notice_css/Notice_Manager.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>


	<div class="board_list">
		<br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
	
		<br>
		<!--게시판-->

		<table class="list">
		
			<button id="delete" onclick="location.href='<%=request.getContextPath()%>/Delete.do?nno=">삭제</button>
			<a class="btn btn-default"  onclick="folderDeleteClick()">삭제</a>
			<button id="correction" onclick="location.href='<%=request.getContextPath()%>">수정</button>
			
			<thead>
				<tr>
					
					<th width="40">NO.</th>
					<th width="500">제목</th>
					<th width="100">작성자</th>
					<th width="120">작성일</th>
					<th width="60">조회수</th>
				</tr>
			</thead>

			<tbody>			
			
				
				<% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(NoticeBoard b2 : list){ %>
				 		<tr>
				 			<td><%= b2.getNoticeNo() %></td>
							<td><%= b2.getNoticeTitle() %></td>
							<td><%= b2.getNoticeContent() %></td>
							<td><%= b2.getCreateDate() %></td>
							<td><%= b2.getUser_id() %></td>
				 		</tr>
				 	<% } %>
				 <% } %>
				
			</tbody>
		
		</table>

			<div class="paging">
				<a href="location.href='<%=request.getContextPath()%>">이전 페이지</a>
				<a href="#">다음 페이지</a>
			</div>
		<div align="right">
		<button onclick="location.href='<%=request.getContextPath()%>/insertForm.fo'">글쓰기</button> 
		</div>
		<!-- 검색옵션 -->
		<form class="searchArea">
			<select id="Search content" name="Search content">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search" name="search">
			<button type="submit">검색하기</button>
		</form>
		<br>
	</div>
	<script>
         <% if(!list.isEmpty()){ %>
         $(function(){
            $(".list>tbody>tr").click(function(){
               var nno = $(this).children().eq(0).text();
               
               location.href="<%= request.getContextPath() %>/detail.no?nno="+nno;
                     
            })
         })
         <% } %>
   </script>
</body>
</html>