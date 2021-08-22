<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
    
<%
String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
String nickName = ((Member)request.getSession().getAttribute("loginUser")).getNickname();

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

    <title>마이 페이지</title>	
  </head>


<style>
  .list-group{
    float: left;
    margin-left: 30px;
    width: 400px;
    height: 300px;
    
  }
  #one{
    text-align: center;
    font-size: large;
    background-color: blueviolet;
    color: white;
    font-weight: bold;
  }

  .del{
    margin-left: 100px;
    float: left;
    display: block;
    width: 600px;
    height: 300px;
  }

  .form-control{

  }

  #xkfxhl{
    width: 100px;
    height: 50px;
    background-color: blueviolet;
    color: white;

  }
  
  .outer {
	width: 600px;
	height: 650px;
	background: white;
	color: black;
	 float: left;
	 display :block;
	 margin-left : 30px;
	
}

#insertForm>table {
	border: 1px solid white;
}

#insertForm input, #insertForm textarea {
	width: 100%;
	box-sizing: border-box;
}

#insertForm img {
	border: 1px dashed darkgray;
}

#a{
	margin-top:25px;
}
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
	<input type="submit" id="ch" class="list-group-item list-group-item-action" value="관리자 게시판" name="three"></button> 

</form>
  </div>


		<div class="outer">
		<br>
		<h2 align="center">이벤트 게시판 작성</h2>
		<br>



		<form id="insertForm" action="<%=request.getContextPath()%>/insert.th" method="post" enctype="multipart/form-data"
			>
			<input type="hidden" name="writer" value="<%=userId%>">
			
			
					
			<label for="exampleFormControlInput1" class="form-label"> 제목 </label>
     		 <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="">
					
			<label for="exampleFormControlInput1" class="form-label" id="a"> 내용 </label>
			<textarea class="form-control" rows="3"   name="content" style="resize: none;"></textarea>
				
					
			<br><br>
			<label for="exampleFormControlInput1" class="form-label"> 파일 첨부 </label><br>
     		
					<img id="titleImg"  width="150" height="120">
					
			<div id="fileArea">
				<input type="file" name="file1" id="file1"
					onchange="loadImg(this, 1);">
			</div>

			<br>

			<div class="btns" align="center">

				<input type="submit" id="xkfxhl" value="작성하기">
			</div>
		</form>

	</div>

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
		


<script>
	
	
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