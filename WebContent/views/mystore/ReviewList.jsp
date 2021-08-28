<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.sellBoard.model.vo.*" %>
<%
	String msg = (String)request.getAttribute("msg");
	String rno = (String)request.getAttribute("rno");
	String userId = (String)request.getAttribute("userId");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/review/reviewForm.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.wrap{
    max-width: 480px;
    margin: 0 auto; /* 화면 가운데로 */
    background-color: #fff;
    height: 100%;
    padding: 20px;
    box-sizing: border-box;

}
.rating .rate_radio {
    position: relative;
    display: inline-block;
    z-index: 20;
    opacity: 0.001;
    width: 60px;
    height: 60px;
    background-color: #fff;
    cursor: pointer;
    vertical-align: top;
    display: none;
}
.rating .rate_radio + label {
    position: relative;
    display: inline-block;
    margin-left: -4px;
    z-index: 10;
    width: 60px;
    height: 60px;
    background-image: url('resources/images/star/star.png');
    background-repeat: no-repeat;
    background-size: 60px 60px;
    cursor: pointer;
}
.rating .rate_radio:checked + label {
    background-image: url('resources/images/star/star2.png');
}



.warning_msg {
    display: none;
    position: relative;
    text-align: center;
    background: #ffffff;
    line-height: 26px;
    width: 100%;
    color: red;
    padding: 10px;
    box-sizing: border-box;
    border: 1px solid #e0e0e0;
}

.review_rating{
	 text-align: center;
	 margin-left :  -50px;
	 margin-top : 20px;
	 margin-bottom : 20px;
}

/*s내꺼 CSS*/
  /*전체 크기 조절*/
        .allreviewForm{
            width: 500px;
            height: 650px; 
        }

        .middle{
          background-color: rgb(161, 165, 166);
          border: 1px solid black;
          width:480px;
          height: 600px; 
          margin-top: 20px;
          margin-left: 10px;
          border-radius: 8px;
        }

        /*리뷰쓰기*/
        .reviewWriteTag{
          font-size: 21px;
          font-weight: 800;
          color: rgb(232, 180, 81);
          margin-top: -52px;
          text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
          
        }

        /*폼*/
        .reviewWriterform{
            margin-top: -20px;
            margin-left: 20px;
            width: 480px;
            height: 480px; 
            border-radius: 8px;
        }

        /*00께 드리는 후기*/
        .toSellerTag{
            padding-top: 5px;
            margin-left: -50px;
            text-align: center;
            margin-top: -10px;
        }

        /*텍스트아리아*/
        .WriteTextArea{
            width: 400px;
            height: 100px;
            border-radius: 5px;
            border: 0;
            outline: 0;
            border : 5px solid rgb(232, 180, 81);
            margin-left: 13px;
            margin-top: -2px;
            color: rgb(23, 62, 96);
   
        }


        /*체크박스*/
        input[name="review"]{
          background-color: salmon;
        }

        input[name="review"] + label{
           width: 25px;
           height: 25px;
        }

        /*등록 버튼*/
        .reviewFormBtn{
            text-align: center;
            border: 0;
            outline: 0;
            background-color: rgb(23, 62, 96);
            color: white;
            margin-left: -30px;
            padding-top: 5px;
            font-weight: 900;
            border-radius: 5px;
        }

        .reviewFormBtn:hover{
            text-align: center;
            border: 0;
            outline: 0;
            color : rgb(23, 62, 96);
            background-color: white;
          
        }

        .radio{
            margin-left: 30px;
            margin-top: -20px;
        }

        /*깃털사진*/
        .reviewFormImg{
            width: 60px;
            height: 50px;
            margin-left: 70px;
            margin-top: 20px;
        }

        /*거래는 ~ goodbad*/
        .goodbad{
            color: rgb(232, 180, 81);
            font-weight: 900;
            text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
            margin-top: -15px;
        }

        /*거래는 괜찮았나요?*/
        .okTag{
            text-align: center;
            margin-left: -70px;


        }

        /*체크박스위로*/
        .checkboxupup{
            margin-top: -10px;

        }

</style>


