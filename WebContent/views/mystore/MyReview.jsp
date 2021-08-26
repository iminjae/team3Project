<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList, com.kh.team3.mystore.model.vo.Review, com.kh.team3.member.model.vo.Member "%>
<%
	ArrayList<Review> rvlist = (ArrayList<Review>)request.getAttribute("rvlist");
   int starpoint = (int)((Member)request.getSession().getAttribute("loginUser")).getStartpoint();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/MyReview.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
 .new{
 <%--뭐지이게--%>
       width: 45px;
       height: 15px;
       background-color: rgb(245, 184, 128);
       border-radius: 4px;
       text-align: center;
       padding-bottom: 10px;
       padding-top: -35px;
  
   }
   
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
	
	 <div class="content" width="1500px">
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

    		
    	<table class="rvlist">
        <thead>
           <tr>
              <th width="80">BoardNo.</th>
              <th width="350">BoardTitle</th>
              <th width="400">Review</th>
              <th width="150">CreatDate</th>
              <th  width="50">Count</th>
           </tr>
        </thead>
	         <div class="rvlist">
		        <tbody>
				 	 <% if(rvlist.isEmpty()){ %>
		                 <tr>
		                  <td colspan="5">작성한 리뷰가 없습니다.</td>
		                </tr>
		             <% }else{  %>
			              <% for(Review rv : rvlist){ %>
			                 <tr>
			                   <td><%= rv.getBoardNo() %></td>
			                   <td><%=  "[ "+ rv.getCategoryName() +" ] "+ rv.getBoardTitle()%></td>
			                   <td><%=  rv.getContent() %></td>
			                   <td><%= rv.getCreateDate() %></td>
			                   <td ><%= rv.getCount() %></td>
			                 </tr>
			              <% } %>
		            <% } %>
					     
		        </tbody>
	         </div>  
    </table>
    </div>
    
    <br><br>
    	
    </div>
    
    <br><br>
    <script>
         <% if(!rvlist.isEmpty()){ %>
         $(function(){
            $(".rvlist>tbody>tr").click(function(){
               var nno = $(this).children().eq(0).text();
               
               location.href="<%= request.getContextPath()%>/myreviewdetail.ms?nno="+nno;
                     
            })
         });
         <% } %>
   </script>
   
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