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
<title>Insert title here</title>
</head>
<body>
	
	
	
	 <div class="form-group">
  
    <input type="hidden" class="form-control" name="id" id="exampleInputEmail1" value="<%=rp.getReportNo()%>">
  
    <label for="exampleInputEmail1">아이디</label>
    <input type="text" class="form-control" name="id2" id="exampleInputEmail1" placeholder="<%=rp.getReportContent()%>" value="<%=rp.getReportDate()%>" disabled>
    
    <label for="exampleInputEmail1">이름</label>
    <input type="text" class="form-control"  name="name" id="exampleInputEmail1" placeholder="<%=rp.getReportNick()%>">
    
    <label for="exampleInputEmail1">PHONE</label>
    <input type="text" class="form-control"  name="phone" id="exampleInputEmail1" placeholder="<%=rp.getReportWriter()%>">
    
    <label for="exampleInputEmail1">닉네임</label>
    <input type="text" class="form-control"  name="nick" id="exampleInputEmail1" placeholder="<%=rp.getReportCategory()%>">
    

  </div>
</body>
</html>