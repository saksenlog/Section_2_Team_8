<%-- 
    Document   : Custodian
    Created on : 27 Oct, 2015, 10:31:54 PM
    Author     : User
--%>

<%@page import="com.test.webapp.constants.CommonConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Custodian Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <h1>Welcome to Custodian Login page</h1>
       
        
          <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
          <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li ><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li class = "active"><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
          <li><a href="NewRegister.jsp">NewUser Registraion</a></li>
        </ul>
       </div>     
      </nav>
        <% 
            
            String addorganValid = (String)request.getAttribute("addorganValid");
            if(null != addorganValid && (CommonConstants.TRUE).equalsIgnoreCase(addorganValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong>  .

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
        
         <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
        <div class="container">
  <h2>Custodian Login Form</h2>
  <p>Please enter the user name and password to validate the credentials</p>
  <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
      <input type="hidden" name="action" value="login">
    <div class="form-group">
      <label for="UserName">User Name:</label>
      <input type="text" class="form-control" name="UserName" id="UserName" placeholder="Enter UserName">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="Password" id="pwd" placeholder="Enter password">
    </div>
       <div class="form-group">
      <label for="pwd">Donor ID:</label>
      <input type="text" class="form-control" name="ID" id="pwd" placeholder="Enter Donor ID">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
     </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-default" value="Login">
      </div>
    </div>
  </form>
        </div>   
        
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
        
        