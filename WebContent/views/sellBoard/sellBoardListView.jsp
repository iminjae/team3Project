<%@page import="com.kh.team3.sellBoard.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList, com.kh.team3.member.model.vo.Member"
	pageEncoding="UTF-8"%>

<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
String one = "1";
String two = "2";
String three = "3";
String four = "4";
String five = "5";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous" />
<style>
.card {
	margin-bottom: 10px;
	display: inline-block;
}

.listArea {
	width: 760px;
	height: 550px;
	margin: auto;
}

.thumbnail {
	display: inline-block;
	width: 220px;
	margin: 10px;
}

.thumbnail:hover {
	opacity: 0.7;
	cursor: pointer;
}

.card-columns { @include media-breakpoint-only(lg) { column-count:4;
	
}

@
include media-breakpoint-only(xl) {
	column-count: 5;
}
}
</style>
<title>SellBoard_List</title>
</head>

<body>
	<!-- 메뉴바 -->
	<%@ include file="../common/menubar.jsp"%>

	<!-- 메인 -->
	<div class="container">
		<h2 class="text-center">판매 게시판</h2>


		<!-- 로그인유저가 있으면 게시글 작성 -->
		<div align="right">
			<%if (userId != null) {%>
			<button class="btn btn-outline-secondary"
				onclick="location.href='<%=request.getContextPath()%>/sellInsertForm.bo'">작성하기</button>
			<%}%>
		</div>
		<br>

		<!-- margin -->
		<div class="container">
			<div class="row mb-2">
				<div class="col-12">
					<!-- 검색바길이 -->
					<select class="form-select" onchange="location.href=this.value">
						<option selected>카테고리 선택</option>
						<option
							value="<%=request.getContextPath()%>/sellCategoryList.bo?category=<%=one %>">태블릿</option>
						<option
							value="<%=request.getContextPath()%>/sellCategoryList.bo?category=<%=two %>">데스크탑</option>
						<option
							value="<%=request.getContextPath()%>/sellCategoryList.bo?category=<%=three %>">노트북</option>
						<option
							value="<%=request.getContextPath()%>/sellCategoryList.bo?category=<%=four %>">핸드폰</option>
						<option
							value="<%=request.getContextPath()%>/sellCategoryList.bo?category=<%=five %>">기타</option>
					</select>
				</div>
			</div>
			<div class="col-xl-3 col-lg-4 col-md-6">
				<!-- container 안에서 컴포넌트 요소 정렬 -->
				<%
						for (Board b : list) {
						%>
				<div class="thumbnail" align="center">
					<input type="hidden" value="<%=b.getBoardNo()%>">
					<div class="card" style="width: 220px;">
						<img
							src="<%=request.getContextPath()%>/resources/board_upfiles/<%=b.getTitleImg()%>"
							width="200px" height="150px" class="card-img-top" />

						<div class="card-body">
							<p class="card-text">
							<h4>
								<span class="badge bg-secondary"><%=b.getCategoryName()%></span>
								<%if (b.getBoardStatus().equals("판매중")) {%>
								<span class="badge bg-primary">판매중</span>

								<%} else if (b.getBoardStatus().equals("예약중")) {%>
								<span class="badge bg-success">예약중</span>

								<%} else if (b.getBoardStatus().equals("판매완료")) {%>
								<span class="badge bg-warning">판매완료</span>
								<%}%>
							</h4>

							<br>
							<h5 class="card-title"><%=b.getBoardTitle()%></h5>							
							<span><%=b.getUserId()%></span>
							<br><br>
							
							<div class="d-flex justify-content-between align-items-center">
								<!--추천수, 조회수, 찜하기?-->
								<!-- 버튼 필요시 연결-->
								<!-- <div class="btn-group" role="group">
                         			 <button type="button" class="btn btn-sm btn-outline-secondary">버튼1</button>
                          			 <button type="button" class="btn btn-sm btn-outline-secondary">버튼2</button>
                        			</div> -->
								<small class="text-dark">조회수 <%=b.getbCnt()%></small> <small
									class="text-dark" align="right">추천수 <%=b.getLikeCnt()%></small>
							</div>
						</div>
					</div>
				</div>
				<%}%>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous">
	</script>

	<script>
		
			$(function(){
				$(".thumbnail").click(function(){
					var bNo = $(this).children().eq(0).val();
					location.href="<%=request.getContextPath()%>/sellDetail.bo?bNo="+ bNo; });
			});
			
	</script>

</body>
</html>