<%-- 
    Document   : WelcomeDonor
    Created on : 27 Oct, 2015, 1:38:43 AM
    Author     : User
--%>

<%@page import="com.test.webapp.constants.CommonConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
	<style>
		.form-horizontal {
			width: 400px;
			margin: 40px auto 0;
			clear: both;
			text-align: center;
			background-color: #fff;
			padding: 20px;
			-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			border-radius: 5px;
		}
		.form-group {
			margin:0 0 20px 0 !important;
		}
		label.control-label.col-sm-2 {
			text-align: right;
			width: 100px;
			padding: 0px 20px 0 0;
			line-height: 33px;
		}
		.col-sm-3 {
			width: auto !important;
			margin-top: 3px;
		}
		.col-sm-3 input, .col-sm-3 .textarea {
			padding-left: 5px;
			width: 200px;
			height: 30px;
			border-radius: 4px;
			border: none;
			box-shadow: 0 0 5px #555;
		}
		.col-sm-3 .textarea {
			height: 80px;
		}
		.sndmsg {
			border: none;
			border-radius: 5px;
			padding: 5px 10px;
			background-color: #002667;
			color: #fff;
			text-transform: capitalize;
		}
		.msgfield label.control-label.col-sm-2 {
			line-height: 88px;
		}
	</style>
    <body>
        <h1>Welcome to Hospital Room</h1>
        Welcome user
<a href="Logout.jsp">Log out</a>
        
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li ><a href="Donor.jsp">Donor</a></li>
          <li class ="active"><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
<% 
            
            String DeclareValid = (String)request.getAttribute("DeclareValid");
            if(null != DeclareValid && (CommonConstants.TRUE).equalsIgnoreCase(DeclareValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong> Mail Sent Successfully.

            </div>
        <%     
            }else if(("false").equalsIgnoreCase(DeclareValid)){
        %>
            

            <div class="alert alert-danger fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Error!</strong> A problem has been occurred while submitting your data.

            </div>


        <%
            }else{}
            
        %>
   
                <form class="form-horizontal" role="form" action="HospitalLoginServlet" method="post">
      <input type="hidden" name="action" value="hospitalmail">
       <input type="hidden" name="receiveremail" value="${email}">
       <div align="center" class="form-group emailfield">
        <label class="control-label col-sm-2" for="lastName">Hospital :</label>
        <div class="col-sm-3">
        <span id="donorstate">${name}</span>
        </div>
    </div>
        <div align="center" class="form-group emailfield">
        <label class="control-label col-sm-2" for="lastName">Email :</label>
        <div class="col-sm-3">
         <span id="donorstate">${email}</span>
        </div>
    </div>
    <div  align="center" class="form-group namefield">
        <label class="control-label col-sm-2" for="fName">Subject :</label>
        <div class="col-sm-3">
              <input  type="text" class="input" id="name" name="subject" placeholder="Subject">
        </div>
    </div> 
    <div align="center" class="form-group msgfield">
      <label class="control-label col-sm-2" for="pwd">Message :</label>
      <div class="col-sm-3">          
          <textarea class="input textarea"  id="message" name="message" placeholder="Your message here"></textarea> 
      </div>
    </div>
       <input type="submit" class="form-group sndmsg" value="Send message">
                </form>
    </body>
</html>
