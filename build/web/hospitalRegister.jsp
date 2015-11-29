<%-- 
    Document   : Register
    Created on : 25 Oct, 2015, 11:44:58 AM
    Author     : User
--%>

<%@page import="com.test.webapp.constants.CommonConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>New Hospital Registration page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <style>
            .checkbox{
                display: none;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to new Hospital registration page</h1>
       
        
          <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
          <li><a href="Register.jsp">New User Registration</a></li>
          <li class="active"><a href="hospitalRegister.jsp">NewHospital Registraion</a></li>
        </ul>
       </div>     
      </nav>
        
        
        
        <% 
            
            String registerValid = (String)request.getAttribute("registerValid");
            if(null != registerValid && (CommonConstants.TRUE).equalsIgnoreCase(registerValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong> Hospital Registration Successful.

            </div>
        <%     
            }else if(("false").equalsIgnoreCase(registerValid)){
        %>
            

            <div class="alert alert-danger fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Error!</strong> A problem has been occurred while submitting your data.

            </div>


        <%
            }else{}
            
        %>
        
        
        
        <div class="container">
  <h2>Registration form</h2>
  <form class="form-horizontal" role="form" action="HospitalLoginServlet" method="post">
      <input type="hidden" name="action" value="hospitalregister">
    <div class="form-group">
        <label class="control-label col-sm-2" for="fName">Hospital Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="HospitalName" id="HospitalName" placeholder="Hospital Name">
        </div>
    </div> 
    <div class="form-group">
        <label class="control-label col-sm-2" for="lastName">User Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="userName" id="userName" placeholder="User Name">
        </div>
    </div>
      
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password</label>
      <div class="col-sm-3">          
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Retype-Password</label>
      <div class="col-sm-3">          
        <input type="password" class="form-control" name="rePwd" id="rePwd" placeholder="Enter password">
      </div>
    </div>  
      
    <div class="form-group">
        <label class="control-label col-sm-2" for="address">address</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="address" id="address" placeholder="Address">
        </div>
    </div>  
    <div class="form-group">
        <label class="control-label col-sm-2" for="city">City</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="city" id="city" placeholder="City">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="state">State</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="state" id="state" placeholder="State">
        </div>
    </div>   
       <div class="form-group">
        <label class="control-label col-sm-2" for="zip">zip</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="zip" id="state" placeholder="zip">
        </div>
    </div>  
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email</label>
      <div class="col-sm-3">
        <input type="email" class="form-control" name="emailId" id="emailId" placeholder="Enter email">
      </div>
    </div>    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-default" value="submit">
      </div>
    </div>
  </form>
</div>

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
        
        
    </body>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script>
        $("#sel1").on("change",function(){
            if($(this).val() === "DONOR") { 
                $(".checkbox").show();
            } else { 
                $(".checkbox").hide();
            }
        });
    </script>
</html>
