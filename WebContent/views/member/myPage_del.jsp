<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
    
<%
String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
String loginUser = (String)request.getAttribute("loginUser");
%>
<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources\css\myPage_del.css">
    <title>마이 페이지</title>	
  </head>


<style>
 
  
</style>  
  <body>
	<%@include file = "..\common\menubar.jsp" %>

    <div id="header-wrap">
  
   <div class="menu">
   <div class="list-group">
    <button type="button" id ="one" class="list-group-item list-group-item-action" aria-current="true">
      MyPage Menu
    </button> 
    <form action="<%=request.getContextPath()%>/MyPageUpdateMove.me" method="post">
   <input type="submit" class="list-group-item list-group-item-action" value="탈퇴하기" name="one">
   <input type="submit" class="list-group-item list-group-item-action" value="회원정보수정" name="two">
   <input type="submit" class="list-group-item list-group-item-action" value="비밀번호 변경" name="four">
   <input type="submit" class="list-group-item list-group-item-action" value="회원사진 설정" name="five">  
			<% if(request.getSession().getAttribute("userId").equals("admin")){ %>
			<input type="submit" id="ch" class="list-group-item list-group-item-action" value="관리자 게시판" name="three"> 
			<% }else{ %>
				
				<% } %>


</form>
  </div>
 <div class="del">
 
		<form id="updateForm" method="post">
    <div class="mb-3">
 
		   <input type="hidden" name="userId"  id="userId" value="<%=userId%>">
      <label for="exampleFormControlInput1" class="form-label">패스워드를 입력하세요 </label>
      <input type="password" class="form-control" id="exampleFormControlInput1" name="pw" placeholder="비밀번호">
    </div>
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label">탈퇴사유를 작성해주세요 </label>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
      <input type="submit" value="탈퇴하기" id="xkfxhl" onclick="deleteMember();">
  </form>
  
  </div>

</div>


		


<script>
	console.log("<%=(String)request.getSession().getAttribute("userId") %>")
	
	
		function deleteMember(){
			
			var pwd = $('input[name="pw"]').val();
			console.log(pwd);
			if("<%= userPwd %>" == pwd){
				var val = confirm("정말로 탈퇴하시겠습니까?(복구문의 : kkj@naver.com)");
				
				if(val){
					$("#updateForm").attr("action","<%= request.getContextPath()%>/delete.me");
					$("#updateForm").submit();
				}else{
					alert("취소하였습니다.");
				}
			}else{
				alert("비밀번호를 잘못입력하였습니다.");
			}
		}
	</script>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
 	
 </body>
</html>