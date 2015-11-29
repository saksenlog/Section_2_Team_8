<%-- 
    Document   : Hospital
    Created on : 25 Oct, 2015, 3:55:58 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Hospital Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        
    </head>
    <body>
        <h1>Welcome to Hospital Login page</h1>
       
        
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
          <li><a href="Contact.jsp">Contact</a></li>        
          <li><a href="FAQ.jsp">FAQ</a></li>
          <li><a href="Register.jsp">NewUser Registraion</a></li>
           <li><a href="hospitalRegister.jsp">NewHospital Registraion</a></li>
        </ul>
       </div>     
      </nav>
        
        <div class="container">
  <h2>Hospital Login Form</h2>
  <p>Please enter the user name and password to validate the credentials</p>
  <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
       <input type="hidden" name="action" value="login">
    <div class="form-group">
      <label for="UserName">User Name:</label>
      <input type="text" class="form-control" name="UserName" id="UserName" placeholder="Enter UserName">
    </div>
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
        
        