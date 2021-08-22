<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, com.kh.team3.eventBoard.model.vo.*" pageEncoding="UTF-8"%>
    
<% 
	Board b = (Board)request.getAttribute("b"); 
	Attachment fileList = (Attachment)request.getAttribute("fileList");

	
%>
  <%   
   String contextPath = request.getContextPath();
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


	#contentArea{
		height:50px;
	}
	
	.detail td{
		text-align:center;
		border:1px solid white;
	}
	.detailImgArea{
		width:220px;
		height:190px;
	}
		.listArea{
		width:760px;
		height:550px;
		margin:auto;
	}
	.thumbnail{
		display:inline-block;
		width:220px;
		border:1px solid white;
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
	<input type="submit" id="ch" class="list-group-item list-group-item-action" value="관리자 게시판" name="three">

</form>
  </div>
	
	
	<div class="outer">
	
		<br>
		<h2 align="center">사진게시판 상세보기</h2>
		<br>
		
		<table class="detail" align="center">
			<tr>
				<td width="70px">제목</td>
				<td colspan="5"><%= b.getBoardTitle() %></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%= b.getUserId() %></td>
				<td>조회수</td>
				<td><%= b.getBoardCount() %></td>
				<td>작성일</td>
				<td><%= b.getCreateDate() %></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="6">
					<p id="contentArea"><%= b.getBoardContent() %></p>
				</td>
			</tr>
			<tr>
				<td>대표사진</td>
				<td colspan="4">
					<div id="titleImgArea" align="center">
						<img width="500px" height="300px" id="titleImg" src="<%= contextPath %>/resources/board_upfiles/<%= fileList.getChangeName() %>">
					</div>
				</td>
				<td>
					<a download="<%=fileList.getOriginName() %>"  href="<%= contextPath %>/resources/board_upfiles/<%=fileList.getChangeName()%>">다운로드</a>
							</td>
			</tr>			
		</table>
		
		<table class="detail" align="center">
			<tr>
				
			</tr>
		</table>
		
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