<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
      crossorigin="anonymous"
    />
</head>
<body>
 <%--메뉴바 --%>
 <%@ include file = "../common/menubar.jsp" %>
 
 <%--메인 --%>
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
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250170m0.jpg?cache_ver=2021021601" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250813m2.jpg?cache_ver=2021021601" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250328m4.jpg?cache_ver=2021021601" class="d-block w-100" alt="...">
                </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </a>
            </div>
          </div>

          <div class="col-md-7">
            <div class="card shadow-sm" style="width:50em;">
              <div class="card-body">
                <h5 class="card-title">K70 RGB MK.2 BROWN 기계식 게이밍 키보드 갈축</h5>
                <h5 class="card-title pt-3 pb-3 border-top">219,000원</h5>
                <p class="card-text border-top pt-3 pb-3">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">악세사리</span></h1>
                </p>
                <p class="card-text pb-3">
                  배송비 2,500원 | 도서산간(제주도) 배송비 추가 5,000원 | 택배배송 | 5일 이내 출고 (주말, 공휴일 제외)
                </p>
                <p class="card-text border-top pb-3">
                  <div class="row">
                    <div class="col-auto">
                      <label class="col-form-label">구매수량</label>
                    </div>
                    <div class="col-auto">
                      <div class="input-group mb-3">
                        <span class="input-group-text">-</span>
                        <input type="text" class="form-control" style="width:40px;" value="1">
                        <span class="input-group-text">+</span>
                      </div>
                    </div>
                  </div>
                </p>
                <div class="row pt-3 pb-3">
                  <div class="col-6">
                    <h3>총 상품 금액</h3>
                  </div>
                  <div class="col-6" style="text-align: right;">
                    <h3>219,000원</h3>
                  </div>
                </div>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-dark">장바구니 담기</button>
                  </div>
                  <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-danger">주문하기</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <img src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/0ac90345448ccd5c.jpg" class="img-fluid" alt="">
          </div>
        </div>
      </div>
    </main>

    <footer class="mt-5 py-5 bg-dark">
      <div class="row">
        <div class="col-12 col-md">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="none"
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            class="d-block mb-2"
            role="img"
            viewBox="0 0 24 24"
          >
            <title>Product</title>
            <circle cx="12" cy="12" r="10" />
            <path
              d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"
            />
          </svg>
          <small class="d-block mb-3 text-muted">&copy; 2017-2021</small>
        </div>
        <div class="col-6 col-md">
          <h5>Features</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Cool stuff</a></li>
            <li><a class="link-secondary" href="#">Random feature</a></li>
            <li><a class="link-secondary" href="#">Team feature</a></li>
            <li><a class="link-secondary" href="#">Stuff for developers</a></li>
            <li><a class="link-secondary" href="#">Another one</a></li>
            <li><a class="link-secondary" href="#">Last time</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>Resources</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Resource name</a></li>
            <li><a class="link-secondary" href="#">Resource</a></li>
            <li><a class="link-secondary" href="#">Another resource</a></li>
            <li><a class="link-secondary" href="#">Final resource</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>Resources</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Business</a></li>
            <li><a class="link-secondary" href="#">Education</a></li>
            <li><a class="link-secondary" href="#">Government</a></li>
            <li><a class="link-secondary" href="#">Gaming</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>About</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Team</a></li>
            <li><a class="link-secondary" href="#">Locations</a></li>
            <li><a class="link-secondary" href="#">Privacy</a></li>
            <li><a class="link-secondary" href="#">Terms</a></li>
          </ul>
        </div>
      </div>
    </footer>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
      crossorigin="anonymous"
    ></script>
</body>
</html>