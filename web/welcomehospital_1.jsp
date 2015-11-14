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
    <li class="active"><a data-toggle="tab" href="#home">SEARCH DONOR</a></li>
    <li><a data-toggle="tab" href="#menu1">PARTICIPATING HOSPITAL</a></li>
    <li><a data-toggle="tab" href="#menu2">ADD/UPDATE ORGANS</a></li>
    <li><a data-toggle="tab" href="#menu3">SEARCH ORGANS</a></li>
    
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
        <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
            <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchDonor">
        <p align="center" class="search">
             <label>Search by Donor ID</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search" />
        </p>
    
           </form>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h4 align="center">PARTICIPATING HOSPITAL</h4>
     <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
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
      <div id="menu3" class="tab-pane fade">
        <p align="center" id="message" style="color: red" ><i><c:out value="${message}" /></i></p>
            <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="Searchorgans">
        <p align="center" class="search">
             <label>Search Organs</label>
             <input name="searchorgan" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search" />
        </p>
    
           </form>
       <h5>Organ Search Results</h5>
       <table>
    <tr>
      
    
        <td id="1"><b>Organ Name</b></td><td id="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Donor ID</b></td><td id="3"><b>&nbsp;&nbsp;&nbsp;&nbsp;Blood Group</b></td><td id="4"><b>&nbsp;&nbsp;&nbsp;&nbsp;Hospital ID</b></td><td id="5"><b>&nbsp;&nbsp;&nbsp;&nbsp;Availability</b></td>
   
    </tr>
     <td></td><td></td><td></td>
    <c:forEach items="${organdtls}" var="theme" varStatus="status">
        <tr>
             <td id="1">${theme.organname}</td><td id="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${theme.donorid}</td><td id="3">&nbsp;&nbsp;&nbsp;&nbsp;${theme.bloodgroup}</td><td id="4">&nbsp;&nbsp;&nbsp;&nbsp;${theme.hospid}</td><td id="5">&nbsp;&nbsp;&nbsp;&nbsp;${theme.avail}</td>
           
        </tr>
       
      
    </c:forEach>
</table>
    </div>
  </div>
    </div>
    </body>
</html>
