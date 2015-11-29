<%-- 
    Document   : test
    Created on : 24 Oct, 2015, 3:08:03 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Welcome to Organ Donation</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    </head>
	<style>
		.quiz-section {
			width: 500px;
			height: 300px;
			overflow: hidden;
			margin: 0 auto;
			position: relative;
			border-radius: 5px;
		}
		.module {
			height: 300px;
			width: 500px;
			position: absolute;
			top: 0;
			webkit-box-shadow: -3 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			background-color: #efefef;
		}
		.next, .prev {
			position: absolute;
			bottom: 15px;
			left: 15px;
			border: none;
			background-color: #002667;
			color: #fff;
			border-radius: 5px;
			width: 80px;
			height: 30px;
		}
		.next {
			left: auto;
			right: 15px;
		}
		.disable {
			opacity: 0.6;
			cursor: default;
		}
		.question {
			padding: 10px;
			background-color: #002667;
			color: #fff;
			font-weight: bold;
			font-size: 15px;
			margin: 0;
			height: 62px;
		}
		.option {
			margin: 0;
			padding: 10px;
			border-bottom: 1px solid #ccc;
			cursor: pointer;
		}
		.crct,.wrng {
			display: none;
			margin: 10px 0;
			text-align: center;
			font-weight: bold;
			color: green;
		}
		.wrng {
			color: red;
		}
	</style>
    <body>
        <h1>Live Long Give Life....</h1> </br>
        
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
               <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
        
        <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="home.jsp">Home</a></li>
        <li><a href="Donor.jsp">Donor</a></li>
        <li><a href="Hospital.jsp">Hospital</a></li>
        <li><a href="Custodian.jsp">Custodian</a></li>
        <li><a href="#">Contact</a></li>        
        <li><a href="">FAQ</a></li>
        <li><a href="Register.jsp">NewUser Registraion</a></li>
        <li><a href="hospitalRegister.jsp">NewHospital Registraion</a></li>
        </nav>
	
	<div class="quiz-section">
		<div class="module q1 active">
			<p class="question">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam lacinia nec leo ac pellentesque?</p>
			<div class="answers">
				<p class="option">Option 1</p>
				<p class="option ans">Option 2</p>
				<p class="option">Option 3</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
		<div class="module q2">
			<p class="question">This is Question 2</p>
			<div class="answers">
				<p class="option">Option 1</p>
				<p class="option">Option 2</p>
				<p class="option ans">Option 3</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
		<div class="module q3">
			<p class="question">This is Question 3</p>
			<div class="answers">
				<p class="option ans">Option 1</p>
				<p class="option">Option 2</p>
				<p class="option">Option 3</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
		<button class="prev disable">Previous</button>
		<button class="next disable">Next</button>
	</div>
    </body>
	<script>
		$(document).ready(function(){
		var len = $(".module").length;
		var count=0;
			$(".module").each(function(){
				$(this).css("left",count*500);
				count++;
			});
			$(".next").on("click",function(){
			if(!$(this).hasClass("disable")){
				$(".prev").removeClass("disable");;
				//if(!$(".module.active").hasClass("q"+len)){
					$(".module.active").animate({left:-500},500,function(){$(this).removeClass("active")});
					$(".module.active").next().animate({left:0},500,function(){$(this).addClass("active"); $(this).hasClass("q"+len) && $(".next").addClass("disable");});
					!$(".module.active").hasClass("answered") && $(".next").addClass("disable");
				//}
				}
			});
			$(".prev").on("click",function(){
			if(!$(this).hasClass("disable")){
				$(".next").removeClass("disable");
				//if(!$(".module.active").hasClass("q1")){
					$(".module.active").animate({left:500},500,function(){$(this).removeClass("active")});
					$(".module.active").prev().animate({left:0},500,function(){$(this).addClass("active");; $(this).hasClass("q1") && $(".prev").addClass("disable");});
				//}
				}
			});
			$(".option").on("click",function(){
				$(this).parents(".module").addClass("answered");
				$(this).hasClass("ans") ? ($(this).css("background-color","#8fc800"),$(".active .crct").show()) : ($(this).css("background-color","#f16f5c"), $(".active .ans").css("background-color","#8fc800"),$(".active .wrng").show());
				!$(".module.active").hasClass("q"+len) && $(".next").removeClass("disable");
			});
		});
		
	</script>
</html>
