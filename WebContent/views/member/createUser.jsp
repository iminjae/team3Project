<%@ page language="java" contentType="text/html; charset=UTF-8"
  import = "java.util.ArrayList, com.kh.team3.member.model.vo.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");




%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>


  <link href="resources\css\create.css" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
 #id{
        margin-left: 105px;
     }

     #idCheckBtn{
         width: 100px;
         height: 45px;
     }
</style>
</head>
<body>

<div class="all">

    <div class="top"  >

        <img src="resources\images\common\logo2.png" id="logo">

    </div>

   
	<form id="createUser" method="post"  action="<%=request.getContextPath() %>/insert.me"
			 onSubmit="return joinValidate();">


      	<input type="text"  id="id" name="id" placeholder="아이디" maxlength="13" required> 
      	<button type="button" id="idCheckBtn" onclick="checkId();">중복 확인 </button>
      	 <br>
    	   <span id="idspan"></span>  
        <br>
    	
        <input type="password" id="pwd" name="pw" placeholder="비밀번호">  <br>  
           <span id="pwspan"></span>  
        <br>
        
      
        <input type="password" id="pwdcheck" name="pw2" placeholder="비밀번호확인">   <br> 
           <span id="pwspan2"> </span> 
        <br>
        
    
        <input type="text" id="name" name="name" placeholder="이름">    <br>
           <span id="namespan"></span>  
        <br>
        
        
        <input type="text" id="phone" name="phone" placeholder="핸드폰 반호">    <br>
         <span id="phonespan"></span>  
        <br>
      
        
       
        <input type="text" id="nickname" name="nickname" placeholder="닉네임">  <br>  
   <span id="nickspan"></span>  
        <br>

        <input type="text" id="address" name="address"  placeholder="주소">  <br>  
        
        <label>카테고리 선택 :  </label>
        <select id="select" name="gory">
            
            <option value="1">태블릿</option>
            <option value="2">데스크탑</option>
            <option value="3">핸드폰</option>
            <option value="4">기타</option>


        </select>
        <br>


        <input type="submit" value="회원가입" id="path">

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
	

	
	if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#createUser input[name=id]").val()))){
		$("#createUser input[name=userId]").focus();
        return false;
	}
	
	if($("#createUser input[name=pw]").val() != $("#createUser input[name=pw2]").val()){
		$("#pwspan").text("비밀번호와 확인이 일치하지 않습니다.").css("color", "red");
		$("#pwspan2").text("비밀번호와 확인이 일치하지 않습니다.").css("color", "red");
		
		return false;			
	}
	
	 if(!(/^[가-힣]{2,}$/.test($("#createUser input[name=name]").val()))){
		 $("#createUser input[name=name]").focus();
        return false;
	 }
	 
	 return true;
	
	
}

function checkId(){
    var userId = $("#createUser input[name=id]");
    if(userId.val() ==""){ //값이 없다면
       alert("아이디를 입력해주세요");
       return false;
    }
    
    $.ajax({ // 값이 있다면 ajax를 통해
       url:"idCheck.me",
       type:"post",
       data: {userId : userId.val()},
       success:function(result){
          if(result =="fail"){
             alert("사용할수 없는 아이디 입니다");
             userId.focus();
          }else{
             if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){
                userId.attr("readonly", "true");
              
             }else{
                userId.focus();
             }
          }
       },
       error:function(){
          console.log("서버통신실패");
       }
    })
}
</script>



</body>
</html>