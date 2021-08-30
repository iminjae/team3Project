<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.team3.eventBoard.model.vo.*" %>    

<% 
	Board b = (Board)request.getAttribute("board");
	Attachment at = (Attachment)request.getAttribute("at");

	
%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<title>Insert title here</title>
<style>
	 .list-group{
    float: left;
    margin-left: 30px;
    width: 400px;
    height: 300px;
    
  }
	#updateForm>table{
		border:1px solid white;
	}
	
	#updateForm>table input, #updateForm>table textarea{
		width:100%;
		box-sizing:border-box;
	}
	  #one{
    text-align: center;
    font-size: large;
    background-color: rgb(23,62,96);
    color: white;
    font-weight: bold;
  }
	
	 .outer {
	width: 600px;
	height: 650px;
	background: white;
	color: black;
	 float: left;
	 display :block;
	 margin-left :  100px;
	
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
	
	 
  #bt{
    width: 100px;
    height: 50px;
    background-color: rgb(161,165,156);
    color: white;
    margin-top : 30px;
    margin-left: 500px;
  }
	
	
	#deleteBtn{color:gray;}
	#deleteBtn:hover{cursor:pointer}
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
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

</form>
  </div>
		</div>
		</div>
	
	<div class="outer">
		<br>
		
		<h2 align="center">게시판 수정하기</h2>
		<br>
		
		<form id="updateForm" action="<%= contextPath %>/update.bo" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bno" value="<%= b.getBoardNo() %>">
			
			
			
					
			<label for="exampleFormControlInput1" class="form-label"> 제목 </label>
     		 <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="<%= b.getBoardTitle() %>">
					
			<label for="exampleFormControlInput1" class="form-label" id="a"> 내용 </label>
			<textarea class="form-control" rows="3"   name="content" style="resize: none;"><%= b.getBoardContent() %></textarea>
				
				<label for="exampleFormControlInput1" class="form-label"> 기존 사진 </label><br>
	<img src="<%=contextPath %>/resources/board_upfiles/<%= b.getTitleImg() %>" width="200px" height="150px"> 
			<br><br>
			<label for="exampleFormControlInput1" class="form-label"> 파일 첨부 </label><br>
     		
					<img id="titleImg"  width="150" height="120">
					
			<div id="fileArea">
				<input type="file" name="file1" id="file1"
					onchange="loadImg(this, 1);">
			</div>
	
	<br>
			<div>
			<input type="checkbox" id="evt" name="evt" value="1">
						<label for="sports">이벤트 시작</label>
						
			<input type="checkbox" id="evt" name="evt" value="2">
			<label for="climbing">이벤트 종료</label>
			</div>

			<div class="btns" align="center">
				<button type="submit" id="bt">수정하기</button>
			</div>
			
		</form>
		<br>
	<%@ include file="../common/footer.jsp" %>
	
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


	</div>
	
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