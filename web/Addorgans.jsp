<%-- 
    Document   : Addorgans
    Created on : 23 Nov, 2015, 7:26:48 PM
    Author     : User
--%>

<%@page import="com.test.webapp.constants.CommonConstants"%>
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
        <% 
            
            String addorganValid = (String)request.getAttribute("addorganValid");
            if(null != addorganValid && (CommonConstants.TRUE).equalsIgnoreCase(addorganValid)){
        %>

            <div class="alert alert-success fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Success!</strong> Organs added Successfully...

            </div>
        <%     
            }else if(("false").equalsIgnoreCase(addorganValid)){
        %>
            

            <div class="alert alert-danger fade in">

                <a href="#" class="close" data-dismiss="alert">&times;</a>

                <strong>Error!</strong> A problem has been occurred while submitting your data.

            </div>


        <%
            }else{}
            
        %>
        <div class="container">
            <h4> Organs </h4>
            <p>The organs of the body that can be transplanted at the current time are kidneys, heart, lungs, liver, pancreas, and the intestines. Kidney/pancreas transplants, heart/lung transplants, and other combined organ transplants also are performed. Organs cannot be stored and must be used within hours of removing them from the donor's body. Most donated organs are from people who have died, but a living individual can donate a kidney, part of the pancreas, part of a lung, part of the liver, or part of the intestine.</p>
  <h2>Enter the Harvested organ details:</h2>
  <form class="form-horizontal" role="form" action="HospitalLoginServlet" method="post">
      <input type="hidden" name="action" value="addorgans">
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
        <label class="control-label col-sm-2" for="OrganName">Organ-Name</label>
        <div class="col-sm-3"> 
        <select class="form-control" name ="OrganName" id="OrganName">
    <option>SELECT ORGAN</option>        
    <option>Kidneys</option>
    <option>Heart</option>
    <option>Lungs</option>
    <option>Liver</option>
    <option>Pancreas</option>
    <option>Intestines</option>
    <option>Eyes</option>
    
  </select>
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
        <label class="control-label col-sm-2" for="Rh factor">Rh factor</label>
        <div class="col-sm-3"> 
        <select class="form-control" name ="Rhfactor" id="Rh factor">
    <option>SELECT VALUES</option>        
    <option>Positive</option>
    <option>Negative</option>
    
  </select>
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
