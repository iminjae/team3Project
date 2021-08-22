<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
<%@page import="java.util.ArrayList, com.kh.team3.mystore.model.vo.Review, com.kh.team3.member.model.vo.Member "%>
<%
	ArrayList<Review> myboard = (ArrayList<Review>)request.getAttribute("myboard");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/MyBoard.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">
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
        <button id="now" onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
          <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/chat.ms'">1:1 채팅내역</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
      </div>
    </div>

    <div class="center">
    	<p class="mytitle">내 게시글</p>
    	<button id="writeboard" onclick="writeBoard();">글쓰기</button>
    	<br>
    	
    	<table class="list">
        <thead>
           <tr>
              <th width="100">BoardNo.</th>
              <th width="400">Title</th>
              <th width="80">Author</th>
              <th width="200">CreatDate</th>
              <th width="70">LikeCount</th>
              <th  colspan=2  width="50">Count</th>
              <th></th>
           </tr>
        </thead>
          <div class="myboardlist">
		        <tbody>
		 
		              <% for(Review rv : myboard){ %>
		                 <tr>
		                   <td><%= rv.getBoardNo() %></td>
		                   <td><%=  "["+ rv.getCategoryName() +"] "+ rv.getBoardTitle() %></td>
		                   <td><%= rv.getUserId() %></td>
		                   <td><%= rv.getCreateDate() %></td>
		                   <td ><%= rv.getLikeCnt() %></td>
		                   <td colspan=2><%= rv.getCount() %></td>
		                   <td><button class="btn-trash" onclick="deleteboard();">🗑</button></td>
		                 </tr>
		              <% } %>
					     
		        </tbody>
	         </div>
	      
    </table>
    </div>
    
    <br><br>


    <script>
         <% if(!myboard.isEmpty()){ %>
         $(function(){
            $(".myboardlist>tbody>tr").click(function(){
               var bNo = $(this).children().eq(0).text();
               
               location.href="<%= request.getContextPath()%>/sellDetail.bo?bNo="+ bNo;
                     
            })
         })
         <% } %>
         
         function deleteboard(){
        	 confirm("게시글을 삭제하시겠습니까?");
        	 
        	  $(function(){
                  $(".myboardlist>tbody>tr").click(function(){
                     var bNo = $(this).children().eq(0).text();
                     
                     location.href="<%= request.getContextPath()%>/sellDelete.bo?bNo="+ bNo;
                           
                  })
               })
        	 
             
         }
         
         function writeBoard(){
        	 location.href="<%= request.getContextPath()%>/sellInsertForm.bo";

         }
   </script>

 		
		
</html>