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
<link rel="stylesheet" href="resources\css\myPage_pic.css">
 
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
		<% if(request.getSession().getAttribute("userId").equals("admin")){ %>
			<input type="submit" id="ch" class="list-group-item list-group-item-action" value="관리자 게시판" name="three"> 
			<% }else{ %>
				
				<% } %>


  </div>

</div>
</form>

</div>
	
	<div id="alla">
	
	<label for="exampleFormControlInput1" class="form-label"> 기존 프로필 </label><br>
	<img src="<%=contextPath%>/resources/board_upfiles/<%= path %>" width="200px" height="150px"> <br>
	<form id="insertForm" action="<%=request.getContextPath()%>/insertpic.th" method="post" enctype="multipart/form-data"
			>

		</div>

	<div>
	<label for="exampleFormControlInput1" class="form-label"> 변경 프로필 </label><br>
     		<input type="hidden" name="id" value="<%=userId%>">
			
					<img id="titleImg"  width="150" height="120">
					
			<div id="fileArea">
				<input type="file" name="file1" id="file1"
					onchange="loadImg(this, 1);">
			</div>

			<br>

		</div>
				<input type="submit" id="xkfxhl" value="작성하기">
			
		</form>






 	<script>
		$(function() {
			$("#fileArea").hide();

			$("#titleImg").click(function() {
				$("#file1").click();
			});

		});
		function loadImg(inputFile, num){
			if(inputFile.files.length == 1){ //파일 존재하면
				var reader = new FileReader();
				reader.readAsDataURL(inputFile.files[0]); //파일을 읽어들이는 메소드
				reader.onload = function(e){
					switch (num) {
					case 1: $("#titleImg").attr("src", e.target.result); break;
					case 2: $("#contentImg1").attr("src", e.target.result); break;
					case 3: $("#contentImg2").attr("src", e.target.result); break;
					case 4: $("#contentImg3").attr("src", e.target.result); break;
					default: break;
					}
				}
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