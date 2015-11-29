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
        <title>Hospital page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Welcome to Hospital Room</h1>
        Welcome <c:out value="${name}" />
<a href="Logout.jsp">Log out</a>
        
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li class ="active" ><a href="Donor.jsp">Donor</a></li>
          <li ><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
        
        
            <div class="container">
                 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Participating Hospital Details</a></li>
   <!-- <li><a data-toggle="tab" href="#menu1">Paticipating Hospital Details</a></li> -->
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>Hospital DETAILS</h3>
       <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
      <form class="form-inline" action="DonorLoginServlet" role="form" method="post">
          <input type="hidden" name="action" value="updatehospital">
      <input type="hidden" name="dname" value="${dname}">
      <input type="hidden" name="hid" value="${detailsh.hid}">
      <input type="hidden" name="hname" value="${detailsh.hospitalName}">
      <div class="details"><label>Hospital ID</label><span class="colon">:</span><span id="donorid" name="hid">${detailsh.hid}</span></div>
      <div class="details" >Hospital Name<label></label><span class="colon">:</span><span id="donorname" name="hname">${detailsh.hospitalName}</span></div>
	  <div class="details"><label>Address</label><span class="colon">:</span><span id="donorage">${detailsh.address}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donoradd1">${detailsh.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donoradd2">${detailsh.state}</span></div>
	  <div class="details"><label>zip</label><span class="colon">:</span><span id="donorcity">${detailsh.zip}</span></div>
	  <div class="details"><label>Email</label><span class="colon">:</span><span id="donorstate">${detailsh.email}</span></div>
          <div class="checkbox">
        <label><input type="checkbox" name="Interest" value="">Yes,I choose this hospital for donating my organs </label>
    </div>
          <br><br>
          <input name="search-btn" type="submit" class="btn" value="Submit" />
      </form>
    </div>
  </div>
        </div>
    </body>
</html>
