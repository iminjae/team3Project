<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.ArrayList, com.kh.team3.eventBoard.model.vo.*" pageEncoding="UTF-8"%>
    
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
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

	.listArea{
		width:760px;
		height:550px;
		margin:auto;
		
	}
	.thumbnail{
		display:inline-block;
		width:220px;
		border:3px solid blue;
		margin:10px;
		 
		
	}
	.thumbnail:hover{
		opacity:0.7;
		cursor:pointer;
	}
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
	
	<div class="outer">
		<br>
		<h2 align="center">사진 게시판</h2>
		<br>
		
		<div class="listArea">
			<%for(Board b : list){ %>
			<div class="thumbnail" align="center">
				<input type="hidden" value="<%=b.getBoardNo()%>">	
				<img src="<%=contextPath %>/resources/board_upfiles/<%= b.getTitleImg() %>" width="200px" height="150px"> <br>
				<p>
					 <%=b.getBoardTitle() %> <br>
					조회수 : <%=b.getBoardCount() %>
				</p>
			</div>
			<%} %>
		
			
			<br><br>
			<div align="center">
			
		
			<button id="button" onclick="location.href='<%=request.getContextPath()%>/insertForm.th'">작성하기</button>
			</div>
		</div>
		<script>
		
			$(function(){
				$(".thumbnail").click(function(){
					var bId = $(this).children().eq(0).val();
					location.href="<%=contextPath%>/detail.th?bId=" + bId;
					 
				});
			});
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