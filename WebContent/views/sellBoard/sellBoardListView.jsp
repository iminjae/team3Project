<%@page import="com.kh.team3.sellBoard.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.ArrayList" pageEncoding="UTF-8"%>
    
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
    crossorigin="anonymous"/>
    <style>
        .card {
            margin-bottom: 10px;
        }

        .listArea{
            width:760px;
            height:550px;
            margin:auto;
        }
        .thumbnail{
            display:inline-block;
            width:220px;
            border:1px solid white;
            margin:10px;
        }
        .thumbnail:hover{
            opacity:0.7;
            cursor:pointer;
        }

    </style>
    <title>Product_list</title>
  </head>

  <body>
    <!-- 메뉴바 -->
    <%@ include file = "../common/menubar.jsp" %>

    <!-- 메인 -->
    <div class="container">
        <h2 class="text-center">판매 게시판</h2>
        <br>
        <main class="mt-3">
            <div class="container">
              <div class="row mb-2">
                <div class="col-12">
                  <select class="form-select">
                      <option selected>메뉴 선택</option>
                      <option value="1">태블릿</option>
                      <option value="2">데스크탑</option>
                      <option value="3">노트북</option>
                      <option value="4">핸드폰</option>
                      <option value="5">기타</option>
                  </select>
                  </div>
              </div>
              <div class="row g-3">
                <div class="col-xl-3 col-lg-4 col-md-6">
                  <div class="card" style="width: 18rem">
                    <a href="/sellDetail.bo"><img
                      src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250170m0.jpg?cache_ver=2021021601"
                      class="card-img-top"
                      alt="keyboard"
                    /></a>
                    
                    <div class="card-body">
                        <p class="card-text">
                            <h4> <span class="badge bg-secondary">카테고리</span></h4>
                        </p>
                      <h5 class="card-title">
                        제목
                      </h5>
                      <div class="d-flex justify-content-between align-items-center">
                        <!--추천수, 조회수, 찜하기?-->
                        
                        <!-- 버튼 필요시 연결-->
                        <!-- <div class="btn-group" role="group">
                          <button type="button" class="btn btn-sm btn-outline-secondary">버튼1</button>
                          <button type="button" class="btn btn-sm btn-outline-secondary">버튼2</button>
                        </div> -->
                      <small class="text-dark">가격 ---원</small>
                      </div>
                    </div>
                  </div>
                </div>
            </div> 
        <div class="listArea">
			<%for(Board b : list){ %>
			<div class="thumbnail" align="center">
				<input type="hidden" value="<%=b.getBoardNo()%>">
				<img src="<%=request.getContextPath() %>/resources/board_upfiles/<%= b.getTitleImg() %>" width="200px" height="150px"> <br>
				<p>
					No.<%= b.getBoardNo() %>  <%=b.getBoardTitle() %> <br>
					조회수 : <%=b.getCount() %>
				</p>
			</div>
			<%} %>
		
			
			<br><br>
			<div align="center">
			
	
      </div>
    </main>


    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
