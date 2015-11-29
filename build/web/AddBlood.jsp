<%-- 
    Document   : AddBlood
    Created on : 23 Nov, 2015, 9:48:35 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Organs</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Welocme to Add organs!</h1>
        
        
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
        
        <div class="container">
            <h4> Blood and Platelets </h4>
            <p>Blood and platelets are formed by the body, go through a life cycle, and are continuously replaced throughout life. This means that you can donate blood and platelets more than once. It is safe to donate blood every 56 days and platelets every four weeks.</p>
            <p1>Blood is stored in a blood bank according to type (A, B, AB, or O) and Rh factor (positive or negative). Blood can be used whole, or separated into packed red cells, plasma, and platelets, all of which have different lifesaving uses. It takes only about 10 minutes to collect a unit (one pint) of blood, although the testing and screening process means that you will be at the donation center close to an hour.</p1> <br> <br>
            <p2>Platelets are tiny cell fragments that circulate throughout the blood and aid in blood clotting. Platelets can be donated without donating blood. When a specific patient needs platelets, but does not need blood, a matching donor is found and platelets are separated from the rest of the blood which is returned to the donor. The donor's body will replace the missing platelets within a few hours.</p2><br>
            
  <h3>Enter the Donated Blood details details:</h3>
  <form class="form-horizontal" role="form" action="HospitalLoginServlet" method="post">
      <input type="hidden" name="action" value="addblood">
      <div class="form-group">
        <label class="control-label col-sm-2" for="HospitalID">Hospital ID</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="HospitalID" id="HospitalID" placeholder="Hospital ID">
        </div>
    </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="DonorID">DONOR ID</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="DonorID" id="DonorID" placeholder="DONOR ID">
        </div>
    </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="Blood Group">Blood Group</label>
        <div class="col-sm-3"> 
        <select class="form-control" name ="BloodGroup" id="Blood Group">
    <option>SELECT VALUES</option>        
    <option>A</option>
    <option>B</option>
    <option>AB</option>
    <option>AB</option>
  </select>
        </div>
     </div>  
      <div class="form-group">
        <label class="control-label col-sm-2" for="Rhfactor">Rhfactor</label>
        <div class="col-sm-3"> 
        <select class="form-control" name ="Rhfactor" id="Rhfactor">
    <option>SELECT VALUES</option>        
    <option>Positive</option>
    <option>Negative</option>
    
  </select>
        </div>
     </div>  
      <br>
      
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <input type="Submit" class="btn btn-default" value="Submit">
      </div>
    </div>
      
  </form>
  
  
        </div>
    </body>
</html>
