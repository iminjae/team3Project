
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList, com.kh.team3.sellBoard.model.vo.*, com.kh.team3.member.model.vo.Member, com.kh.team3.mystore.model.vo.Review"
	pageEncoding="UTF-8"%>
<%

	
	ArrayList<Attachment> fileList = (ArrayList<Attachment>) request.getAttribute("fileList");
	String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
	Board b = (Board) request.getAttribute("b");
	Review rv = (Review)request.getAttribute("review");
%>


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

<title>SellBoard_detail</title>
<link href="resources/css/mystore/reviewForm.css" rel="stylesheet" type="text/css">
</head>
<style>
.card {
	margin-bottom: 10px;
}

#contentArea {
	height: 50px;
}

#btn1 {
	width: 150px;
	height: 50px;
}

#btn2 {
	width: 150px;
	height: 50px;
	margin-left: -100px;
}

#btn3 {
	width: 150px;
	height: 50px;
	margin-left: -200px;
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
	<%@ include file="../common/menubar.jsp"%>

	<!-- 메인 -->
	<main class="mt-3">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div id="carouselExampleIndicators"
						class="carousel carousel-dark slide" data-bs-ride="carousel">
						<ol class="carousel-indicators">
							<li data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="0" class="active"></li>
							<li data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="1"></li>
							<li data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="2"></li>
						</ol>
						<!--이미지-->
						<!--for문 돌리면서 이미지 가져와서 보여주기-->

						<div class="carousel-inner">
							<% for (int i = 0; i < fileList.size(); i++) { %>
							<div class="carousel-item active ">

								<img width="400px" height="500px"
									src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
									class="d-block w-100" alt="...">

							</div>

							<div class="carousel-item ">
								<img width="400px" height="500px"
									src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
									class="d-block w-100" alt="...">
							</div>

							<div class="carousel-item ">
								<img width="400px" height="500px"
									src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
									class="d-block w-100" alt="...">
							</div>

							<% } %>

						</div>

						<!--이미지 이전 버튼-->
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-bs-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="visually-hidden">Previous</span>
						</a>
						<!--이미지 다음 버튼-->
						<a class="carousel-control-next" href="#carouselExampleIndicators"
							role="button" data-bs-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="visually-hidden">Next</span>
						</a>
					</div>
				</div>

				<!-- 판매제품 소개 -->
				<!-- 제목, 가격, 작성자, 조회수, 설명내용-->


				<div class="col-md-7">
					<h4>

						<span class="badge bg-secondary"><%=b.getCategoryName() %></span>
						<button id="rvbtn" onclick="makeReview();">리뷰 쓰기</button>	

					</h4>
					<div class="card shadow-sm" style="width: 50em;">
						<div class="card-body">
							<h3 class="card-title"><%=b.getBoardTitle()%>
							</h3>
							<p class="card-text border-top pb-3"></p>
							<div class="row pt-3 pb-3">
								<div class="col-6">
									<h3>판매 금액</h3>
								</div>
								<div class="col-6" style="text-align: right;">
									<h3><%=b.getPrice()%>
										원
									</h3>
								</div>
							</div>
							<p class="card-text border-top pb-3"></p>
							<p class="card-text pb-3">안내사항 있으면 적는 공간...</p>

							<!-- 버튼 만들기(찜, 추천, 1:1 채팅)-->
							<div class="d-flex justify-content-between align-items-center">
								<div class="col-6 d-grid p-1">
								
									<button id="btn1" type="button"
										class="btn btn-outline-secondary" onclick="location.href='#'">좋아요👍</button>
								</div>
								<div class="col-6 d-grid p-1">
									<button id="btn2" type="button"
										class="btn btn-outline-secondary" onclick="location.href='#'">찜❤</button>
								</div>
								<div class="col-6 d-grid p-1">
									<button id="btn3" type="button"
										class="btn btn-outline-secondary" onclick="location.href='<%=request.getContextPath()%>/ChatServlet'">1:1채팅</button>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<br>

			<!--판매상품 설명글-->
			<div class="row">
				<div class="col-12">
					<p id="contentArea"><%=b.getBoardContent()%></p>
				</div>
			</div>
		</div>

	</main>
	<!-- 댓글 관련 영역 -->
	<div class="replyArea" align="center">
		<!-- 댓글 작성하는 div -->
		<table border="1" align="center">
			<tr>
				<th>댓글작성</th>
				<%
				if (userId != null) {
				%>
				<td><textarea rows="3" cols="60" id="replyContent"
						style="resize: none;"></textarea></td>
				<td><button id="addReply">댓글등록</button></td>

				<%
				} else {
				%>
				<td><textarea readonly rows="3" cols="60" id="replyContent"
						style="resize: none;">로그인한 사용자만 가능한 서비스입니다. 로그인 후 이용해주세요</textarea></td>
				<td><button disabled>댓글등록</button></td>
				<%
				}
				%>
			</tr>
		</table>

		<!-- 댓글 리스트들 보여주는 div  -->
		<div id="replyListArea">
			<table id="replyList" border="1" align="center">
			</table>
		</div>
	</div>

	<form action="" id="postForm" method="post">
		<input type="hidden" name="bNo" value="<%=b.getBoardNo()%>">
	</form>
	<div class="btns" align="center">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/sellList.bo?currentPage=1';">목록으로</button>

		<%
		if (userId != null && ((Member) request.getSession().getAttribute("loginUser")).getUserId().equals(b.getUserId())) {
		%>

		<!--<button type="button" onclick="updateTForm();">수정하기</button>  -->
		<button type="button" onclick="deleteTBoard();">삭제하기</button>
		<%
		}
		%>
	</div>
	<script>
			function updateTForm(){
				$("#postForm").attr("action", "<%=request%>/updateTForm.th");
				$("#postForm").submit();
			}
			
			function deleteTBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>
		/sellDelete.bo");
			$("#postForm").submit();
		}
	</script>
	<!-- 동적으로 작성될 수 있도록 ajax 이용 -->
	<script>
		$(function() {
			selectReplyList();
			$("#addReply").click(function() {
				var content = $("#replyContent").val();
				var bNo = <%=b.getBoardNo()%>;
	

				$.ajax({
					url : "rinsert.bo",
					type : "post",
					data : {
						content : content,
						bNo : bNo
					},
					success : function(status) {
						if (status == "success") {
							selectReplyList();
							$("#replyContent").val("");
						}
					},
					error : function() {
						console.log("ajax통신실패-댓글등록");
					}
				})

			})
		})
		function selectReplyList() {
			$("#replyList").empty();
			$.ajax({
				url : "rlist.bo",
				data : {
					bNo : <%=b.getBoardNo()%>
	
				},
				type : "get",
				success : function(list) {
					console.log(list)

					$.each(list, function(index, obj) {

						var writerTd = $("<td>").text(obj.replyWriter).attr(
								"width", "100px");
						var contentTd = $("<td>").text(obj.replyContent).attr(
								"width", "330px");
						var dateTd = $("<td>").text(obj.createDate).attr(
								"width", "150px");

						var tr = $("<tr>").append(writerTd, contentTd, dateTd);

						$("#replyList").append(tr);

					});

				},
				error : function() {
					console.log("ajax통신실패-댓글조회");
				}
			})
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous">
		
	</script>

	<script>
	   function makeReview(){
		   <%if( rv != null){ %>
			   $('#rvbtn').click( function() {
		            $(this).html('확인');
		        })
		   <%}else{%>
			  	var _width = '500';
			    var _height = '600';
			 
			    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
			    var _left = Math.ceil(( window.screen.width - _width )/2);
			    var _top = Math.ceil(( window.screen.height - _height )/2); 
			 
			    window.open('<%= request.getContextPath()%>/review.rv', '리뷰 쓰기', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
		   <%  }%>
		 
		
   		
   		}
   </script>

</body>
</html>
