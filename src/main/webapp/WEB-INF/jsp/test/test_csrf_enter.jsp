<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CSRF</title>
<style type="text/css">
#box2 {
	float: left;
	width: 98%;
	padding: 10px;
	display: inline;
	margin-bottom: 10px;
	height: 500px;
	background-image: url("../img/card.png");
	background-repeat: no-repeat ;
	background-position: -25px 0px;
}

.comment {
	font-size: 12px;
	color: #555;
	margin: 1px;
	padding: 1px;
	font-weight: normal;
}

.result {
	font-size: 16px;
	color: red;
	font-weight: bold;
	margin-top: 10px;
	margin-bottom: 10px;
}

.hint {
	font-size: 22px;
	font-weight: bold;
}

#comment {
	color: #666;
	font-family: "맑은고딕", "sans-serif";
	font-size: 11pt;
}

#side-title {
	background-color: #eee;
	font-weight: bold;
	width: 200px;
	height: 30px;
	font-family: "맑은고딕", "sans-serif";
	color: #444;
	font-size: 16px;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

#select-test {
	width: 250px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: navy;
	font-size: 16pt;
	text-align: left;
	padding-top: 10px;
	padding-bottom: 30px;
	padding-left: 10px;
	margin: 0;
	display: inline-block;
}
#subject1{
	background-color: navy;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

#subject2{
	background-color: maroon;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}
#subject3{
	background-color: purple;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}
.explain{
	font-size: 12pt;
	padding-left: 40px;
	margin-top: 0px;
	padding-bottom: 30px;
}

#test-result {
	background-color: #bc8f8f;
	width: 200px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

.test{

	float: right;
	height: 33px;
}
.topic{
height: 30px;
}

.explain-container{
padding-top: 50px;
}
</style>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/modal.css" rel="stylesheet" type="text/css" />
<script src="../js/webtoolkit.base64.js"></script>
<script src="../js/jquery-1.7.1.js"></script>

</head>
<body>
	<div id="container">

		<h1>
			<jsp:include page="../board/header.jsp" />
		</h1>


		<div id="content-container">
			<div id="content" style="width: 100%;">

				<div id="box2">

					<div id="labs">

						<div class="hint" id="div16">
							<p id="select-test">CSRF</p> <button class="btn btn-info test" onclick="test()">TEST</button>
							<div class="explain-container" >
								<img class="topic" alt="원인" src="../img/cause.png"> <p class="explain">웹 서버로 전달된 요청이 공격자가 심어 놓은 자동화된 코드를 통한 요청인지, 실제 페이지에서 사용자가 일으킨 정상적인 요청인지를 확인하지 않고 처리하는 경우</p>
								<img class="topic" alt="영향" src="../img/effect.png"> <p class="explain">미리 작성해 둔 공격코드를 이용하여 희생자의 권한으로 요청이 처리되도록 한다.<br>게시판 자동 글쓰기, 자동 회원 가입, 다른 사용자의 권한을 도용한 중요 기능 실행 등의 공격이 수행될 수 있다.</p>
								<img class="topic" alt="대응" src="../img/response.png"> <p class="explain">입력화면 폼 작성시 GET 방식 대신 POST 방식을 사용한다.<br>입력화면 폼과 해당 입력을 처리하는 프로그램 사이에 CSRF토큰을 사용하여, 공격자가 직접적인 URL 조작을 통해 시스템의 기능을 사용할 수 없도록 한다.<br>중요 기능에 대해서는 추가적인 인증이나 다중매체 인증방식을 적용한다.</p>
																
							</div>


						</div>

					</div>

				</div>

				<div id="footer">
					<jsp:include page="../board/footer.jsp" />
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		function test() {
			window.location.href="/test/test_open.do?no=7-1"
		}
	
		$(function() {
			$('#button16').click( 
			  		   function() { 
			  		   	    	 var formData = $("#form16").serializeArray();  
			  			    	 var URL = $("#form16").attr("action");  
			  			    	 $('#result').empty(); 
			  			    	 $.post(URL,formData,   
			  			    			function(data, textStatus, jqXHR)     {        	    		             
			  		   	    		           $('#result').append(data); 
			  		   	    		    } 
			  		    	    	   ).fail(function(jqXHR, textStatus, errorThrown) {   
			  		   	    		    	   $('#result').append("요청처리 실패"); 
			  		   	    	         }); 
			  		   });

		});
	</script>
	<!--  	var uri = "http://w3schools.com/my test.asp?name=st책le&car=saab"; -->
	<!--  	var uri_enc = encodeURIComponent(uri); -->
	<!--  	var uri_dec = decodeURIComponent(uri_enc); -->
	<!--  	var res = uri_enc + "<br>" + uri_dec; -->



</body>
</html>