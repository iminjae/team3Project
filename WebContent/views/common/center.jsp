<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.ArrayList, com.kh.team3.eventBoard.model.vo.*" pageEncoding="UTF-8"%>
    
    <% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
   	ArrayList<Board> listtwo = (ArrayList<Board>)request.getAttribute("listtwo");       
   	String[] countb = (String[])request.getAttribute("countb");
   	String[] countr = (String[])request.getAttribute("countr");
     
   
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


.table4_11 table {
	width:100%;
	margin:15px 0;
	border:0;
}
.table4_11 th {
	background-color: rgb(23 ,62 ,96);
	color:#FFFFFF
}
.table4_11,.table4_11 th,.table4_11 td {
	font-size:0.95em;
	text-align:center;
	padding:4px;
	border-collapse:collapse;
}
.table4_11 th,.table4_11 td {
	border: 1px solid #7ebffe;
	border-width:1px 0 1px 0
}
.table4_11 tr {
	border: 1px solid #7ebffe;
	font-weight: bold;
}
.table4_11 tr:nth-child(odd){
	background-color:#b4dafe;
}
.table4_11 tr:nth-child(even){
	background-color:#fdfdfd;
}


#tdr{
	border : 5px solid rgb(23 ,62 ,96);
	
}
#imgg {
  width: 300px;
  height: 150px;
  object-fit: cover;
}

#hh{
	font-family: "돋움", dotum, "굴림", gulim, arial, helvetica, sans-serif;
}
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
					<img id="imgg" src="<%=request.getContextPath()%>/resources/board_upfiles/<%=b.getTitleImg()  %>">
					<h4 class="visual-title"> &lt;<%=b.getBoardTitle() %>&gt;</h4>
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
			<h3 class="sec-tit-1">BEST USER</h3>
			<ul class="best-book-list grid">
				<li class="grid-item">
				<p id="hh"> <a href="#">댓글 순위</a></p> 
					<table class=table4_11>
<tr>
	<th width="70px">랭킹</th><th width="70px">아이디</th><th width="70px">칭호</th>
</tr>
<tr>
	<td>1</td><td><%=countb[0] %></td><td>VVVIP</td>
</tr>
<tr>
	<td>2</td><td><%=countb[1] %></td><td>VVIP</td>
</tr>
<tr>
	<td>3</td><td><%=countb[2] %></td><td>VIP</td>
</tr>

</table>
					
				
				
					</table>
					
				</li>
				<li class="grid-item">
				<p id="hh"> <a href="#">게시글 순위</a></p> 
										<table class=table4_11>
<tr>
	<th width="70px">랭킹</th><th width="70px">아이디</th><th width="70px">칭호</th>
</tr>
<tr>
	<td>1</td><td><%=countr[0] %></td><td>KKKIP</td>
</tr>
<tr>
	<td>2</td><td><%=countr[1] %></td><td>KKIP</td>
</tr>
<tr>
	<td>3</td><td><%=countr[2] %></td><td>KIP</td>
</tr>

</table>
					
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