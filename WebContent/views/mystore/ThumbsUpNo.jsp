<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/ThumbsUpNo.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	
	    <div class="leftpanel">
	      <div class="mypoint">
	      	 내 별점
	      	  
	      </div>
	      <p class="title">My Store</p>
	      <div id="menu">
	        <button onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
	        <button id="now" onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
	        <button onclick="location.href='<%=request.getContextPath()%>/chat.ms'">1:1 채팅내역</button><br>
	        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
	      </div>
	    </div>
	
	    <div class="center">
	    	 <p class="mytitle">찜 ♡</p>
		   	 <div class="listArea">
		        <div class="getboard">
		            <%-- <input type="hidden" value="<%=b.getBoardNo()%>"> --%>  
		            <img src="resources/images/MyStore/chat.png" width="50px" height="50px"> <br>
		            <p>글제목</p>
		            <p>작성자 조회수</p>
		            <button class="btn-like" onclick="cancle();">🧡</button>
		
		        </div>
		    </div>
	  
	    </div>
	 
	    
     
    <script>
       function cancle(){
           confirm("관심목록에서 해제하시겠습니까?");
       }
    </script>
    
    <br><br>
</body>
</html>