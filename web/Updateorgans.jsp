<%-- 
    Document   : Updateorgans
    Created on : 23 Nov, 2015, 7:42:26 PM
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
            
            <form class="form-inline" action="HospitalLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="DonorUpdate">
        <p align="center" class="search">
             <label>Enter Donor ID:</label>
             <input name="DonorUpdate" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search" />
        </p>
        <h5>Organ Details of the corresponding Donor:</h5>
       <table>
    <tr>
      
    
        <td id="1"><b>Organ Name</b></td>
        <td id="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Donor ID</b></td>
        <td id="3"><b>&nbsp;&nbsp;&nbsp;&nbsp;Blood Group</b></td>
        <td id="4"><b>&nbsp;&nbsp;&nbsp;&nbsp;Hospital ID</b></td>
        <td id="5"><b>&nbsp;&nbsp;&nbsp;&nbsp;Availability</b></td>
        <td id="6"><b>&nbsp;&nbsp;&nbsp;&nbsp;Used</b></td>
   
    </tr>
     <td></td><td></td><td></td>
    <c:forEach items="${organdtls}" var="theme" varStatus="status">
        <tr>
        <td id="1">${theme.organname}</td>
        <td id="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${theme.donorid}</td>
        <td id="3">&nbsp;&nbsp;&nbsp;&nbsp;${theme.bloodgroup}</td>
        <td id="4">&nbsp;&nbsp;&nbsp;&nbsp;${theme.hospid}</td>
        <td id="5">&nbsp;&nbsp;&nbsp;&nbsp;${theme.avail}</td>
        <td id="6"><input type="checkbox" name="name1" />&nbsp;</td>
           
        </tr>
       
      
    </c:forEach>
</table>
    </div>
    
           </form>
        </div>