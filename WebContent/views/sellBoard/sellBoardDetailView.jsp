<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="java.util.ArrayList, com.kh.team3.sellBoard.model.vo.*, com.kh.team3.member.model.vo.Member, com.kh.team3.mystore.model.vo.Review"
   pageEncoding="UTF-8"%>
<%
Board b = (Board) request.getAttribute("b");
ArrayList<Attachment> fileList = (ArrayList<Attachment>) request.getAttribute("fileList");
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
String result = String.valueOf(request.getSession().getAttribute("result"));
Review rv = (Review) request.getAttribute("review");
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
<link href="resources/css/mystore/reviewForm.css" rel="stylesheet" type="text/css">
<link href="resources\css\common.css" rel="stylesheet" type="text/css">
<link href="resources\css\main.css" rel="stylesheet" type="text/css">
<title>SellBoard_Detail</title>
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
   margin-left: -80px;
}

#btn3 {
   width: 150px;
   height: 50px;
   margin-left: -160px;
}

.mt-3 {
   margin-left: 130px;
}

#replyList td {
   padding: 10px;
   vertical-align: top;
   border-bottom: 1px solid #ccc;
   font-size: 13px;
   vertical-align: top;
}

#replyList {
   border-collapse: separate;
   border-spacing: 1px;
   text-align: left;
   line-height: 1.5;
   margin: 20px 10px;
   text-align: center;
   border-left:none;
   border-right:none;
   
}

.replyArea {
margin-top: 70px;

}

.replyArea td{
   padding-left: 30px;
}

p{
   font-size: 1.3em;
}

</style>

