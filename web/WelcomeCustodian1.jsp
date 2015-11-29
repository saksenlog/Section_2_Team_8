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
        <%  
                    if(request.getAttribute("message")==null || request.getAttribute("message")=="")
                
            {        
                  if(request.getAttribute("zip")==null || request.getAttribute("zip")=="")
        {
              if(session.getAttribute("hospital")==null || session.getAttribute("hospital")=="")
            { 
            
            %>

            <div class="container">
                 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Donor Details</a></li>
    <li class=""><a data-toggle="tab" href="#menu1">Organ Details</a></li>
    <li><a data-toggle="tab" href="#menu2">Hospital Details</a></li>
    <li><a data-toggle="tab" href="#menu3">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
   
    <div id="home" class="tab-pane fade in active">
        <h3>DONOR DETAILS</h3>
      <div class="details"><label>Donor ID</label><span class="colon">:</span><span id="donorid">${donorid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="donorname">${donor.firstName} ${donor.lastName}</span></div>
	  <div class="details"><label>Address line 1</label><span class="colon">:</span><span id="donoradd1">${donor.address1}</span></div>
	  <div class="details"><label>Address line 2</label><span class="colon">:</span><span id="donoradd2">${donor.address2}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donorcity">${donor.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donorstate">${donor.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="donorzip">${donor.zip}</span></div>
    </div>
    <div id="menu1" class="tab-pane fade">
        <h3>ORGAN DETAILS</h3>
      <p>Below are the list of organs the donor is willing to donate.</p>
	  <ul>
              <c:forEach items="${organsl}" var="organsl" varStatus="status">
              <li>${organsl}</li>
              </c:forEach>
	  </ul>
    </div> 
      <div id="menu2" class="tab-pane fade">
       <h3>HOSPITAL DETAILS</h3>
      <h4>This donor have not chosen any hospital.</h4>
	
    </div>
    <div id="menu3" class="tab-pane fade">
      <h4 align="center">Search Hospitals</h4>
      <p align="center" id="message1" style="color: red" ><i><c:out value="${message}" /></i></p>
     <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospital" />
        </p>
    
           </form>
       <div id="" class="">
      <p>Below are the list of hospitals</p>
	  <ul>
              <c:forEach var="hdetails" items="${hdetails}">
               <li><a href="CustodianLoginServlet?action=id&hid=${hdetails.hid}">${hdetails.hospitalName}</a></li>   
              </c:forEach>
	  </ul>
    </div>
    </div>
  </div>
        </div>
      <% }
      else
            {
      
      %>
        <div class="container">
                 <ul class="nav nav-tabs">
    <li class="active" ><a data-toggle="tab" href="#home">Donor Details</a></li>
    <li class=""><a data-toggle="tab" href="#menu1">Organ Details</a></li>
    <li><a data-toggle="tab" href="#menu2">Hospital Details</a></li>
    <li><a data-toggle="tab" href="#menu3">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
   
    <div id="home" class="tab-pane fade in active">
        <h3>DONOR DETAILS</h3>
      <div class="details"><label>Donor ID</label><span class="colon">:</span><span id="donorid">${donorid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="donorname">${donor.firstName} ${donor.lastName}</span></div>
	  <div class="details"><label>Address line 1</label><span class="colon">:</span><span id="donoradd1">${donor.address1}</span></div>
	  <div class="details"><label>Address line 2</label><span class="colon">:</span><span id="donoradd2">${donor.address2}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donorcity">${donor.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donorstate">${donor.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="donorzip">${donor.zip}</span></div>
    </div>
    <div id="menu1" class="tab-pane fade">
        <h3>ORGAN DETAILS</h3>
      <p>Below are the list of organs the donor is willing to donate.</p>
	  <ul>
              <c:forEach items="${organsl}" var="organsl" varStatus="status">
              <li>${organsl}</li>
              </c:forEach>
	  </ul>
    </div> 
      <div id="menu2" class="tab-pane fade">
       <h3>HOSPITAL DETAILS</h3>
       <p>Details of the hospital, where the donor opted to harvest his/her organs.</p>
	  <div class="details"><label>Hospital ID</label><span class="colon">:</span><span id="hospid">${hospital.hid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="hospname">${hospital.hospitalName}</span></div>
	  <div class="details"><label>Address</label><span class="colon">:</span><span id="hospadd1">${hospital.address}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="hospcity">${hospital.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="hospstate">${hospital.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="hospzip">${hospital.zip}</span></div>
            <div class="details"><label>Email</label><span class="colon">:</span><span id="hospzip">${hospital.email}</span></div>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h4 align="center">Search Hospitals</h4>
      <p align="center" id="message1" style="color: red" ><i><c:out value="${message}" /></i></p>
     <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospital" />
        </p>
    
           </form>
     <div id="" class="">
      <p>Below are the list of hospitals</p>
	  <ul>
              <c:forEach var="hdetails" items="${hdetails}">
               <li><a href="CustodianLoginServlet?action=id&hid=${hdetails.hid}">${hdetails.hospitalName}</a></li>   
              </c:forEach>
	  </ul>
    </div>
    </div>
  </div>
        </div>
        <% }
        }
        else{
      
      %>
      <div class="container">
                 <ul class="nav nav-tabs">
    <li><a data-toggle="tab" href="#home">Donor Details</a></li>
    <li class=""><a data-toggle="tab" href="#menu1">Organ Details</a></li>
    <li><a data-toggle="tab" href="#menu2">Hospital Details</a></li>
    <li class="active"><a data-toggle="tab" href="#menu3">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
   
    <div id="home" class="tab-pane fade">
        <h3>DONOR DETAILS</h3>
      <div class="details"><label>Donor ID</label><span class="colon">:</span><span id="donorid">${donorid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="donorname">${donor.firstName} ${donor.lastName}</span></div>
	  <div class="details"><label>Address line 1</label><span class="colon">:</span><span id="donoradd1">${donor.address1}</span></div>
	  <div class="details"><label>Address line 2</label><span class="colon">:</span><span id="donoradd2">${donor.address2}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donorcity">${donor.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donorstate">${donor.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="donorzip">${donor.zip}</span></div>
    </div>
    <div id="menu1" class="tab-pane fade">
        <h3>ORGAN DETAILS</h3>
      <p>Below are the list of organs the donor is willing to donate.</p>
	  <ul>
              <c:forEach items="${organsl}" var="organsl" varStatus="status">
              <li>${organsl}</li>
              </c:forEach>
	  </ul>
    </div> 
      <div id="menu2" class="tab-pane fade">
       <h3>HOSPITAL DETAILS</h3>
     <p>Details of the hospital, where the donor opted to harvest his/her organs.</p>
	  <div class="details"><label>Hospital ID</label><span class="colon">:</span><span id="hospid">${hospital.hid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="hospname">${hospital.hospitalName}</span></div>
	  <div class="details"><label>Address</label><span class="colon">:</span><span id="hospadd1">${hospital.address}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="hospcity">${hospital.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="hospstate">${hospital.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="hospzip">${hospital.zip}</span></div>
            <div class="details"><label>Email</label><span class="colon">:</span><span id="hospzip">${hospital.email}</span></div>
	
    </div>
    <div id="menu3" class="tab-pane fade in active">
      <h4 align="center">Search Hospitals</h4>
      <p align="center" id="message1" style="color: red" ><i><c:out value="${message}" /></i></p>
     <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospital" />
        </p>
    
           </form>
    <div id="" class="">
           <p>Below are the list of hospitals by zip: <c:out value="${zipvalue}" /></p>
            <ul>
              <c:forEach var="zip" items="${zip}">
               <li><a href="CustodianLoginServlet?action=id&hid=${zip.hid}">${zip.hospitalName}</a></li>   
              </c:forEach>
	  </ul> 
    </div>
    </div>
  </div>
        </div>
      <% }
            }
                    else{
            %>
             <div class="container">
                 <ul class="nav nav-tabs">
    <li ><a data-toggle="tab" href="#home">Donor Details</a></li>
    <li class=""><a data-toggle="tab" href="#menu1">Organ Details</a></li>
    <li><a data-toggle="tab" href="#menu2">Hospital Details</a></li>
    <li class="active"><a data-toggle="tab" href="#menu3">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
   
    <div id="home" class="tab-pane fade">
        <h3>DONOR DETAILS</h3>
      <div class="details"><label>Donor ID</label><span class="colon">:</span><span id="donorid">${donorid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="donorname">${donor.firstName} ${donor.lastName}</span></div>
	  <div class="details"><label>Address line 1</label><span class="colon">:</span><span id="donoradd1">${donor.address1}</span></div>
	  <div class="details"><label>Address line 2</label><span class="colon">:</span><span id="donoradd2">${donor.address2}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="donorcity">${donor.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="donorstate">${donor.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="donorzip">${donor.zip}</span></div>
    </div>
    <div id="menu1" class="tab-pane fade">
        <h3>ORGAN DETAILS</h3>
      <p>Below are the list of organs the donor is willing to donate.</p>
	  <ul>
              <c:forEach items="${organsl}" var="organsl" varStatus="status">
              <li>${organsl}</li>
              </c:forEach>
	  </ul>
    </div> 
      <div id="menu2" class="tab-pane fade">
       <h3>HOSPITAL DETAILS</h3>
 <p>Details of the hospital, where the donor opted to harvest his/her organs.</p>
	  <div class="details"><label>Hospital ID</label><span class="colon">:</span><span id="hospid">${hospital.hid}</span></div>
	  <div class="details"><label>Name</label><span class="colon">:</span><span id="hospname">${hospital.hospitalName}</span></div>
	  <div class="details"><label>Address</label><span class="colon">:</span><span id="hospadd1">${hospital.address}</span></div>
	  <div class="details"><label>City</label><span class="colon">:</span><span id="hospcity">${hospital.city}</span></div>
	  <div class="details"><label>State</label><span class="colon">:</span><span id="hospstate">${hospital.state}</span></div>
	  <div class="details"><label>Zip</label><span class="colon">:</span><span id="hospzip">${hospital.zip}</span></div>
            <div class="details"><label>Email</label><span class="colon">:</span><span id="hospzip">${hospital.email}</span></div>
    </div>
    <div id="menu3" class="tab-pane fade in active">
      <h4 align="center">Search Hospitals</h4>
      <p align="center" id="message1" style="color: red" ><i><c:out value="${message}" /></i></p>
     <form class="form-inline" action="CustodianLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospital">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospital" />
        </p>
    
           </form>
        <div id="" class="">
      <p>Below are the list of hospitals</p>
	  <ul>
              <c:forEach var="hdetails" items="${hdetails}">
               <li><a href="CustodianLoginServlet?action=id&hid=${hdetails.hid}">${hdetails.hospitalName}</a></li>   
              </c:forEach>
	  </ul>
    </div>
    </div>
  </div>
        </div>
      <% } %>
    </body>
 
</html>
