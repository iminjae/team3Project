<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice_USER</title>
<link href="resources/css/Notice_css/Notice_USER.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="Content">
		<br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>
	    
		<!--게시판-->
		<div class="Content">
		<br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>
	    
		<!--게시판-->
		<table class="list">
			<thead>
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
					<td style="width: 500px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">코로나 조심sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</td>
					<td>운영자</td>
					<td>2021-08-18</td>
				</tr>

			</tbody>
		</table>

		<!--Pagination-->
		<ul class="pagination">
			<li class="disabled">
				<a href="#">
					<span>«</span>
				</a>
			</li>
			<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			<li>
				<a href="#">
				<span>»</span>
				</a>
			</li>
		</ul>

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
		<div align="center">
		<!-- 관리자일경우 공지사항 작성가능하게 -->			
		</div>
	</div>
	
	
</body>
</html>