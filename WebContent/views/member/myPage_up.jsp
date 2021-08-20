<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
    
<%
String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
String userName = ((Member)request.getSession().getAttribute("loginUser")).getUserName();
String phone = ((Member)request.getSession().getAttribute("loginUser")).getPhone();
String nickName = ((Member)request.getSession().getAttribute("loginUser")).getNickname();
String address = ((Member)request.getSession().getAttribute("loginUser")).getAddress();


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
    margin-left: 500px;

	#exampleInputEmail1{
		margin-top : 30px;
	}

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
    <a href="<%=request.getContextPath()%>/MyPageMove.me"><button type="button" class="list-group-item list-group-item-action">탈퇴하기</button> </a>
    <a href="<%=request.getContextPath()%>/MyPageUpdateMove.me"> <button type="button" class="list-group-item list-group-item-action">회원정보 수정</button> </a>
    <a href="<%=request.getContextPath()%>/MyPageMove.me"> <button type="button" class="list-group-item list-group-item-action" disabled>관리자 게시판</button> </a>


  </div>

 <div class="del">
 
	<form>
  <div class="form-group">
    <label for="exampleInputEmail1">아이디</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<%=userId%>" disabled>
    
    <label for="exampleInputEmail1">이름</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<%=userName%>">
    
    <label for="exampleInputEmail1">PHONE</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<%=phone%>">
    
    <label for="exampleInputEmail1">닉네임</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<%=nickName%>">
    
    <label for="exampleInputEmail1">주소</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<%=address%>">
  </div>
  
  <div class="form-group">
    <label for="exampleInputFile">파일 업로드</label>
    <input type="file" id="exampleInputFile">
 
  </div>

      <input type="submit" value="탈퇴하기" id="xkfxhl">
</form>
  </div>

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