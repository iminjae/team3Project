<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.ArrayList, com.kh.team3.eventBoard.model.vo.*" pageEncoding="UTF-8"%>
    
    <% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
   	ArrayList<Board> listtwo = (ArrayList<Board>)request.getAttribute("listtwo");       
	
     
   
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources\css\main.css">
<script src="resources\js\jquery.js"></script>
<script src="resources\js\jquery.bxslider.min.js"></script>
<script src="resources\js\isotope.pkgd.min.js"></script>
<script src="resources\js\main.js"></script>

<style>

</style>

</head>
<body>

<!--콘테이너 영역-->
	<div id="container">
		<section id="main-visual" class="rounded">
			<h3 class="blind">HOT BOOK</h3>
			<ul class="main-visual-slide">
			<%for(Board b : listtwo){ %>
				<li>
					<div class="visual-item-wrap item1">
					<img src="<%=request.getContextPath()%>/resources/board_upfiles/<%=b.getTitleImg()  %>">
					<h4 class="visual-title"> &lt;<%=b.getBoardTitle() %>&gt;</h4>
					<p>
					<span> <%=b.getBoardContent() %></span>
					</p>
					<p class="detail-view"><a href="<%=request.getContextPath()%>/detailuser.th?bNo=<%=b.getBoardNo() %>">자세히 보기</a></p>
					</div>
				</li>
			 	<%} %>
			</ul>
		</section>
		<section id="notice-tab-wrap" class="rounded">
			<h3 class="sec-tit-1">NOTICE &amp; NEWS</h3>
			<h4 class="tab-btn-1"><a href="#" class="on">공지사항</a></h4>
			<div class="tab-container-1">
				<ul>
					<li><a href="#">공지사항 관련된 내용입니다.</a><span>2017.08.07</span></li>
					<li><a href="#">공지사항 관련된 내용입니다.</a><span>2017.08.07</span></li>
				</ul>
				<p class="icon-more"><a href="#">more</a></p>
			</div>
			<h4 class="tab-btn-2"><a href="#">새소식</a></h4>
			<div class="tab-container-2">
				<p class="no-write">등록된 내용이 없습니다.</p>
			</div>
		</section>
		<section id="best-book-wrap">
			<h3 class="sec-tit-1">BEST BOOK</h3>
			<ul class="best-book-list grid">
				<li class="grid-item">
					<p><a href="#">  </a></p>
					<p><a href="#"><img src="resources\images\main\3.jpg" alt=""></a></p>
				</li>
				<li class="grid-item">
					<a href="#"><img src="resources\images\main\3.jpg" alt=""></a>
				</li>
				<li class="grid-item">
					<p><a href="#"><img src="Wresources\images\main\3.jpg" alt=""></a></p>
					<p><a href="#"><img src="resources\images\main\3.jpg" alt=""></a></p>
				</li>
				<li class="grid-item">
						<a href="#"><img src="resources\images\main\3.jpg" alt=""></a>
				</li>
			</ul>
		</section>
	</div>
</body>
</html>