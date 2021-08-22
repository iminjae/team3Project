<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Insert title </title>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources\css\login.css">
   

</head>
<body>




    <div class="top">

        <img src="resources\images\common\logo2.png" id="logo">

    </div>

    <div class="center">

        <form class="login" method="post"  action="<%=request.getContextPath() %>/login.me"
			 onSubmit="return LoginValidate();">
        <input type="text"  id="idPath" name="id" placeholder="아이디">  <br>
        <input type="password" id="pwdPath" name="pw" placeholder="비밀번호">    
            <br>
        <input type="submit" value="로그인" id="path">

    <div class="check">
    <input type="checkbox" id="session"> <label>로그인 유지</label>
</div>
    
    <hr id="line">
</form>


<div class="find">

    <a href="" id="idfind">아이디 찾기</a>
    <span> | </span>
    <a href="" id="pwdfind">비밀번호 찾기</a>
    <span> | </span>    
    <a href="views\member\createUser.jsp" id="createuser">회원가입</a>

</div>


</div>
    



    <div class="footer">
      
        <a href="" id="idfind">이용약관</a>
        <span> | </span>
        <a href="" id="pwdfind">중고거래 주의사항</a>
        <span> | </span>    
        <a href="" id="pwdfind">중고거래 법적사항</a>
        <span> | </span>    
        <a href="" id="pwdfind">고객센터</a>
        
        <br>
        <div class="footer2">
            <img src="resources\images\common\logo2.png" id="footerimg">
            Copyright All Rights Reserved.

        </div>
        
        
        

    </div>
    
<script>


	
</body>
</html>