<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
<%@page import="java.util.ArrayList, com.kh.team3.mystore.model.vo.Review, com.kh.team3.member.model.vo.Member "%>
<%
   ArrayList<Review> myboard = (ArrayList<Review>)request.getAttribute("myboard");
  int starpoint = (int)((Member)request.getSession().getAttribute("loginUser")).getStartpoint();

String title="제목";

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
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
   crossorigin="anonymous" />


<style>
 .search{
  margin-top: 80px;
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
</head>
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
        <button id="now" onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
          <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">리뷰 확인</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
      </div>
    </div>

    <div class="center">
       <p class="mytitle">내 게시글</p>
       <button id="writeboard" onclick="writeBoard();">글쓰기</button>
       <br>
       
       <table class="list">
        <thead>
           <tr align="center">
              <th width="100">BoardNo.</th>
              <th width="120">Category</th>
              <th width="400">Title</th>
              <th width="80">Author</th>
               <th width="50">Count</th>
              <th width="200">CreatDate</th>           
           </tr>
        </thead>
          <div class="myboardlist">
              <tbody>
              

              <% if(myboard.isEmpty()){ %>
                 <tr>
                  <td colspan="6">작성한 게시글이 없습니다.</td>
                </tr>
             <% }else{  %>
     
                    <% for(Review rv : myboard){ %>
                       <tr>
             
                               <td><%= rv.getBoardNo() %></td>
                               <td><%= rv.getBoardtypeName()%></td>
                               
                               <%if(rv.getBoardtypeName().equals("판매게시판")) {%>
                              		 <%if(rv.getBoardStaus().equals("판매중")) {%>
                                		 <td>[ <%= rv.getCategoryName()%> ] <%= rv.getBoardTitle()%>&ensp;<div class="badge bg-primary">판매중</div></td>
                                	  <%}else if(rv.getBoardStaus().equals("예약중")) {%>
                                		 <td>[ <%= rv.getCategoryName()%> ] <%= rv.getBoardTitle()%>&ensp; <div class="badge bg-success">예약중</div></td>
                                	  <%}else if(rv.getBoardStaus().equals("판매완료")) {%>
                                	  	 <td>[ <%= rv.getCategoryName()%> ] <%= rv.getBoardTitle()%> &ensp;<div class="badge bg-warning">판매완료</div></td>
                                	  <%} %>
                               <%}else{ %>
                                <td><%= rv.getBoardTitle() %></td>
                               <%} %>
                               
                               
                               <td><%= rv.getUserId() %></td>
                                <td><%= rv.getCount() %></td>
                               <td><%= rv.getCreateDate() %></td>                           
                       </tr>
                    <% } %>   
                    

             <% } %>   
           
              </tbody>
            </div>
         
    </table>

<%--
    <div class="search">
	    <form class="searchArea" align="center" method="post" action="<%=request.getContextPath()%>/serach.ms">
	        <select id="condition" name="condition" >
	           <option name="category">제목</option>
	           <option value="내용">내용</option>
	           <option value="카테고리">카테고리</option>
	        </select>
	        <input id="serachtext" type="search" name="search">
	        <button id="serachbtn" type="submit">🔍</button>
	     </form>
	</div>

 --%>
    </div>
    
    <br><br>
    
    
    


    <script>
         <% if(!myboard.isEmpty()){ %>
	            $(function(){
	               $(".list>tbody>tr").click(function(){
	                  var bNo = $(this).children().eq(0).text();     
	                  var category = $(this).children().eq(1).text();             
	                    console.log("카테고리 : "+ category + " bNo : " + bNo);
	                    
	                    switch (category){
	                    case "판매게시판" :
	                    	 location.href="<%= request.getContextPath()%>/sellDetail.bo?bNo="+ bNo;
	                        break;
	                    case "자유게시판" :
	                    	  location.href="<%= request.getContextPath()%>/detail.bo?bno="+ bNo;
	                        break;
	                    case "무료나눔게시판" :
	                    	   location.href="<%= request.getContextPath()%>/detail.sbo?bno="+ bNo;
	                        break;
	                    case "무료나눔게시판" :
	                    	   location.href="<%= request.getContextPath()%>/detail.sbo?bno="+ bNo;
	                        break;
	                    default :
	                        alert("확인할 수 없는 게시글 입니다.")
	                  }

	               })
	            })
         <% } %>

         
         function writeBoard(){
           
            location.href="<%= request.getContextPath()%>/sellInsertForm.bo";

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

       
      
</html>