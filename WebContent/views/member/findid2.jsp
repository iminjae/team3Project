<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
	Member list = (Member)request.getAttribute("list");

%>
<meta charset="UTF-8">
<title>Insert title </title>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources\css\login.css">
   <Style>
   
body{

    font-weight: bold;
}
.top{

    margin-top: 100px;
}

.center{
    height: 60%;
    margin-bottom: 280px;
}

.footer{
    font-size: x-small;
    text-align: center;
   
  
}

#logo{
    display: block;
  
    margin: auto;
    width: 300px;
    height: 200px;
}

.login{
    text-align: center;
}


#idPath, #pwdPath{
   
    width: 400px;
    height: 45px;
    margin-top: 10px;
}

#path{
    width: 410px;
    height: 45px;
    margin-top: 20px;
    background-color: rgb(232,180, 81);
    font-size: large;
    font-weight: bold;
    color: white;
}

#line{
    width: 410px;
    color: rgb(201, 210, 214);
    border: solid 1px rgb(201, 210, 214);
}

.check{
   

    margin-right: 300px;
    margin-top: 3px;
    margin-bottom: 3px;
}

.find{
   margin-top: 100px;
    text-align: center;
}

#footerimg{
 margin-top: 4px;
width: 20px;
height: 20px;
}

   


   </Style>

</head>
<body>




    <div class="top">

        <img src="resources\images\common\logo2.png" id="logo">

    </div>

    <div class="center">

        <form class="login" method="post"  action="<%=request.getContextPath() %>/findid.me"
          onSubmit="return LoginValidate();">
        <input type="text"  id="idPath" name="id" value="<%=list.getUserId()%>" disabled> <br>


            <br>

    <div class="check">
  
</div>
    
    <hr id="line">
</form>




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
    

</script>
   
</body>
</html>