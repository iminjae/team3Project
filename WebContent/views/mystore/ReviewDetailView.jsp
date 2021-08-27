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
		        <button id="now" onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
		        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
		      </div>
		    </div>
		
		    <div class="center">
		    	 <p class="myreviewtitle">내가 쓴 리뷰</p>
			   	 <div class="all">
			        <div class="form">
			            <p align="center">☆ <%=rv.getBoardTitle() %> ☆</p>
			            <form   method="post" name="testForm" >
			
			                <div class="buyertext">
			                
			                		<%= rv.getContent() %>
			                </div>
			
			                <br>
			
			                <div class="buyercheckbox">
			                    <ul>
			                    <% String checkbox = rv.getRadio(); %>
			               		<% String[] splited =checkbox.split(","); %>
			               		
			               		<% for(int i = 0; i < splited.length; i++){ %>
			                      
			                        <li>
			                        	<%= (i+1)+". " %><%= splited[i] %>
			                        </li>
	
			                  <% } %>
			                    </ul>
			                   
			                </div>    
			                
			                 
			            </form>
			        
			            
			        </div>
			        <br>
			        <div align="center">
			            <button class="okbtn"onclick="history.go(-1)">리뷰 목록으로</button>
			        </div>
			
			    </div>
		  
		    </div>

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