<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.team3.member.model.vo.Member"%>
    
 <%
	
	String nickName = ((Member)request.getSession().getAttribute("loginUser")).getNickname();
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content = "text/html; charset = UTF-8">
 	<meta name = "viewport" content = "width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="resources/css/chat_css/bootstrap.css">
 	<link rel="stylesheet" href="resources/css/chat_css/custum.css">
	<title>채팅방</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/js/chat/bootstrap.js"></script>
	
	<script type = "text/javascript">
		var lastNo = 0;
		function submitFunction(){
			var nickName = "<%=nickName%>";
			var chatName = nickName;
			
			var chatContent = $('#chatContent').val();
			$.ajax({
				type : "POST",
				url : "ChatSubmitServlet",
				data : {
					chatName : chatName,
					chatContent : chatContent
				},
				success : function(result){
					if(result == 1){
						autoClosingAlert('#successMessage',5000);
					}else if (result == 0){
						autoClosingAlert('#dangerMessage',5000);
					}else{
						autoClosingAlert('#warningMessage',5000);
					}
				}
				
			});
			$('#chatContent').val('');
		}
		function autoClosingAlert(selector,delay){
			var alert = $(selector).alert();
			alert.show();
			window.setTimeout(function(){
				alert.hide()
			}, delay);
		}
		
		function chatListFunction(type){
			$.ajax({
				type : "POST",
				url : "ChatListServlet",
				data : {
					listType : type,
				},
				success : function(data){
					if(data == "") return;
					var parsed = JSON.parse(data);		
					var result = parsed.result;
					
					for(var i = 0; i < result.length; i++){
						addChat(result[i][0].value, result[i][1].value, result[i][2].value);
					}
					lastNo = Number(parsed.last);
				
				}
				
			});
			
		}
		
		
		function addChat(chatName, chatContent,chatTime){
			$('#chatList').append('<div class="row">' +
					'<div class = "col-lg-12">' +
					'<div class = "media">' + 
					'<a class = "pull-left" href = "#">' +
					'<img class = "media-object img-circle" src="resources/images/chat/user.png" alt="">'  +
					'</a>' +
					'<div class = :"media-body">' +
					'<h4 class = "media-heading>">' +
					chatName +
					'<span class = "small pull-right">' +
					chatTime+
					'</span>' +
					'</h4>' + 
					'<p>' +
					chatContent + 
					'</p>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'<hr>');
			$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
			
		}
	
		function getInfiniteChat(){
			setInterval(function(){
				
				chatListFunction(lastNo);
				
			},1000);
		}
	</script>
</head>
<body>
	<div class = "container">
		<div class = "container bootstrap snippet">
			<div class = "row">	
				<div class = "col-xs-12">
					<div class = "portlet portlet-default">
						<div class = "portlet-title">
							<h4><i class = "fa fa-circle text-green"></i>채팅방</h4>
						</div>
						<div class = "clearfix"></div>
					</div>
					<div id = "chat" class = "panel-collapse collapse in">
						<div id = "chatList" class = "portlet-body chat-widget" style = "overflow-y : auto; width : auto; height : 550px;">
						</div>
					<div class = "portlet-footer">
						
						<div class = "row" style = "height: 90px">
							<div class = "form-group col-xs-10">
								<textarea style = "height : 80px" id = "chatContent" class = "form-control" placeholder ="메세지를 입력하세요" maxlength = "100"></textarea>
							</div>
							<div class = "form-group col-xs-2">
								<button type = "button" class = "btn btn-default pull-right" onclick = "submitFunction();">전송</button>
								<div class = "clear-fix">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class = "alert alert-success" id = "successMessage" style = "display:none;">
		<strong>메세지 전송 성공!</strong>
		</div>
		<div class = "alert alert-danger" id = "dangerMessage" style = "display:none;">
			<strong>이름,내용 둘다 입력!</strong>
		</div>
		<div class = "alert alert-warning" id = "warningMessage" style = "display:none;">
			<strong>DB오류!</strong>
		</div>
	</div>
	
	
	<script type = "text/javascript">
		$(document).ready(function(){
			chatListFunction('today'); 
			getInfiniteChat();
			
		});
	</script>
	
	
</body>
</html>