<body>
   <!-- ????????? -->
   <%@ include file="../common/menubar.jsp"%>

   <!-- ?????? -->
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
                  <!--?????????-->
                  <!--for??? ???????????? ????????? ???????????? ????????????-->
                  <!-- ????????? ???????????????????????? ????????????... -->

                  <div class="carousel-inner">
                     <%for (int i = 0; i < fileList.size(); i++) {%>
                     <div class="carousel-item active ">
                        <img width="180px" height="280px"
                           src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
                           class="d-block w-100" alt="...">
                     </div>
                     <div class="carousel-item ">
                        <img width="180px" height="280px"
                           src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
                           class="d-block w-100" alt="...">
                     </div>
                     <div class="carousel-item ">
                        <img width="180px" height="280px"
                           src="<%=request.getContextPath()%>/resources/board_upfiles/<%=fileList.get(i).getChangeName()%>"
                           class="d-block w-100" alt="...">
                     </div>
                     <%}%>
                  </div>

                  <!--????????? ?????? ??????-->
                  <a class="carousel-control-prev" href="#carouselExampleIndicators"
                     role="button" data-bs-slide="prev"> <span
                     class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                     class="visually-hidden">Previous</span>
                  </a>
                  <!--????????? ?????? ??????-->
                  <a class="carousel-control-next" href="#carouselExampleIndicators"
                     role="button" data-bs-slide="next"> <span
                     class="carousel-control-next-icon" aria-hidden="true"></span> <span
                     class="visually-hidden">Next</span>
                  </a>
               </div>
            </div>

            <!-- ???????????? ?????? -->
            <!-- ??????, ??????, ?????????, ?????????, ????????????-->

            <div class="col-md-3">
               <div class="card shadow-sm" style="width: 45em;">
                  <div class="card-body">

                     <h4>
                        <span class="badge bg-secondary"><%=b.getCategoryName()%></span>
                        <%
                        if (b.getBoardStatus().equals("?????????")) {
                        %>
                        <span class="badge bg-primary">?????????</span>

                        <%
                        } else if (b.getBoardStatus().equals("?????????")) {
                        %>
                        <span class="badge bg-success">?????????</span>

                        <%
                        } else if (b.getBoardStatus().equals("????????????")) {
                        %>
                        <span class="badge bg-warning">????????????</span>
                        <button class="btn btn-sm btn-outline-warning" id="rvbtn" onclick="makeReview();">?????????</button>
                        <%
                        }
                        %>
                     </h4>
                     <br>
                     <p class="card-text pb-3" align="right"><%=b.getUserId()%>?????? ?????????</p>
                     
                     <br>
                     <p class="card-title"><%=b.getBoardTitle()%></p>
                     <p class="card-text border-top pb-3"></p>
                     <div class="row pt-3 pb-3">
                        <div class="col-6"><p>?????? ??????</p></div>
                        <div class="col-6" style="text-align: right;"><p><%=b.getPrice()%> ???</p></div>
                     </div>
                     <p class="card-text border-top pb-3"></p>

                     <!-- ?????? ?????????(???, ??????, 1:1 ??????)-->

                     <div class="d-flex justify-content-between align-items-center">

                        <div class="col-6 d-grid p-1">
                           <button id="btn1" type="button"
                              class="btn btn-outline-secondary" onclick="thumbsUp();">?????????????</button>
                        </div>
                        <div class="col-6 d-grid p-1">
                           <button id="btn2" type="button"
                              class="btn btn-outline-secondary" onclick="insertJjim();">???????</button>
                        </div>
                        <div class="col-6 d-grid p-1">
                           <button id="btn3" type="button"
                              class="btn btn-outline-secondary"
                              onclick="location.href='<%=request.getContextPath()%>/ChatServlet'">1:1??????????</button>
                        </div>

                     </div>
                  </div>
               </div>
            </div>
         </div>
         <br>
         <!--???????????? ?????????-->
         <div class="card col-md-8" style="width: 84.5em;">
            <div class="card-header" align="center"><p>???????????? ??????</p></div>
            <div class="card-body">
               <%=b.getBoardContent()%>
            </div>
         </div>
      </div>
   </main>
   <!-- ?????? ?????? ?????? -->
   <div class="replyArea" align="center">
      <!-- ?????? ???????????? div -->
      <table align="center">
         <tr>
            
            <%
            if (userId != null) {
            %>
            <td><textarea rows="4" cols="140" id="replyContent"
                  style="resize: none;"></textarea></td>
            <td><button class="btn btn-outline-secondary" id="addReply">????????????</button></td>

            <%
            } else {
            %>
            <td><textarea readonly rows="3" cols="60" id="replyContent"
                  style="resize: none;">???????????? ???????????? ????????? ??????????????????. ????????? ??? ??????????????????</textarea></td>
            <td><button disabled class="btn btn-outline-secondary">????????????</button></td>
            <%
            }
            %>
         </tr>
      </table>

      <!-- ?????? ???????????? ???????????? div  -->
      <form action="" id="form" method="post">
         <div id="replyListArea">
            <table id="replyList" border="1" align="center">
            </table>
         </div>
      </form>
   </div>

   <form action="" id="postForm" method="post">
      <input type="hidden" name="bNo" value="<%=b.getBoardNo()%>">
   </form>
   <div class="btns" align="center">
      <button type="button" class="btn btn-sm btn-outline-secondary"
         onclick="location.href='<%=request.getContextPath()%>/sellList.bo?currentPage=1';">????????????</button>

      <%
      if (userId != null && ((Member) request.getSession().getAttribute("loginUser")).getUserId().equals(b.getUserId())) {
      %>
      <button type="button" class="btn btn-sm btn-outline-secondary" onclick="updateSBForm();">????????????</button>
      <button type="button" class="btn btn-sm btn-outline-secondary" onclick="deleteSBoard();">????????????</button>
      <%
      }
      %>
   </div>
   <br><br>
   <script>
         function updateSBForm(){ // ??????????????? ??????
            $("#postForm").attr("action", "<%=request.getContextPath()%>/sellUpdateForm.bo");
            $("#postForm").submit();
         }
         
         function deleteSBoard(){ // ??????????????? ??????
            $("#postForm").attr("action", "<%=request.getContextPath()%>/sellDelete.bo");
            $("#postForm").submit();
      }
   </script>
   <!-- ?????? ?????? -->
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
                  console.log("ajax????????????-????????????");
               }
            })

         })
      })
      
      function selectReplyList() {
         $("#replyList").empty();
         $.ajax({
            url : "rlist.bo",
            data:{bNo:<%=b.getBoardNo()%>},
            type : "get",
            success : function(list) {
               console.log(list)

               var value="";

               for(var i in list){
                  <%=b.getBoardNo()%>
                  value += '<tr>'+
                           '<td width="100px">' + list[i].replyWriter+'</td>'+
                           '<td width="330px">' + list[i].replyContent+'</td>'+
                           '<td width="330px">' + list[i].createDate+'</td>'+
                           '<td><input type="hidden" name="bNo" value ="'+<%=b.getBoardNo()%>+'"></td>'+
                           '<td><input type="hidden" name="rNo" value ="'+list[i].replyId+'"></td>'+
                           '<td><button type="button" class="btn btn-sm btn-outline-secondary" onclick="deleteReply();">'+'???'
                           '</button></td>'+
                           '</tr>';                              
               }
               $("#replyList").html(value);

            },
            error : function() {
               console.log("ajax????????????-????????????");
            }
         })
      }
      
   </script>
   <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
      crossorigin="anonymous">
      
   </script>
   <!-- ????????? -->
   <script>
      function deleteReply(){
         console.log("???????????????")
         $('#form').each(function(){
               
             $("#form").attr("action", "<%=request.getContextPath()%>/rDelete.bo");
            $("#form").submit();
             
         });
          
         
      }
      function thumbsUp(){
          var answer;
             answer = confirm("?????? ???????????????????");
              if(answer == true){
               var bNo = "<%=b.getBoardNo()%>";   
               location.href='<%=request.getContextPath()%>/thumbsUp.ck?bNo='+bNo;
               
               alert("?????????????????????")
               location.href='<%=request.getContextPath()%>/thumbsUp.pl?bNo='+bNo;
                    }                
            }
      
   </script>
   <script>
      function makeReview(){
         <%if (rv != null) {%>
            $('#rvbtn').click( function() {
                  $(this).html('??????');
              })
         <%} else {%>
              var _width = '510';
             var _height = '630';
          
             // ????????? ????????? ??????????????? ?????? ????????? ?????? ??? ?????????
             var _left = Math.ceil(( window.screen.width - _width )/2);
             var _top = Math.ceil(( window.screen.height - _height )/4); 
          
             window.open('<%=request.getContextPath()%>/review.rv?rno=<%=b.getBoardNo()%>&userId=<%=b.getUserId()%>', '?????? ??????', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
         <%}%>
         }
      
      function insertJjim(){      
            <%--
            var answer;
              answer = confirm("??????????????? ?????????????????????????");
               if(answer == true){
           
                  var test = "<%= result %>"; 
                  console.log("?????????" + test);
                    
                     <% if (request.getSession().getAttribute("result") == null) { %>
                          var jno = "<%=b.getBoardNo() %>";
                          console.log("jno"+jno);
            
                          location.href='<%=request.getContextPath()%>/jjimInsert.ms?jno='+jno;
                            
                          alert("??????????????? ?????????????????????. ??? ???????????? ????????? ?????????.");
                   <%}else{%>   
                         alert("??????????????? ?????? ???????????? ????????????.");
                   <%}%>
                          
               }
               --%>
                var answer;
                answer = confirm("??????????????? ?????????????????????????");
                 if(answer == true){

                      
                       
                            var jno = "<%=b.getBoardNo()%>";
                            console.log("jno"+jno);
              
                            location.href='<%=request.getContextPath()%>/jjimInsert.ms?jno='+jno;
                              
                            alert("??????????????? ?????????????????????. ??? ???????????? ????????? ?????????.");
                   
                 }
         }
  </script>
<%@include file = "../common/footer.jsp" %>

</body>
</html>