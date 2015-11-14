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
       <title>New user Registration page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        
    </head>
    <body>
        <h1>Welcome to new user registration page</h1>
       
        
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
          <li class="active"><a href="Register.jsp">NewUser Registraion</a></li>
           <li><a href="hospitalRegister.jsp">NewHospital Registraion</a></li>
        </ul>
       </div>     
      </nav>
        
        
        
        <% 
            
            String registerValid = (String)request.getAttribute("registerValid");
            if(null != registerValid && (CommonConstants.TRUE).equalsIgnoreCase(registerValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong> User Registration Successful.

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
  <form class="form-horizontal" role="form" action="UserRegistrationServlet" method="post">
  <div class="form-group">
        <label class="control-label col-sm-2" for="sel1">User-Role</label>
        <div class="col-sm-3"> 
        <select class="form-control" name ="User_Role" id="sel1">
    <option>SELECT VALUES</option>        
    <option>DONOR</option>
    <option>HOSPITAL</option>
    <option>CUSTODIAN</option>
  </select>
        </div>
     </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="fName">First Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name">
        </div>
    </div> 
    <div class="form-group">
        <label class="control-label col-sm-2" for="lastName">Last Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name">
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
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-3">
        <input type="email" class="form-control" name="emailId" id="emailId" placeholder="Enter email">
      </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="address1">Address1</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="address1" id="address1" placeholder="Address 1">
        </div>
    </div>  
    <div class="form-group">
        <label class="control-label col-sm-2" for="address2">Address2</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="address2" id="address2" placeholder="Address 2">
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
        <label class="control-label col-sm-2" for="zip">ZIP</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="zip" id="state" placeholder="zip">
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
</html>