</head>
<body>
  <div class="allreviewForm">
     <div class="middle">
        <img class="reviewFormImg" src="resources/images/MyStore/reviewFormImg.png">
        <p class="reviewWriteTag" align="center">리뷰 쓰기</p>
      
        <div class="reviewWriterform">
            <p class="toSellerTag"><%=userId %> 님께 드리는 후기 </p>
            <form action="<%=request.getContextPath()%>/reviewform.rv" id="updateForm" method="post" name="testForm" >
				<input  type="hidden" name="rno" value="<%= rno %>"/>
                <input  type="text" class="WriteTextArea" name="content" placeholder="리뷰는 솔직하게 작성해주세요"/><br>
                <br>
                <div class="radio">
                    <p class="okTag">거래는 괜찮았나요?</p>
                    <p class="goodbad">👍 GOOD</p>

                    <div class="checkboxupup">
                        <input type="checkbox" name="review" id="review1" value="친절하고 매너가 좋아요"/><label for="review1">친절하고 매너가 좋아요</label> <br>
                        <input type="checkbox" name="review" id="review2" value="시간 약속을 잘 지켜요"/><label for="review2">시간 약속을 잘 지켜요</label><br>
                        <input type="checkbox" name="review" id="review3" value="제가 있는 곳까지 와서 거래 했어요"/><label for="review3">제가 있는 곳까지 와서 거래 했어요</label><br>
                        <input type="checkbox" name="review" id="review4" value="응답이 빨라요"/><label for="review4">응답이 빨라요</label><br>
                    </div>
                    
                    <br>

                    <p class="goodbad" >👎 BAD</p>
                    <div class="checkboxupup">
                        <input type="checkbox" name="review" id="chk_info" value="불친절 해요"/><label for="chk_info">불친절 해요</label><br>
                        <input type="checkbox" name="review" id="review6" value="시간 약속을 잘 안지켜요"/><label for="review6">시간 약속을 잘 안지켜요</label><br>
                        <input type="checkbox" name="review" id="review7" value="응답이 느려요"/><label for="review7">응답이 느려요</label>
                    </div>

                </div>    
                
               
		        
		        
		 <!-- 명선님 파트 -->
		 <input type="hidden" name="userId" value="<%= userId %>">
		 
	        <div class="review_rating">
	            <div class="rating">
	                <!-- 해당 별점을 클릭하면 해당 별과 그 왼쪽의 모든 별의 체크박스에 checked 적용 -->
	                <input type="checkbox" name="rating" id="rating1" value="1" class="rate_radio" title="1점">
	                <label for="rating1"></label>
	                <input type="checkbox" name="rating" id="rating2" value="2" class="rate_radio" title="2점">
	                <label for="rating2"></label>
	                <input type="checkbox" name="rating" id="rating3" value="3" class="rate_radio" title="3점" >
	                <label for="rating3"></label>
	                <input type="checkbox" name="rating" id="rating4" value="4" class="rate_radio" title="4점">
	                <label for="rating4"></label>
	                <input type="checkbox" name="rating" id="rating5" value="5" class="rate_radio" title="5점">
	                <label for="rating5"></label>
	            </div>
	        </div>
	        
	      
	           	<input type=hidden name="rate" id="rate" value="0"/>
	          

		        
		        
		        <div align="center">
		        	<input type="button" class="reviewFormBtn" name="reviewFormBtn" value="등록"onclick="alertfun();"/>&nbsp;&nbsp;
		        </div>
		        
		        
		        
		        
            </form>
        </div>

        
    </div>
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
    
    
    <script>
    <!-- 명선님 파트 -->
    function Rating(){};
      
      Rating.prototype.rate = 0;
      Rating.prototype.setRate = function(newrate){
          //별점 마킹 - 클릭한 별 이하 모든 별 체크 처리
          this.rate = newrate;
          let items = document.querySelectorAll('.rate_radio');
          items.forEach(function(item, idx){
              if(idx < newrate){
                  item.checked = true;
              }else{
                  item.checked = false;
              }
          });
      }
      let rating = new Rating();//별점 인스턴스 생성
      
      document.addEventListener('DOMContentLoaded', function(){
          //별점선택 이벤트 리스너
          document.querySelector('.rating').addEventListener('click',function(e){
              let elem = e.target;
              if(elem.classList.contains('rate_radio')){
                 
                  if ($("input:checkbox[id='chk_info']").is(":checked")){
                  		
                  	$('#rate').val(parseInt("-"+elem.value));
                  	
                  	
                  }else{
                  	 $('#rate').val(elem.value);
                  }

                  rating.setRate(parseInt(elem.value));
                
                

              		   
              }
          })
      });
    
    </script>
</body>
</html>