<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.sellBoard.model.vo.*" %>
<%
	String msg = (String)request.getAttribute("msg");
	String rno = (String)request.getAttribute("rno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/review/reviewForm.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


</head>
<body>
	 <div class="all">
        <h4 align="center">리뷰 쓰기</h4>
        <div class="form">
            <p align="center">☆ 판매자께 드리는 후기 ☆</p>
            <form action="<%=request.getContextPath()%>/reviewform.rv" id="updateForm" method="post" name="testForm" >
				<input  type="hidden" name="rno" value="<%= rno %>"/>
                <input  type="text" class="reviewtext" name="content" placeholder="리뷰는 솔직하게 작성해주세요"/><br>
                <br>
                <div class="radio">
                    <p>Good</p>
                    <input type="checkbox" name="review" id="review1" value="친절하고 매너가 좋아요"/><label for="review1">친절하고 매너가 좋아요</label> <br>
                    <input type="checkbox" name="review" id="review2" value="시간 약속을 잘 지켜요"/><label for="review2">시간 약속을 잘 지켜요</label><br>
                    <input type="checkbox" name="review" id="review3" value="제가 있는 곳까지 와서 거래 했어요"/><label for="review3">제가 있는 곳까지 와서 거래 했어요</label><br>
                    <input type="checkbox" name="review" id="review4" value="응답이 빨라요"/><label for="review4">응답이 빨라요</label><br>
                    
                    <br>

                    <p>Bad</p>
                    <input type="checkbox" name="review" id="review5" value="불친절 해요"/><label for="review5">불친절 해요</label><br>
                    <input type="checkbox" name="review" id="review6" value="시간 약속을 잘 안지켜요"/><label for="review6">시간 약속을 잘 안지켜요</label><br>
                    <input type="checkbox" name="review" id="review7" value="응답이 느려요"/><label for="review7">응답이 느려요</label>
               
                </div>    
                
                 <div align="center">
			        <%-- <input type="submit" name="btnOk" id="btnOk" value="리뷰 등록">--%>
		        	<input type="button" name="btnOk" value="등록"onclick="alertfun();"/>&nbsp;&nbsp;
		        </div>
            </form>
        </div>
        <br>
       
    </div>

    <script>
    	function alertfun()
    	{

    		var params = $("#updateForm").serialize();
    		$.ajax(
    		{
    			url : 'reviewform.rv',
    			data : params,
    			success : function(xh)
    					{			
    						alert("성공적으로 리뷰를 등록하였습니다.");
    						window.close();
    					}
    		});

    	}
    	
    </script>
</body>
</html>