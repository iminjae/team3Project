<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member "%>
<%
int starpoint = (int)((Member)request.getSession().getAttribute("loginUser")).getStartpoint();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystore/Tracking.css" rel="stylesheet" type="text/css">
<link href="resources/css/mystore/SideBar.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	 <div class="content" width="1500px">
    <div class="leftpanel">
    	 <div class="mypoint">
            <p id="ptagstar">⭐내별점⭐</p>
            <P id="pointtt"><%=starpoint %>point</P>
            <div id="myProgress">
                <progress id="my" value='<%=starpoint %>' max='100' ></progress>
            </div>
       </div>
      <p class="title">My Store</p>
      <div id="menu">
        <button onclick="location.href='<%=request.getContextPath()%>/myboard.ms'">내 게시글</button><br>
        <button onclick="location.href='<%=request.getContextPath()%>/like.ms'">찜♡</button><br>
          <button onclick="location.href='<%=request.getContextPath()%>/myreview.ms'">내가 쓴 리뷰</button><br>
        <button id="now" onclick="location.href='<%=request.getContextPath()%>/tracking.ms'">배송 조회</button><br>
      </div>
    </div>

    <div class="center">
   	  <br>
	  <p class="title2">배송 조회</p>
	  
      <div>
          <img class="deliveryimg" src="resources/images/MyStore/banner.png" >
      </div>

      <div>
        <img class="named" src="resources/images/MyStore/company.png" >
      </div>

 		
		<form action="http://info.sweettracker.co.kr/tracking/5" method="post" >
	           <div class="form-group">
	             <input type="hidden" class="form-control" id="t_key" name="t_key"  value ="4vPfmmCdDZ7ywycOTz5biQ">
	           </div>
	           <div>
			           <div class="form-group">
			             택배사 선택
			             <select  class="form-control" name="t_code" id="t_code">
		             	  <option>택배사 선택</option>
			              <option value="04">대한 통운</option>
			              <option value="01">우체국 택배</option>
			              <option value="46">CU 편의점 택배</option>
			              <option value="05">한진 택배</option>
			              <option value="06">로젠 택배</option>
			              <option value="08">롯데 택배</option>
			              <option value="45">호남 택배</option>
			              <option value="24">CVSent 편의점 택배</option>
			              <option value="53">농협 택배</option>
			              <option value="23">경동 택배</option>
			              <option value="18">건영 택배</option>
			              <option value="20">한덱스</option>
			             </select>
			            </div>
			            
			            <div class="form-group">
			              운송장 번호
			              <input style="margin-top: 30px;" type="text" class="form-control" name="t_invoice" id="t_invoice" placeholder=" ' - ' 없이 입력해 주세요">
			            </div>
	           </div>
	           
	           <div>
		           <button class="btn" id="buttongo"type="submit">
		             배송조회 바로하기
		           </button>
	           </div>
	          
	      	</form>
	      	
	      	<br>
	      	<br>
	      	<br>
	      	<br>
	<script>
        window.onload=function(){
            var elem = document.getElementById("my");   
            var width = 10;
            var id = setInterval(frame, 10);
            function frame() {
            if (width >= 100) {
                clearInterval(id);
            } else {
                width++; 
                elem.style.width = width + '%'; 
            }
            }

        }
   </script>
	 
     	
</body>
</html>