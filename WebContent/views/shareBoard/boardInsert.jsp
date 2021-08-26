<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.team3.member.model.vo.Member" %>
<%
Member loginUser = (Member) request.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
   crossorigin="anonymous" />
<style>
	.outer{
		width:800px;
		

		margin:auto;
		margin-top:50px;
	}
	
	#insertForm>table{
		width:100%;
		border:1px solid white;
	}
	
	#insertForm>table input, #insertForm>table textarea{
		width:100%;
		box-sizing:border-box;
	}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
	
	
	<div class="outer">
		<br>
		
		<h2>나눔글 작성하기</h2>
		<br>
		
		<form id="insertForm" action="<%= request.getContextPath()%>/write.sbo" method="post"enctype="multipart/form-data" >
			<table align="center">
				<tr>
					<th width="100">분야</th>
					<td width="500">
						<select name="categoryNo">
							<option value="1">태블릿</option>
							<option value="2">데스크탑</option>
							<option value="3">노트북</option>
							<option value="4">스마트폰</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" name="content" style="resize:none;"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><img id="img1" width="330" height="200"><img id="img2" width="330" height="200"></td>
					
				</tr>
				
			</table>
			<div id="fileArea">
				<input type="file" name="Sfile1" id="Sfile1" onchange="loadImg(this, 1);"> 
				<input type="file" name="Sfile2" id="Sfile2" onchange="loadImg(this, 2);"> 
			
			</div>
			<br>
			
			<div class="btns" align="center">
				<button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			</div>
		</form>
	</div>
		<%@include file = "../common/footer.jsp" %>
		
		<script>
		$(function() {
			$("#fileArea").hide();

			$("#img1").click(function() {
				$("#Sfile1").click();
			});
			
			$("#img2").click(function() {
				$("#Sfile2").click();
			});

		});
		function loadImg(inputFile, num){
			if(inputFile.files.length == 1){ //파일 존재하면
				var reader = new FileReader();
				reader.readAsDataURL(inputFile.files[0]); //파일을 읽어들이는 메소드
				console.log(inputFile );
				console.log(num );
				reader.onload = function(e){
					switch (num) {
					case 1: $("#img1").attr("src", e.target.result); break;
					case 2: $("#img2").attr("src", e.target.result); break;
					default: break;
					}
				}
			}
		}
		
	</script>
	 <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
      crossorigin="anonymous"></script>
</body>
</html>