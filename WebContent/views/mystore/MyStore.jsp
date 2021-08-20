<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyStore</title>
<link href="resources/css/mystore/MyStore.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



</head>
<body>
	
	<%@include file ="../common/menubar.jsp"%>
	
	 <p class="title">MY STORE</p>
	 <br>
  <div id="center">
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">
      <img src="resources/images/MyStore/board.png"><br>
      <b>내 게시글</b>
    </button>
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/like.ms'">
      <img src="resources/images/MyStore/heart.png"><br>
      <b>찜</b>
    </button>
  </div>
  <div id="center2">
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/chat.ms'">
      <img src="resources/images/MyStore/chat.png"><br>
      <b>1:1 채팅내역</b>
    </button>
    <button id="box" onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">
      <img src="resources/images/MyStore/delivery.png"><br>
      <b>배송 조회</b>
    </button>
   </div>
   
   <!-- 리뷰다 -->
   <button onclick="makeReview();">리뷰 쓰기</button>
   <script>
	   function makeReview(){
		   	var _width = '500';
		    var _height = '600';
		 
		    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
		    var _left = Math.ceil(( window.screen.width - _width )/2);
		    var _top = Math.ceil(( window.screen.height - _height )/2); 
		 
		    window.open('<%= request.getContextPath()%>/review.rv', '리뷰 쓰기', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
		}
   </script>
    
  
</body>
</html>