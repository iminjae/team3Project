<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.team3.mystore.model.vo.Jjim, com.kh.team3.member.model.vo.Member "%>
<%
   ArrayList<Jjim> jjimList = (ArrayList<Jjim>)request.getAttribute("jjimList");
   int starpoint = (int)((Member)request.getSession().getAttribute("loginUser")).getStartpoint();
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
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
   crossorigin="anonymous" />
<style>
.ptag{
font-size : 24px;
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
     
   .center{  
    margin-top: 40px;  
   }
   
   #statusTag{
   	display: inline-block;
   	margin-left :auto;
   	margin-right :auto;
   	text-align:center;
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
	        <button id="now" onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
	        <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">리뷰 확인</button><br>
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
					           
					            <img src="<%=request.getContextPath()%>/resources/board_upfiles/<%=list.getChangeName() %>" width="50px" height="50px"> 
					            <p><%= list.getBoardTitle()%></p>
					           
						           	 <%if(list.getBoardStatus().equals("판매중")) {%>
						         	    <div class="divTag" >
	                                	   <button id="userTag"><%= list.getUserId()%></button>&ensp;&ensp;<div class="badge bg-primary">판매중</div>
	                             		</div>
	                               	  <%}else if(list.getBoardStatus().equals("예약중")) {%>
	                               	  	<div class="divTag" >
	                               		   <button id="userTag"><%= list.getUserId()%></button>&ensp;&ensp;<div class="badge bg-success">예약중</div>
	                               		</div>
	                               	  <%}else if(list.getBoardStatus().equals("판매완료")) {%>
	                               	  	  <div class="divTag" >                               	  	 
	                               	  	    <button id="userTag"><%= list.getUserId()%></button>&ensp;&ensp;<div class="badge bg-warning">판매완료</div>
	                               	      </div>
	                               	  <%} %>	
   
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
	   			 $(function(){
		   			 $(".getboard").click(function(){
		                 var jno = $(this).children().eq(0).val();
		                 console.log("jno~~" + jno);
		             	location.href="<%=request.getContextPath()%>/deleteJjim.ms?jno="+jno;
		         	})
	   			 })
		   		
	   				alert("관심목록에서 해제되었습니다");
	   			}
	   			
	   			
	       }
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
    
    <br><br>
</body>
</html>