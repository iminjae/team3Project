<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/Notice_css/NoticeWrite.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	<div class="Write">
        <br>
		<h1 align="center" class="Notice">공지사항</h1>
		<hr align="center" style="border: solid 1px rgb(0, 0, 0); width:40%" >
		<br>
		<form>
	        <table border="1" class="list" align="center">  
	            <tr>
	                <th>작성자</th>
	                <td><input type="text" id="user"></td>
	                <th>작성일</th>
	                <td><input type="text" id="day"></td>
	            </tr>
	            <tr>
	                <th>제목</th>
	                <td colspan="3"><input type="text" id="title"></td>
	            </tr>
	            <tr>
	                <th>내용</th>
	                <td colspan="3"><input type="text" id="content"></td>
	            </tr>
	            <tr>
	                <th>첨부파일</th>
	                <td colspan="3"><input type="text" id="attachments"></td>
	            </tr>
	        </table>
	
	        <button id="completion" >완료</button>
		</form>
    </div>
</body>
</html>