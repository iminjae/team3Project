<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
    
<%

String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();

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
<link rel="stylesheet" href="resources\css\myPage_pw.css">
 
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
   <input type="submit" class="list-group-item list-group-item-action" value="탈퇴하기" name="one"></button>
   <input type="submit" class="list-group-item list-group-item-action" value="회원정보수정" name="two"></button>
    <input type="submit" class="list-group-item list-group-item-action" value="비밀번호 변경" name="four">
   <input type="submit" class="list-group-item list-group-item-action" value="회원사진 설정" name="five">  
	<input type="submit" id="ch" class="list-group-item list-group-item-action" value="관리자 게시판" name="three"></button> 

</form>

  </div>

 <div class="del">
 
		<form id="updatepw" method="post"  action="<%=request.getContextPath() %>/pwupdate.me">

  <div class="form-group">
  
    <input type="hidden" class="form-control" name="id" id="exampleInputEmail1" value="<%=userId%>">
  
    <label for="exampleInputEmail1">기존 패스워드</label>
    <input type="password" class="form-control" name="pw1" id="exampleInputEmail1">
    
    <label for="exampleInputEmail1">변경 패스워드</label>
    <input type="password" class="form-control"  name="pw2" id="exampleInputEmail1">
    
    <label for="exampleInputEmail1">확인 패스워드</label>
    <input type="password" class="form-control"  name="pw3" id="exampleInputEmail1">
  </div>
  
	
      <input type="submit" value="변경하기" id="xkfxhl" onclick="uppw();">
</form>
  </div>

</div>
	
	<script>
		function uppw(){
			
			var pwd = $('input[name="pw"]').val();
			console.log(pwd);
			if("<%= userPwd %>" == pwd){
				var val = confirm("정말로 변경하시겠습니까?);
				
				if(val){
					$("#updatepw").attr("action","<%= request.getContextPath()%>/updatepw.me");
					$("#updatepw").submit();
				}else{
					alert("취소하였습니다.");
				}
			}else{
				alert("비밀번호를 잘못입력하였습니다.");
			}
		}
	</script>


 	
 

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
  </body>
</html>