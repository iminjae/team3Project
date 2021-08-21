<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/MyChat.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	 <div class="content" width="1500px">
    <div class="leftpanel">
      <div class="mypoint">
      	 내 별점
      	  
      </div>
      <p class="title">My Store</p>
      <div id="menu">
        <button onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
        <button id="now" onclick="location.href='<%=request.getContextPath()%>/chat.ms'">1:1 채팅내역</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
      </div>
    </div>

    <div class="center">
    	<p class="chattitle">나의 채팅</p>
    	
    </div>
    
    <br><br>
</body>
</html>