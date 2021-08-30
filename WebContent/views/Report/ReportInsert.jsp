<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.team3.member.model.vo.Member"%>

<%
	String msg = (String)request.getAttribute("msg");
%>
    
<%
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/report_css/reportInsert.css">

</head>



<body>
	<%@ include file="../common/menubar.jsp" %>


	<div class="container">
<div class="stepwizard">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Step 1</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled" >2</a>
            <p>Step 2</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
            <p>Step 3</p>
        </div>
    </div>
</div>
<form  action="<%= request.getContextPath()%>/ReportInsertServlet" method="post">
    <div class="row setup-content" id="step-1">
        <div class="col-xs-12">
            <div class="col-md-12">
                <div class="form-group">
                	<br>
                	<br>
                	<br>
                	<br>
                	
                    <label class="control-label">신고할 대상자를 입력해주세요.(아이디 또는 닉네임)</label>
                    <input  maxlength="100"  type="text" required="required" class="form-control" name = "reportNickName" id = "content1" placeholder=" 반드시 입력해야 다음단계로 넘어갑니다. "  />
                </div>
        
                <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
            </div>
        </div>
    </div>
    <div class="row setup-content" id="step-2">
        <div class="col-xs-12">
            <div class="col-md-12">
                	<br>
                	<br>
                	<br>
                	<br>
                <div class="form-group">
                    <label class="control-label">신고내용을 작성해주세요. (200글자 이내)</label>
                    <textarea maxlength="200"  cols="70" rows="15" required="required" class="form-control" name = "reportContent" id = "content2" placeholder="반드시 입력해야 다음단계로 넘어갑니다." /></textarea>
                </div>
               
                <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
            </div>
        </div>
    </div>
    <div class="row setup-content" id="step-3">
        <div class="col-xs-12">
            <div class="col-md-12">
                <br>
                <br>
                <br>
                <br>
                
                <h1>작성이 완료되었습니다. 제출버튼을 눌러주세요.</h1>
               	<br>
               	<br>
                <button class="btn btn-success btn-lg pull-right" type="submit">신고서 제출</button>
            </div>
        </div>
    </div>
</form>
</div>
    <script>
    $(document).ready(function () {

        var navListItems = $('div.setup-panel div a'),
                allWells = $('.setup-content'),
                allNextBtn = $('.nextBtn');

        allWells.hide();

        navListItems.click(function (e) {
            e.preventDefault();
            var $target = $($(this).attr('href')),
                    $item = $(this);

            if (!$item.hasClass('disabled')) {
                navListItems.removeClass('btn-primary').addClass('btn-default');
                $item.addClass('btn-primary');
                allWells.hide();
                $target.show();
                $target.find('input:eq(0)').focus();
            }
        });

        allNextBtn.click(function(){
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            $(".form-group").removeClass("has-error");
            for(var i=0; i<curInputs.length; i++){
                if (!curInputs[i].validity.valid){
                    isValid = false;
                    $(curInputs[i]).closest(".form-group").addClass("has-error");
                }
            }

            if (isValid)
                nextStepWizard.removeAttr('disabled').trigger('click');
        });

        $('div.setup-panel div a.btn-primary').trigger('click');
    });
    
   
    
	   
    </script>
    
</body>
<%@include file = "../common/footer.jsp" %>
</html>