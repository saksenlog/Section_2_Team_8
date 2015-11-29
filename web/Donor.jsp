<%-- 
    Document   : Donor
    Created on : 25 Oct, 2015, 3:55:29 PM
    Author     : User
--%>

<%@page import="com.test.webapp.constants.CommonConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Donor Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <h1>Welcome to Donor Login page</h1>
       
        
          <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li class ="active"><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
          <li><a href="Register.jsp">NewUser Registraion</a></li>
           <li><a href="hospitalRegister.jsp">NewHospital Registraion</a></li>
        </ul>
       </div>     
      </nav>
            <% 
            
            String addorganValid = (String)request.getAttribute("addorganValid");
            if(null != addorganValid && (CommonConstants.TRUE).equalsIgnoreCase(addorganValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong> Harvested Organs are successfully added to the system .

            </div>
        <%     
                
                
        %>
            

            <div class="alert alert-danger fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Error!</strong> A problem has been occurred while submitting your data.

            </div>


        <%
            }else{}
            
        %>
        
        <div class="container">
  <h2>Donor Login Form</h2>
  <p>Please enter the user name and password to validate the credentials</p>
  <form class="form-inline" action="DonorLoginServlet" role="form" method="post">
      <input type="hidden" name="action" value="login">
    <div class="form-group">
      <label for="UserName">User Name:</label>
      <input type="text" class="form-control" name="UserName" id="UserName" placeholder="Enter UserName">
          </div>
   <%--   <%
   String name = request.getParameter( "UserName" );
   session.setAttribute( "theName", name );
%>  --%>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="Password" id="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-default" value="Login">
      </div>
    </div>
     
</div>
  </form>
        
    </body>
</html>        