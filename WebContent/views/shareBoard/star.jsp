<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.wrap{
    max-width: 480px;
    margin: 0 auto; /* 화면 가운데로 */
    background-color: #fff;
    height: 100%;
    padding: 20px;
    box-sizing: border-box;

}
.reviewform textarea{
    width: 100%;
    padding: 10px;
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
    background-image: url('../../resources/images/star/star.png');
    background-repeat: no-repeat;
    background-size: 60px 60px;
    cursor: pointer;
}
.rating .rate_radio:checked + label {
    background-image: url('../../resources/images/star/star2.png');
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
</style>
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<div class="wrap">
 
    <form name="reviewform" id= "reviewform" class="reviewform" method="post" action="">

        
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
           	<input type="checkbox" id="chk_info">불친절
            <button type="button" onclick="star();">별점주기</button>
        
    </form>
    
    <script>
  //별점 마킹 모듈 프로토타입으로 생성
  
    

	    
	    
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
    
    function star(){
		$('#reviewform').each(function(){
		    console.log("실행되니?");
		    $("#reviewform").attr("action", "<%=request.getContextPath()%>/Star.bo");
			$("#reviewform").submit();
		    
		});
		 
		
	}
    </script>
</div>
</body>
</html>