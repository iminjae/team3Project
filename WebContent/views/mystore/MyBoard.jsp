<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%--
<%@page import="java.util.ArrayList, com.kh.team3.common.PageInfo.java*"%>
<%
	//형변환 해줘야 함
   ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   
   int listCount = pi.getListCount();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   

%>
   --%>  
<%--
<%
   ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
--%>



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
    	<button id="writeboard" onclick="location.href='<%=request.getContextPath()%>">글쓰기</button>
    	<br>
    	
    	<table class="list">
        <thead>
           <tr>
              <th width="100">No.</th>
              <th width="400">Title</th>
              <th width="100">Author</th>
              <th width="200">CreatDate</th>
              <th colspan=2 width="100">Like</th>
           </tr>
        </thead>
        <tbody>
            <tr>
               <td>3</td>
               <td>[카테고리] 마지막 공지사항제목(댓글수) new</td>
               <td>admin</td>
               <td>2020-02-10</td>
               <td>10</td>
               <td>휴</td>
            </tr>
            <%-- 
            <% if(list.isEmpty()){ %>
                <tr>
                  <td colspan="5">존재하는 공지사항이 없습니다.</td>
               </tr>
             <% }else{  %>
	                <% for(Notice n : list){ %>
	                   <tr>
	                      <td><%= n.getNoticeNo() %></td>
	                     <td><%= n.getNoticeTitle() %></td>
	                     <td><%= n.getNoticeWriter() %></td>
	                     <td><%= n.getCount() %></td>
	                     <td><%= n.getCreateDate() %></td>
	                   </tr>
	                <% } %>
             <% } %>
             
             --%>  
        </tbody>
    </table>
    </div>
    
    <br><br>
    
    

   <!-- 검색기능 -->

 		
		
</html>