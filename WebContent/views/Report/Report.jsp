<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.kh.team3.report.model.vo.Report, com.kh.team3.member.model.vo.Member "%>    
<%
	
   ArrayList<Report> rpList = (ArrayList<Report>)request.getAttribute("reportList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 게시판</title>
</head>

<link rel="stylesheet" href="resources/css/report_css/report.css">


<body>
 <%@ include file="../common/menubar.jsp" %>
 	
 	  <div class="center">
       <p class="mytitle">신고목록</p>
       
       <br>


	   <table class="rpList">
        <thead>
           <tr>
              <th width="100">BoardNo.</th>
              <th width="400">신고내용</th>
              <th width="80">신고자</th>
               <th width="50">신고대상자</th>
              <th width="200">신고날짜</th>           
           </tr>
        </thead>
          <div class="rpList">
              <tbody>
              <% if(rpList.isEmpty()){ %>
                 <tr>
                  <td colspan="5">작성한 게시글이 없습니다.</td>
                </tr>
             <% }else{  %>
                    <% for(Report rp : rpList){ %>
                       <tr>
             
                               <td><%= rp.getReportNo() %></td>
                               <td><%= rp.getReportCategory() %></td>
                               <td><%= rp.getReportWriter() %></td>
                               <td><%= rp.getReportNick() %></td>
                               <td><%= rp.getReportDate() %></td> 
                               <td><%= rp.getReportContent() %></td>                              
                       </tr>
                    <% } %>   
             <% } %>                   
              </tbody>
            </div>
         
    </table>
    </div>
    
    <script>
    
	
	    
	    
	    
	    
	    <% if(!rpList.isEmpty()){ %>
         $(function(){
            $(".rpList>tbody>tr").click(function(){
            	var re = $(this).children().eq(0).text();
               console.log("@@@@@@"+ re);
            location.href="<%= request.getContextPath()%>/ReportViewDetailServlet?re="+re;
                     
            })
         })
         <% } %>
	    
	    
    </script>
    
</body>
</html>