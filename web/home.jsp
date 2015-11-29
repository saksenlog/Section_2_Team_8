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
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Why Donate?</h1>
      <p>Because you may save up to 8 lives through organ donation and enhance many others through tissue donation.

Last year alone, organ donors made more than 28,000 transplants possible. Another one million people received cornea and other tissue transplants that helped them recover from trauma, bone damage, spinal injuries, burns, hearing impairment and vision loss.

Unfortunately, thousands die every year waiting for a donor organ that never comes. You have the power to change that.</p>
      <hr>
      <h3>LEARN THE FACTS</h3>
      <p>These facts may help you better understand organ, eye, and tissue donation:</p> <br>
      <p>FACT: Anyone, regardless of age or medical history, can sign up to be a donor.</p> <br>
      <p>FACT: Most major religions in the United States support organ donation and consider donation as the final act of love and generosity toward others.</p> <br>
      <p>FACT: There is no cost to donors or their families for organ or tissue donation.<p><br>
             <div class="quiz-section">
		<div class="module q1 active">
			<p class="question">Q1) What is the maximum any age limit to donate organs?</p>
			<div class="answers">
				<p class="option">a) <25 years</p>
				<p class="option ans">b) No age limit</p>
				<p class="option">c) <75 years</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
		<div class="module q2">
			<p class="question">Q2) If I agree to donate my organs, I must donate all my organs</p>
			<div class="answers">
				<p class="option">a) True</p>
				<p class="option ans">b) False</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
		<div class="module q3">
			<p class="question">Q3) Organs are distributed nationally based on which of the following factors?</p>
			<div class="answers">
				<p class="option">a) Urgency of need</p>
				<p class="option">b) Blood and tissue type</p>
				<p class="option">c) Length of time on the waiting list </p>
                                <p class="option ans">d) All of the above </p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
                <div class="module q4">
			<p class="question">Q4) I cannot donate my organs because I have history of medical illness</p>
			<div class="answers">
                                <p class="option">a) True</p>
				<p class="option ans">b) False</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
		</div>
                <div class="module q5">
			<p class="question">Q5) On an average, a new patient is added to the waiting list every ____.</p>
			<div class="answers">
				<p class="option ans">a) 10 minutes</p>
				<p class="option">b) 2 days</p>
				<p class="option">c) 1 day</p>
			</div>
			<p class="crct">Correct answer</p>
			<p class="wrng">Wrong answer</p>
                </div>
		<button class="prev disable">Previous</button>
		<button class="next disable">Next</button>
	</div>   
    
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
          <p>Becoming Donor!</p><br>
          <p>Organ, eye, and tissue donation and transplantation provide a second chance at life for thousands of people each year. You have the opportunity to be one of the individuals who make these miracles happen.

By deciding to be a donor, you give the gift of hope ... hope for the thousands of individuals awaiting organ transplants and hope for the millions of individuals whose lives could be enhanced through tissue transplants.</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
        
  </div>
</div>
      

<footer class="container-fluid text-center">
  <p>Contact us @ organdonorlive@gmail.com</p>
</footer>
        
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
