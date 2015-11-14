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
        <h1>Welcome to Donor Room</h1>
        Welcome <c:out value="${name}" />
<a href="Logout.jsp">Log out</a>
 <% 
     
        if(request.getAttribute("message1")==null || request.getAttribute("message1")=="")
        
        {
            
        if(request.getAttribute("zip")==null || request.getAttribute("zip")==""){
            

      %>
        
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li class ="active" ><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
        
        
            <div class="container">
                 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Donor Declaration</a></li>
    <li><a data-toggle="tab" href="#menu1">View/Edit Custodian</a></li>
    <li><a data-toggle="tab" href="#menu2">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="Donor Declaration  "> <br>
          </div>
        </div>
    
           </form>
    </div>
    <div id="menu1" class="tab-pane fade">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="View/Edit Custodian"> <br>
          </div>
        </div>
                </form>
    </div>
                   <div id="menu2" class="tab-pane fade">
    <p align="center" id="message" style="color: red" ><i><c:out value="${message1}" /></i></p>
     <form class="form-inline" action="DonorLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospitals">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospitals"/>
        </p>
    
           </form>
    </div>
  </div>
        </div>
     
      <%  }
        else{
            
        %>
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li class ="active" ><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
        
        
            <div class="container">
                 <ul class="nav nav-tabs">
    <li ><a data-toggle="tab" href="#home">Donor Declaration</a></li>
    <li><a data-toggle="tab" href="#menu1">View/Edit Custodian</a></li>
    <li class="active"><a data-toggle="tab" href="#menu2">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="Donor Declaration  "> <br>
          </div>
        </div>
    
           </form>
    </div>
    <div id="menu1" class="tab-pane fade">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="View/Edit Custodian"> <br>
          </div>
        </div>
                </form>
    </div>
                   <div id="menu2" class="tab-pane fade in active">
    <p align="center" id="message" style="color: red" ><i><c:out value="${message1}" /></i></p>
     <form class="form-inline" action="DonorLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospitals">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospitals"/>
        </p>
    
           </form>
         <div id="" class="">
      <p>Below are the list of hospitals</p>
            <ul>
              <c:forEach var="zip" items="${zip}">
               <li><a href="HospitalLoginServlet?action=donorhos&hid=${zip.hid}&name=${uname}">${zip.hospitalName}</a></li>   
              </c:forEach>
	  </ul> 
    </div>
    </div>
  </div>
        </div>  
      <%   }
        }
       else 
        {%>
            <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Organdonationlive</a> 
    </div>
        
       <div>
        <ul class="nav navbar-nav">
          <li><a href="home.jsp">Home</a></li>
          <li class ="active" ><a href="Donor.jsp">Donor</a></li>
          <li><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div>     
      </nav>
        
        
            <div class="container">
                 <ul class="nav nav-tabs">
    <li ><a data-toggle="tab" href="#home">Donor Declaration</a></li>
    <li><a data-toggle="tab" href="#menu1">View/Edit Custodian</a></li>
    <li class="active"><a data-toggle="tab" href="#menu2">Search Hospitals</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="Donor Declaration  "> <br>
          </div>
        </div>
    
           </form>
    </div>
    <div id="menu1" class="tab-pane fade">
                <form action="DonorDeclaration.jsp" method="get"> 
        <div class="form-group">        
            <div class="col-sm-offset-5 col-sm-10">
          <input type="submit" class="btn btn-default" value="View/Edit Custodian"> <br>
          </div>
        </div>
                </form>
    </div>
                   <div id="menu2" class="tab-pane fade in active">
    <p align="center" id="message" style="color: red" ><i><c:out value="${message1}" /></i></p>
     <form class="form-inline" action="DonorLoginServlet" role="form" method="post">
               <input type="hidden" name="action" value="SearchHospitals">
        <p align="center" class="search">
             <label>Search Hospital by Zip code</label>
             <input name="search" type="text" class="txt" />
            <input name="search-btn" type="submit" class="btn" value="Search Hospitals"/>
        </p>
    
           </form>
    </div>
  </div>
        </div>
       <% }%>
    </body>
</html>
