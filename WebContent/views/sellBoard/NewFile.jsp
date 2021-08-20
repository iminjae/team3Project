<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, com.kh.team3.sellBoard.model.vo.*,com.kh.team3.member.model.vo.Member" pageEncoding="UTF-8"%>
    <% 
	//Board b = (Board)request.getAttribute("b"); 
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	Attachment titleImg = fileList.get(0);
	//String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>helloworld</h1>
</body>
</html>