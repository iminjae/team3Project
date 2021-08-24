<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.team3.mystore.model.vo.Jjim"%>
<%
   ArrayList<Jjim> jjimList = (ArrayList<Jjim>)request.getAttribute("jjimList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/Jjim.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
.ptag{
font-size : 24px;
}
</style>
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
	        <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
	        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
	      </div>
	    </div>
	
	    <div class="center">
	    	 <p class="mytitle">찜 ♡</p>
		   	 <div class="listArea">
		   	 
		   	 <% if(jjimList.isEmpty()){ %>
                <div>
                  <p class="ptag">존재하는 찜 목록이 없습니다.<p>
               </div>
             <% }else{  %>
			   	  <% for(Jjim list : jjimList){ %>
			   	 
			        <div class="getboard"  >
			        		<input type="hidden" value="<%=list.getBoardNo() %>">
			        		<div onclick="location.href='<%=request.getContextPath()%>/sellDetail.bo?bNo=<%=list.getBoardNo() %>'">
					            <img src="<%=request.getContextPath()%>/resources/board_upfiles/<%=list.getChangeName() %>" width="50px" height="50px"> <br>
					            <p><%= list.getBoardTitle()%></p>
					            <p><%= list.getUserId()%>&ensp;&ensp;조회수:<%= list.getBoardCount()%></p>			            
				            </div>
				            <button class="btn-like" onclick="cancle();">🧡</button>  
			        </div>
			        <% } %> 
			   <% } %>   
		    </div>
	  
	    </div>
	 
	    
	     
	    <script>
	       function cancle(){
	    	   var answer;
	   			answer = confirm("관심목록에서 해제하시겠습니까?");
	   			
	   			
	   			
	   			if(answer == true){
	   				var jno = $(".getboard").children().eq(0).val();
	
	   				location.href='<%=request.getContextPath()%>/deleteJjim.ms?jno='+jno;
	   				  
	   				alert("관심목록에서 해제되었습니다");
	   			}
	   			
	   			
	       }
	    </script>
    
    <br><br>
</body>
</html>