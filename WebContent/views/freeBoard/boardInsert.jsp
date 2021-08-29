<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	button{
  		background-color: rgb(53,61,64);
  		color: rgb(255,255,255);
  	}	
  	h2{
  		color: rgb(232,180,81);
  	}
  	th{
  		
  		color: rgb(232,180,81);
  	}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
	
	
	<div class="outer">
		<br>
		
		<h2>게시글 작성하기</h2>
		<br>
		
		<form id="insertForm" action="<%= request.getContextPath()%>/write.bo" method="post" >
			<table align="center">
				<tr>
					<th width="100">분야</th>
					<td width="500">
						<select name="categoryNo">
							<option value="6">잡담</option>
							<option value="7">유머</option>
							<option value="5">기타</option>

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
				
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			</div>
		</form>
	</div>
		<%@include file = "../common/footer.jsp" %>
</body>
</html>