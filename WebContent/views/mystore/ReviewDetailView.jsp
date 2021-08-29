<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.mystore.model.vo.Review,  com.kh.team3.member.model.vo.Member"%>
<!DOCTYPE html>
<%
	Review rv = (Review)request.getAttribute("reviewdetail");
    int starpoint = (int)((Member)request.getSession().getAttribute("loginUser")).getStartpoint();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/MyReview.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
  #myProgress {
         margin-top: 8px;
         width: 150px;
         height: 50px;
         margin-left: 10px;
     }
     .mypoint{
     	 border : 0;
         width : 170px;
         height : 80px;
         margin-top : -20px;
         margin-bottom : 20px;
     }

     #ptagstar{
         margin-left: 45px;
         margin-top: 5px;
         margin-bottom: 7px;
        
     }
     #pointtt{
         font-size: small;
         margin-left: 120px;
     }
  
         
      #allReviewDetail{
        border : 1px solid white;
        width: 500px;
        height: 600px;
        background-color:rgb(232, 180, 81);
        border-radius: 9px;
        margin-top:30px;
        margin-left: 150px;
      }
 
</style>
<body>
<%@ include file="../common/menubar.jsp" %>
	<div class="leftpanel">
		     <div class="mypoint">
	            <p id="ptagstar">⭐내별점⭐</p>
	            <P id="pointtt"><%=starpoint %>point</P>
	            <div id="myProgress">
	                <progress id="my" value='<%=starpoint %>' max='100' ></progress>
	            </div>
      		 </div>
		      <p class="title">My Store</p>
		      <div id="menu">
		        <button onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
		        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
		        <button id="now" onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">리뷰 확인</button><br>
		        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
		      </div>
	</div>
		
	<div class="center">
		    	 <p class="myreviewtitle">리뷰 확인</p>
			   	 <div id="allReviewDetail">
		            <p class="reviewTitle" align="center">리뷰 후기</p>
		            <hr class="hrTag">
		            <div align="center">
		                <p>게시글 제목 : <%=rv.getBoardTitle() %></p>
		            </div>
		            <div class="contentReviw">
		                <p class="contentReviwTag">
		                  <%= rv.getContent() %>
		                </p>
		            
		            </div>
		            <div class="reviewStarTag">
		                <img  id="reviewStar" src="resources/images/MyStore/reviewStar.png"/>           
		            </div>
		        
		            <% String checkbox = rv.getRadio(); %>
		            <% String[] splited =checkbox.split(","); %>
		
		            <% for(int i = 0; i < splited.length; i++){ %>
		
		            <div id="checkBox">
		                <div id="samllCheck">
		                    <p class="smallreviewTag"><%= (i+1)%></p>
		                </div>
		                <div id="largeCheck">
		                    <p class="largereviewTag" > <%= splited[i] %></p>
		                </div>
		            </div>
		            <% } %>
		
		            <br>
		
		            <div align="center">
		                <br>
		                <button id="backList" onclick="history.go(-1)">리뷰 목록으로</button>
		            </div>
		
		            <div class="dogdog">
		                <img  id="dogdog" src="resources/images/MyStore/catdog.png"/>           
		            </div>
		    </div>
		    
		    <br><br>
		    <br><br>
		  
	</div>
	
	<%@include file = "../common/footer.jsp" %>
	

       <script>
        window.onload=function(){
            var elem = document.getElementById("my");   
            var width = 10;
            var id = setInterval(frame, 10);
            function frame() {
            if (width >= 100) {
                clearInterval(id);
            } else {
                width++; 
                elem.style.width = width + '%'; 
            }
            }

        }
        </script>

	
</body>
</html>