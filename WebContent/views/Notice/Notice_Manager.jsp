<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice_Manager</title>
<link href="resources/css/Notice_css/Notice_Manager.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">

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
			<thead>
				<button id="delete" onclick="location.href='<%=request.getContextPath()%>">삭제</button>
				<button id="correction" onclick="location.href='<%=request.getContextPath()%>">수정</button>
				<tr>
					<th width="40">NO.</th>
					<th width="500">제목</th>
					<th width="100">작성자</th>
					<th width="120">작성일</th>
				</tr>
			</thead>

			<tbody>

				<tr>
					<td>1</td>
					<td class="tit">
						<a href="#">코로나 조심sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</a>
					</td>
					<td>운영자</td>
					<td>2021-08-18</td>
				</tr>
				
			</tbody>
		
		</table>

			<div class="paging">
				<a href="#">이전 페이지</a>
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">다음 페이지</a>
			</div>
		
		<button id="writing" onclick="location.href='<%=request.getContextPath()%>/Notice_Write.NW'">글쓰기</button> 

		<!-- 검색옵션 -->
		<form class="searchArea">
			<select id="Search content" name="Search content">
				<option value="name-Content">제목+내용</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search" name="search">
			<button type="submit">검색하기</button>
		</form>
		<br><br>
		
	</div>
</body>
</html>