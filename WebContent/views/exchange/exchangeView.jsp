<%@page import="com.kh.team3.sellBoard.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList, com.kh.team3.member.model.vo.Member"
	pageEncoding="UTF-8"%>

<%
ArrayList<Exchange> list = (ArrayList<Exchange>) request.getAttribute("list");
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
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
	border: 1px solid blue;
	margin: 10px;
}

.thumbnail:hover {
	opacity: 0.7;
	cursor: pointer;
}
</style>
<title>Product_list</title>
</head>

<body>
	<!-- 메뉴바 -->
	<%@ include file="../common/menubar.jsp"%>

	<!-- 메인 -->
	<div class="container">
		<h2 class="text-center">물물교환 게시판</h2>

		<div align="right">

			<%
			if (userId != null) {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/sellInsertForm.bo'">작성하기</button>
			<%
			}
			%>
		</div>
		<br>
		<main class="mt-3">
			<div class="container">
				<div class="row g-3">
					<div class="col-xl-3 col-lg-4 col-md-6">
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
										<span class="badge bg-success"><%=b.getBoardStatus() %></span>
									</h4>
									</p>
									<h5 class="card-title">
										<%=b.getBoardTitle()%>
									</h5>
									<div class="d-flex justify-content-between align-items-center">
									
										<small class="text-dark">조회수 <%=b.getbCnt()%></small>
									</div>
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</main>


		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous">
		</script>

		<script>
		
			$(function(){
				$(".thumbnail").click(function(){
					var bNo = $(this).children().eq(0).val();
					location.href="<%=request.getContextPath()%>/sellDetail.bo?bNo="+ bNo;
								});
			});
		</script>
</body>
</html>