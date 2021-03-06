<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.team3.member.model.vo.Member "%>   
  <%  
    String path = (String)request.getSession().getAttribute("path");
%>
  <%   
  	
   String contextPath = request.getContextPath();
%>

<%
	
	String loginUserId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">


<script src="resources\js\jquery.js"></script>
<script src="resources\js\common.js"></script>


</head>
<body>

<div id="header-wrap">

      <header class="header-inner">
         <h1>
            <a href="#">
            <picture>
                        <source media="(max-width:800px)" srcset="resources\images\common\logo-white.png">
                        <img src="resources\images\common\logo.jpg" alt="사구팔구">
            </picture>
            </a>
         </h1>
         <p class="mobile-menu-open">
            <button>
                        <span class="blind">메뉴 열기</span>
                        <span></span>
                        <span></span>
                        <span></span>
            </button>
         </p>
         <div class="mobile-menu-wrap">
            <div class="mobile-menu-scroll">
               <ul class="site-choice">
            
               </ul>
               <ul class="util-menu">
                  <li><a href="<%=request.getContextPath()%>/main.me">Home</a></li>
                  <li><a href="<%=request.getContextPath()%>/MyPageMove.me">마이 페이지</a></li>
                  <li><a href="<%=request.getContextPath()%>/mystore.ms">내 상점</a></li>
                  <li><a href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
                  <li><a href="<%=request.getContextPath()%>/logout.me"><%=loginUserId %></a></li>
              	    <li>  <img src="<%=contextPath%>/resources/board_upfiles/<%= path %>" width="30px" height="30px"> </li>
               </ul>
               <nav id="gnb">
                  <h2 class="blind">메인메뉴</h2>
                  <ul>
                     <li class="m1">
                     	<a href="<%=request.getContextPath()%>/Notice_Manager.NM">공지사항</a>
                     </li>
                     <li class="m2">
                        <a href="#">거래장터</a>
                        <ul >
                           <li><a href="<%=request.getContextPath()%>/exchangeServlet.es">물물교환 게시판</a></li>
                           <li><a href="<%=request.getContextPath()%>/sellList.bo">판매 게시판</a></li>
                        </ul>
                     </li>
                     <li class="m3">
                        <a href="#">커뮤니티</a>
                        <ul>
                           <li><a href="list.sbo">무료나눔</a></li>
                           <li><a href="list.bo">자유 게시판</a></li>
                        
                        </ul>
                     </li>
                     <li class="m4 no-sub">
                                 <a href="#">기타</a>
                                 <ul>
                                 		
                                 		
                                 		
                                     <li><a href="<%=request.getContextPath()%>/event.bo">이벤트</a></li>
                                     
                                    
                                    
                                    	 <%if(loginUserId.equals("admin")) {%>
                                    	  <li> <a href="<%=request.getContextPath()%>/ReportViewServlet">신고문의 조회</a></li> 
                                    	<%}else{%>
                                    	  <li><a href="<%=request.getContextPath()%>/ReportInsertFormServlet">신고하기</a></li>
                                    	<%} %> 
                                                      
                                 </ul>
                     </li>
                  </ul>
               </nav>
            </div>
            <p class="mobile-menu-close">
               <button>
                  <span class="blind">메뉴닫기</span>
                  <span></span>
                  <span></span>
               </button>
            </p>
         </div>
      </header>
   </div>


</body>
</html>