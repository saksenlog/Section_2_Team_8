<%-- 
    Document   : WelcomeDonor
    Created on : 27 Oct, 2015, 1:38:43 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donor page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
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
        
        
            <div class="container">
                 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Donor Details</a></li>
    <li><a data-toggle="tab" href="#menu1">Organ Details</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>DONOR DETAILS</h3>
      <div class="details"><label>Donor ID</label><span class="colon">:</span><span id="donorid">${donorid}</span></div>
      <div class="details">User Name<label></label><span class="colon">:</span><span id="donorname">${donor.userName}</span></div>
	  <div class="details"><label>First Name</label><span class="colon">:</span><span id="donorname">${donor.firstName}</span></div>
	  <div class="details"><label>Last Name</label><span class="colon">:</span><span id="donorage">${donor.lastName}</span></div>
	  <div class="details"><label>Address line 1</label><span class="colon">:</span><span id="donoradd1">${donor.address1}</span></div>
	  <div class="details"><label>Address line 2</label><span class="colon">:</span><span id="donoradd2">${donor.address2}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donorcity">${donor.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donorstate">${donor.state}</span></div>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>ORGAN DETAILS</h3>
      <p>The donor is willing to donate all the organs</p>
	  <ul>
              <c:forEach var="organs" items="${organs}">
              <li>${organs}</li>
              </c:forEach>
	  </ul>
    </div>
  </div>
        </div>
    </body>
</html>
