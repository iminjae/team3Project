<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>


  <link href="..\..\resources\css\create.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="all">

    <div class="top"  >

        <img src="..\..\resources\images\common\logo2.png" id="logo">

    </div>

    <form id="createUser" action=/insert.me" method="post" onsubmit="return joinValidate();">
   
      	<input type="text"  id="id" name="id" placeholder="아이디" maxlength="13"> 
      	<button type="button" id="idCheckBtn" onclick="checkId()";>중복 확인 </button>
      	 <br>
    	
        <input type="password" id="pwd" name="pw" placeholder="비밀번호">  <br>  
      
        <input type="password" id="pwdcheck" name="pw2" placeholder="비밀번호확인">   <br> 
    
        <input type="text" id="name" name="name" placeholder="이름">    <br>
        
        <input type="text" id="phone" name="phone" placeholder="핸드폰 반호">    <br>
       
        <input type="text" id="nickname" name="nickname" placeholder="닉네임">  <br>  
        
        <input type="text" id="address" name="address"  placeholder="주소">  <br>  
        
        <label>카테고리 선택 :  </label>
        <select id="select" name="gory">
            
            <option value="1">태블릿</option>
            <option value="2">데스크탑</option>
            <option value="3">핸드폰</option>
            <option value="4">기타</option>


        </select>
        <br>


        <input type="submit" value="로그인" id="path">

    </form>


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
   
   function joinValidate(){
      
      if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
         $("#enrollForm input[name=userId]").focus();
           return false;
      }
      
      if($("#enrollForm input[name=userPwd]").val() != $("#enrollForm input[name=checkPwd]").val()){
         $("#pwdResult").text("비밀번호 불일치").css("color", "red");
         return false;         
      }
      
       if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
          $("#enrollForm input[name=userName]").focus();
           return false;
       }
       
       return true;
      
      
   }
   
   function checkId(){
      var userId = $("#enrollForm input[name=userId]");
      
      if(userId.val() ==""){
         alert("아이디를 입력해주세요");
         console.log("아이디를 입력해주세요");
         return false;
      }
      
      $.ajax({
         url : "idCheck.me",
         type: "post",
         data : {userId : id.val()},
         success:function(result){
            if(result == "fail"){
               alert("사용할 수 없는 아이디 입니다.")
               console.log("사용할 수 없는 아이디입니다.");
               }else{
                  if(confirm("사용가능한 아이디입니다 . 사용하시겠습니까?")){
                     userId.attr("readonly,ture");
                     $("#path").removeAttr("disabled");
                  }else{
                     userId.focus();
                  }
               }
         },
         error:function(){
            console.log("서버 통신 실패");
         }
         
      
      
      })
   }
   </script>



</body>
</html>