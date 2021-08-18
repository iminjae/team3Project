<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
      crossorigin="anonymous"
    />
    <style>
      .card {
        margin-bottom: 10px;
      }
    </style>
    <title>Product_list</title>
  </head>

  <body>
  <!-- 상단 navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Soldout</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="#">홈</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="#">전자제품</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">의류</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">식품</a>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
            <button class="btn btn-outline-success" type="submit">
              Search
            </button>
          </form>
        </div>
      </div>
    </nav>
    <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
    <!-- 메인 -->
    <main class="mt-3">
      <div class="container">
        <div class="row mb-2">
          <div class="col-12">
            <select class="form-select">
              <option selected>메뉴 선택</option>
              <option value="1">노트북</option>
              <option value="2">모니터</option>
              <option value="3">마우스/키보드</option>
            </select></div>
        </div>
        <div class="row g-3">
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <a href="product_detail.html"><img
                src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250170m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="keyboard"
              /></a>
              <div class="card-body">
                <h5 class="card-title">
                  K70 RGB MK.2 BROWN 기계식 게이밍 키보드 갈축
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">악세사리</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">219,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/224/1589848609891m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  로지텍 MX VERTICAL 인체공학 무선 마우스
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">악세사리</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">119,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="https://www.pickby.co.kr/shop/data/goods/1582502673284m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  벤큐 BenQ EW2480 모니터, 선명한 화질&생생한 사운드
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">모니터</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">169,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="https://www.pickby.co.kr/shop/data/goods/1583211255510m0.png?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  라인프렌즈 젤리빔 초미니 스마트 프로젝터 JB-100
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">빔프로젝터</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">249,900원</small>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <main class="mt-3">
      <div class="container">
        <div class="row g-3">
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/162/1578368250170m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="keyboard"
              />
              <div class="card-body">
                <h5 class="card-title">
                  K70 RGB MK.2 BROWN 기계식 게이밍 키보드 갈축
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">악세사리</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">219,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="http://earlyadopter.godohosting.com/goods_earlyadopter_godo_co_kr/224/1589848609891m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  로지텍 MX VERTICAL 인체공학 무선 마우스
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">악세사리</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">119,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="https://www.pickby.co.kr/shop/data/goods/1582502673284m0.jpg?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  벤큐 BenQ EW2480 모니터, 선명한 화질&생생한 사운드
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">모니터</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">169,000원</small>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-4 col-md-6">
            <div class="card" style="width: 18rem">
              <img
                src="https://www.pickby.co.kr/shop/data/goods/1583211255510m0.png?cache_ver=2021021601"
                class="card-img-top"
                alt="mouse"
              />
              <div class="card-body">
                <h5 class="card-title">
                  라인프렌즈 젤리빔 초미니 스마트 프로젝터 JB-100
                </h5>
                <p class="card-text">
                  <span class="badge bg-dark">전자제품</span></h1>
                  <span class="badge bg-dark">컴퓨터</span></h1>
                  <span class="badge bg-dark">빔프로젝터</span></h1>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                  </div>
                <small class="text-dark">249,900원</small>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <footer class="mt-5 py-5 bg-dark">
      <div class="row">
        <div class="col-12 col-md">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
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
