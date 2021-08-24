<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.team3.freeBoard.model.vo.* ,com.kh.team3.member.model.vo.*,java.util.ArrayList" %>  

<%
   Board b = (Board)request.getAttribute("b");
   Member loginUser = ((Member) request.getSession().getAttribute("loginUser"));
  	ArrayList<Reply>  rlist = (ArrayList<Reply>)request.getAttribute("list");

	

%>  
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
   .outer{
      width:800px;
      height:500px;
      margin:auto;
      margin-top:50px;
   }
   
   
   .outer>table{
      width:100%;

   }
   
   .outer>table p{
      height:230px;
      margin:0;
   }
   
   .replyArea{
      width:800px;
      margin:auto;
   }
   #addReply{

   }
   
   table {
       width: 100%;
       border-bottom: 1px solid #444444;
       border-collapse: collapse;
     }
  
   /* 글 내용의 경계선 표시 */
   .content{
      border: 1px solid #cecece;
   }

	#replyWrite{
		width:100%;	
	}
   .replyArea form textarea, .comments form button{
      float: left;
   }
   .replyArea li{
      clear: left;
   }
   .replyArea  textarea{
      width: 90%;
      height: 100%;
      align:center;
   }
  

   .replyArea{
      position: relative;
   }
	hr{
		width:800px;
	}
	#replyList{
	  	border-collapse: separate;
 		 border-spacing: 0 10px;
		width:100%;
		height:30px;
	}
</style>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
      <br>
      
      <h2>자유 게시판</h2>
      <br>
      
      <table align="center">
         
   

	 <tr>
            
             
            <th width="10%">[<%= b.getCategoryNo() %>]</th>
            <th colspan="2" align="left"><%= b.getBoardTitle() %></th>
            
         </tr>
         <tr>
            <td rowspan="2" height="100">프로필사진</td>
            <th width="100" colspan="2" height="70" align="left"><%= b.getUserId() %></th>
            
         </tr>
         <tr>
            <td><%= b.getCreateDate() %></td>
            <td align="right">조회수 : <%= b.getBoardCount() %></td>
         </tr>
      </table>
      <br>
      <table>
         <tr>
            <td><p><%= b.getBoardContent() %>
            
            
            </p></td>
         </tr>
      </table>
      <br>
      <div class="btns" align="right">
         <button type="button" onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=1';">목록으로</button>
 			
			<% if(loginUser != null && loginUser.getUserId().equals(b.getUserId())){ %>
            
            <button type="button" onclick="updateForm();">수정하기</button>
            <button type="button" onclick="deleteBoard();">삭제하기</button>
         <% } %>
      </div>

			
		</div>
		
		<form action="" id="postForm" method="post">
			<input type="hidden" name="bno" value="<%= b.getBoardNo() %>">
		</form>
		<script>
			function updateForm(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/updateForm.fbo");
				$("#postForm").submit();
			}
			
			function deleteBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/deleteB.fbo");
				$("#postForm").submit();
			}
		</script>
		<br>
		<hr>	
	</div>
	
<!-- 댓글 관련 영역 -->
	<div class="replyArea">
		<!-- 댓글 작성하는 div -->
		<table id="replyWrite">
			<tr>
				<th>댓글작성</th>
				<td><textarea rows="3" cols="60" id="replyContent" style="resize:none;"></textarea></td>
				<td><button id="addReply">댓글등록</button></td>
				
			
			</tr>
		</table>
		
		
		<!-- 댓글 리스트들 보여주는 div -->
		<div id="replyListArea">
			<form action="" id="form" method="post">
				<table id="replyList">
					
				</table>
				<input type="hidden" name="bno" value="<%=b.getBoardNo()%>">
			</form>
	<script>
			function deleteReply(){
				$('#form').each(function(){
				    
				    $("#form").attr("action", "<%=request.getContextPath()%>/ReplyDelete.bo");
					$("#form").submit();
				    
				});
				 
				
			}
	</script>
	<br>
	</div>
	</div> 
		<form action="" id="postForm" method="post">
			<input type="hidden" name="bno" value="<%=b.getBoardNo()%>">
		
		</form>
	
	<script>
			function deleteTBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/sellDelete.bo");
				$("#postForm").submit();
			}
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>
	
	$(function(){
		selectReplyList();
	
	})
	
	function selectReplyList(){
		$("#replyList").empty();
		$("#addReply").click(function(){
			var content = $("#replyContent").val();
			var bno = <%=b.getBoardNo() %>;
			
			$.ajax({
				url : "rinsert.fbo",
				type : "post",
				data : { content : content,
							bno:bno},
				success : function(status){
					if(status == "success"){
						selectReplyList();
						$("#replyContent").val();
					
					}
				},
				error:function(){
					console.log("통신실패 댓글 등록");
				}
			})
			
		})
		
	}
		$.ajax({
			url :"rlist.fbo",
			data : {bno : <%=b.getBoardNo()%>
					
					},
			type:"get",
			success  : function(list){
				
				
				var value="";
				
				
				for(var i in list){
					value += '<tr>' + 
					'<td width ="10%">' + list[i].userId + '</td>' +
					'<td width ="57%">' + list[i].replyContent + '</td>' +
					'<td width ="13%">' + list[i].createDate + '</td>' +
					'<td width ="10%">' + 
					'<td ><input type="hidden" name="rno" value ="'+list[i].replyNo+'"></td>'+
					'<td><button type="button" onclick="deleteReply();">'+'삭제하기'
					'</button></td>'+
					'</tr>';
					
				}
				$("#replyList").html(value);
			},
			error:function(){
				console.log("ajax 통신실패 _ 댓글조회");
			}
			
		})
		
	
	</script>

	<%@include file = "../common/footer.jsp" %>
</body>
</html>