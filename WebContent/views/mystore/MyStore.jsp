<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.mystore.model.vo.Review"%>
<!DOCTYPE html>
<%
	Review rv = (Review)request.getAttribute("review");
%>
<html>
<head>
<meta charset="UTF-8">
<title>MyStore</title>
<link href="resources/css/mystore/MyStore.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



</head>
<body>
	
	<%@ include file="../common/menubar.jsp"%>
	
	 <p class="title">MY STORE</p>
	 <br>
  <div id="center">
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">
      <img id="mystoricon" src="resources/images/MyStore/board.png"><br>
      <b>내 게시글</b>
    </button>
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/like.ms'">
      <img id="mystoricon" src="resources/images/MyStore/heart.png"><br>
      <b>찜</b>
    </button>
  
  </div>
  <div id="center2">
  	<button id="box" onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">
      <img id="mystoricon" src="resources/images/MyStore/chat.png"><br>
      <b>리뷰</b>
    </button>
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">
      <img id="mystoricon" src="resources/images/MyStore/delivery.png"><br>
      <b>배송 조회</b>
    </button>
   </div>

    
  <%@include file = "../common/footer.jsp" %>
  
</body>
</html>