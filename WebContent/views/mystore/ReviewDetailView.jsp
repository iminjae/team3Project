<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.mystore.model.vo.Review"%>
<!DOCTYPE html>
<%
	Review rv = (Review)request.getAttribute("reviewdetail");

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/MyReview.css" rel="stylesheet" type="text/css">
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
		        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
		        <button id="now" onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
		        <button onclick="location.href='<%=request.getContextPath()%>/chat.ms'">1:1 채팅내역</button><br>
		        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
		      </div>
		    </div>
		
		    <div class="center">
		    	 <p class="myreviewtitle">내가 쓴 리뷰</p>
			   	 <div class="all">
			        <h4 align="center">리뷰 확인</h4>
			        <div class="form">
			            <p align="center">☆ <%=rv.getBoardTitle() %> ☆</p>
			            <form   method="post" name="testForm" >
			
			                <div class="buyertext">
			                
			                		<%= rv.getContent() %>
			                </div>
			
			                <br>
			
			                <div class="buyercheckbox">
			                    <ul>
			               
			                        <li>
			                            <%=rv.getRadio() %>
			                        </li>
			                  
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
	
</body>
</html>