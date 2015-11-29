<%-- 
    Document   : AddTissue
    Created on : 23 Nov, 2015, 9:47:43 PM
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
            <h4> Tissue </h4>
            <p>Corneas, the middle ear, skin, heart valves, bone, veins, cartilage, tendons, and ligaments can be stored in tissue banks and used to restore sight, cover burns, repair hearts, replace veins, and mend damaged connective tissue and cartilage in recipients.</p>
  <h2>Enter the Harvested Tissue details:</h2>
  <form class="form-horizontal" role="form" action="-----Servlet" method="post">
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
        <label class="control-label col-sm-2" for="Bloodgroup">Blood Group</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="Bloodgroup" id="Bloodgroup" placeholder="Blood Group">
        </div>
    </div>   
      <div class="form-group">
        <h3>Select the Tissues Harvested</h3>
    <div class="checkbox">
      <label><input type="checkbox" value="">Corneas</label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="">Middle ear</label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="" >Skin</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Heart Valves</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Bone</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Veins</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Cartilage</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Tendons</label>
    </div>
        <div class="checkbox">
      <label><input type="checkbox" value="" >Ligaments</label>
    </div>
             
  </div>
      
      <br>
      
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-default" value="submit">
      </div>
    </div>
      
  </form>
  
  
        </div>
    </body>
</html>
