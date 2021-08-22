<%@page import="com.kh.team3.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member loginUser = (Member) request.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous" />
<style></style>
<title>SellBoard_Insert</title>
</head>

<body>
	<!-- 메뉴바 -->
	<%@ include file="../common/menubar.jsp"%>
	<!-- 메인 -->

	<form id="insertForm"
		action="<%=request.getContextPath()%>/sellInsert.bo" method="post"
		enctype="multipart/form-data">


		<div class="container">
			<h2 class="text-center">판매글 등록</h2>
			<br>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">제목</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="title">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">판매 가격</label>
				<div class="col-md-9">
					<div class="input-group mb-3">
						<input type="number" class="form-control" name="price"> <span
							class="input-group-text">원</span>
					</div>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">판매 카테고리</label>
				<div class="col-md-9">
					<div class="col-auto">
						<select class="form-select" aria-label="Default select example"
							name="category">
							<option selected>판매물품을 선택해주세요</option>
							<option value="1">태블릿</option>
							<option value="2">데스크탑</option>
							<option value="3">노트북</option>
							<option value="4">스마트폰</option>
							<option value="5">기타</option>
						</select>
					</div>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">대표 이미지</label>
				<div class="col-md-9">
					<div class="alert alert-secondary" role="alert">
						<ul>
							<li>이미지 사이즈 : 350 * 350</li>
							<li>파일 사이즈 : 1M 이하</li>
							<li>파일 확장자 : png, jpg만 가능</li>
						</ul>
					</div>
					<img id="titleImg" width="150" height="120">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">판매물품 이미지</label>
				<div class="col-md-9">
					<div class="alert alert-secondary" role="alert">
						<ul>
							<li>최대 3개까지 등록가능</li>
							<li>이미지 사이즈 : 700 * 700</li>
							<li>파일 사이즈 : 1M 이하</li>
							<li>파일 확장자 : png, jpg만 가능</li>
						</ul>
					</div>
					<table>
						<tr>
							<td><img id="contentImg1" width="150" height="120"></td>
							<td><img id="contentImg2" width="150" height="120"></td>
							<td><img id="contentImg3" width="150" height="120"></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-md-3 col-form-label">판매물품 설명</label>
				<div class="col-md-9">
					<textarea name="content" class="form-control"
						id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
				</div>
			</div>
			<!--이벤트를 걸어놓음/ 파일에 따른 함수 호출  -->
			<div id="fileArea">
				<input type="file" name="file1" id="file1"
					onchange="loadImg(this, 1);"> <input type="file"
					name="file2" id="file2" onchange="loadImg(this, 2);"> <input
					type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
				<input type="file" name="file4" id="file4"
					onchange="loadImg(this, 4);">
			</div>
			<br>

			<div class="mb-3 row">
				<div class="col-6 d-grid p-1">
					<!-- 뒤로 버튼 어디로연결할지 -->
					<button type="button" class="btn btn-lg btn-outline-secondary"
						onclick="location.href=#">버튼</button>
				</div>
				<div class="col-6 d-grid p-1">
					<input class="btn btn-lg btn-outline-primary" type="submit"
						value="제출하기">
					</button>
				</div>
			</div>
		</div>
	</form>



	<!-- 하단부-->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>

	<script>
        $(function(){
            $("#fileArea").hide();
            
            $("#titleImg").click(function(){
                $("#file1").click();
            });
            
            $("#contentImg1").click(function(){
                $("#file2").click();
            });
            
            $("#contentImg2").click(function(){
                $("#file3").click();
            });
            
            $("#contentImg3").click(function(){
                $("#file4").click();
            });
            
        });
        function loadImg(inputFile, num){
            if(inputFile.files.length ==1){ // inputFile 에 파일이 존재하면
                var reader = new FileReader(); //파일 리더 객체를 생성해서
                reader.readAsDataURL(inputFile.files[0]); // 해당파일을 읽어 문자열로 저장하는 메소드
                reader.onload = function(e){ //파일 읽기가 완료되면
                    // 읽은 파일의 번호를 src 속성으로 부여할거임
                    switch(num){
                    case 1 : $("#titleImg").attr("src",e.target.result);break;
                    case 2 : $("#contentImg1").attr("src",e.target.result);break;
                    case 3 : $("#contentImg2").attr("src",e.target.result);break;
                    case 4 : $("#contentImg3").attr("src",e.target.result);break;
                    }
                }
            }
        }
        </script>


</body>
</html>
