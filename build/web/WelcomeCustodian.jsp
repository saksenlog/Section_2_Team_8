<%-- 
    Document   : WelcomeCustodian
    Created on : 27 Oct, 2015, 1:38:43 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custodian page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Welcome to Custodian Room</h1>
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
          <li ><a href="Hospital.jsp">Hospital</a></li>
          <li class ="active"><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
        
        
            <div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">VIEW DONOR DETAILS</a></li>
    <li><a data-toggle="tab" href="#menu1">VIEW NEAREST HOSPITALS</a></li>
        
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
        <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
            <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="ViewDonor">
        <p align="center" class="search">
             <label>Donor details</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search" />
        </p>
    
           </form>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h4 align="center">VIEW NEAREST HOSPITALS</h4>
     <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Enter the Current location zip code</label>
             <input name="zip" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospital" />
        </p>
    
           </form>
       <div id="" class="">
      <p>Below are the list of hospitals</p>
	  <ul>
              <c:forEach var="hdetails" items="${hdetails}">
               <li><a href="HospitalLoginServlet?action=id&hid=${hdetails.hid}">${hdetails.hospitalName}</a></li>   
              </c:forEach>
	  </ul>
    </div>
    </div>
      
  </div>
    </div>
    </body>
</html>
