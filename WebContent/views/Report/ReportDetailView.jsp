<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.report.model.vo.Report"%>
    <%
    
    Report rp = (Report)request.getAttribute("reportView");
  	
    System.out.println(rp);
   
   
    %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/report_css/reportDetailView.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
	
	 <div class="container" >
    <div class="row" align="center">
        <div class="well col-xs-10 col-sm-10col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3" align="center">
            <div class="row" align="center">
                <div class="col-xs-6 col-sm-6 col-md-6 text-left" >
                    <address>
                        No.<%=rp.getReportNo()%>
                        
                       
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em> <%=rp.getReportDate()%></em>
                    </p>
                   
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                <br>
                    <h1 style="font-size:250%"><strong>신고서</strong></h1>
                </div>
               
                <table class="table table-hover" align="center">
                    <thead>
                        <tr>
                        
                        	<br>
                        	
                        	
                            <th>신고자 :  <%=rp.getReportWriter()%> <br>신고 대상자 : <%=rp.getReportNick()%></th>
                             
                           	<br>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr>
                        
                            <td class="col-md-9"><em><%=rp.getReportContent()%></em></td>
                           
                        </tr>
                       
                       
                          
                       
                    </tbody>
                </table>
               		<br>
               		<br>
               		
               		<br>
                    <a href="javascript:history.back();" class="btn btn-success btn-lg btn-block">확인</a>
               
               
            </div>
        </div>
    </div>
    </div>
   
    
</body>
<br>
<br>
<%@include file = "../common/footer.jsp" %>
</html>