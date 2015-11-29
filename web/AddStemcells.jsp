<%-- 
    Document   : AddStemcells
    Created on : 23 Nov, 2015, 9:47:58 PM
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
            <h4> Stem cells </h4>
            <p>Healthy adults between the ages of 18-60 can donate blood stem cells. In order for a blood stem cell transplant to be successful, the patient and the blood stem cell donor must have a closely matched tissue type or human leukocyte antigen (HLA). Since tissue types are inherited, patients are more likely to find a matched donor within their own racial and ethnic group. There are three sources of blood stem cells that healthy volunteers can donate:</p>
            <p1>Marrow</p1> <br>
            <p2>Peripheral blood stem cells</p2><br>
            <p3>Cord blood stem cells</p3><br>
  <h3>Enter the Harvested Stem Cells details:</h3>
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
        <h4>Select the Stem Cells Harvested</h4>
    <div class="checkbox">
      <label><input type="checkbox" value="">Marrow</label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="">Peripheral blood stem cells</label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="" >Cord blood stem cells</label>
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
