<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 게시판</title>
</head>

<link rel="stylesheet" href="resources/css/report_css/reportView.css">


<body>
	   <table class="list">
        <thead>
           <tr>
              <th width="100">BoardNo.</th>
              <th width="400">Title</th>
              <th width="80">Author</th>
               <th width="50">Count</th>
              <th width="200">CreatDate</th>           
           </tr>
        </thead>
          <div class="myboardlist">
              <tbody>
              <% if(myboard.isEmpty()){ %>
                 <tr>
                  <td colspan="5">작성한 게시글이 없습니다.</td>
                </tr>
             <% }else{  %>
                    <% for(Review rv : myboard){ %>
                       <tr>
             
                               <td><%= rv.getBoardNo() %></td>
                               <td><%=  "[ "+ rv.getBoardtypeName() +" ] "+ rv.getBoardTitle() %></td>
                               <td><%= rv.getUserId() %></td>
                                <td><%= rv.getCount() %></td>
                               <td><%= rv.getCreateDate() %></td>                           
                       </tr>
                    <% } %>   
             <% } %>                   
              </tbody>
            </div>
         
    </table>
</body>
</html>