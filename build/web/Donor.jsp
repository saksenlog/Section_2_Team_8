<%-- 
    Document   : Donor
    Created on : 25 Oct, 2015, 3:55:29 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Donor Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        
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
        
        
        
<!-- <form name="Newuser" action="UserRegistrationServlet" method="post"> 
            First Name : <input type="text" name="FirstName" value="" size="20" /><br> <br>
            Last Name  : <input type="text" name="LastName" value="" size="20" /><br> <br>
            Email_Addr : <input type="text" name="Email" value="" size="20" /><br> <br>
            User Name  : <input type="text" name="UserName" value="" size="20" /><br> <br>
            Password   : <input type="password" name="Password" value="" size="20" /> <br> <br>
            Retype Pswd: <input type="password" name="Password" value="" size="20" /> <br> <br>
            <div class="container">
                <input type="submit" class="btn btn-default" name="Submit" />
            </div>
        </form>  -->
        
        
    