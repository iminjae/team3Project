
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, com.kh.team3.sellBoard.model.vo.*, com.kh.team3.member.model.vo.Member" pageEncoding="UTF-8"%>
<% 
	Board b = (Board)request.getAttribute("b"); 
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	Attachment titleImg = fileList.get(0);
	String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();

%>    

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous"/>

    <title>SellBoard_detail</title>
  </head>
  <style>
    .card {
      margin-bottom: 10px;
    }
   
    #contentArea{
      height:50px;
    }
    
    #btn1{
      width:200px;
		  height:50px;    
    }
    #btn2{
      width:200px;
		  height:50px; 
      margin-left: -150px;    
    }
    #btn3{
      width:200px;
		  height:50px; 
      margin-left: -300px;    
    }

    /* .detail td{
      text-align:center;
      border:1px solid white;
    } */
    /* .detailImgArea{
      width:220px;
      height:190px;
    } */
  </style>

  <body>
  <!-- 메뉴바 -->
  <%@ include file = "../common/menubar.jsp" %>

  <!-- 메인 -->
    <main class="mt-3">
      <div class="container">
        <div class="row">
          <div class="col-md-5">
            <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-ride="carousel">
              <ol class="carousel-indicators">
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
              </ol>
              <!--이미지-->
              <!--for문 돌리면서 이미지 가져와서 보여주기-->
              <div class="carousel-inner">
                <% for(int i=1; i<fileList.size(); i++){ %>
                <div class="carousel-item active">
                  <img src="#" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="#" class="d-block w-100" alt="...">
                </div>
                <% } %>
              </div>
              <!--이미지 이전 버튼-->
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </a>
               <!--이미지 다음 버튼-->
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </a>
            </div>
          </div>
         
          <!-- 판매제품 소개 -->
          <!-- 제목, 가격, 작성자, 조회수, 설명내용-->
          
       
            <div class="col-md-7">   
              <h4> <span class="badge bg-secondary">카테고리</span></h4>            
              <div class="card shadow-sm" style="width:50em;">      
                <div class="card-body"> 
                  <h3 class="card-title">제목</h3>
                  <p class="card-text border-top pb-3"></p>
                  <div class="row pt-3 pb-3">
                    <div class="col-6">
                      <h3>총 상품 금액</h3>
                    </div>
                    <div class="col-6" style="text-align: right;">
                      <h3>000000원</h3>
                    </div>
                  </div>
                  <p class="card-text border-top pb-3"></p>
                  <p class="card-text pb-3">
                     안내사항 있으면 적는 공간...
                  </p>

                  <!-- 버튼 만들기(찜, 추천, 1:1 채팅)-->
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="col-6 d-grid p-1">
                      <button id="btn1" type="button" class="btn btn-outline-secondary" onclick="location.href='#'">좋아요👍</button>
                    </div>
                    <div class="col-6 d-grid p-1">
                      <button id="btn2" type="button" class="btn btn-outline-secondary" onclick="location.href='#'">찜❤</button>
                    </div>
                    <div class="col-6 d-grid p-1">
                      <button id="btn3" type="button" class="btn btn-outline-secondary" onclick="location.href='#'">1:1채팅</button>
                    </div>
                  
                  </div>
                </div>
              </div>
            </div>
        
        <br>

        <!--판매상품 설명글-->
        <div class="row">
          <div class="col-12">
            <p id="contentArea">내용</p>
          </div>
        </div>
      </div>
      
      
     
        </main>

        <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
          crossorigin="anonymous"
        ></script>
        
  </body>
</html>
