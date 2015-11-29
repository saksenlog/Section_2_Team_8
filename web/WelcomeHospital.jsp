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
        <title>hospital page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">
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
          <li><a href="Donor.jsp">Donor</a></li>
          <li class ="active"><a href="Hospital.jsp">Hospital</a></li>
          <li><a href="Custodian.jsp">Custodian</a></li>
          <li><a href="#">Contact</a></li>        
          <li><a href="#">FAQ</a></li>
         
        </ul>
       </div> 
      <div>
                  <h2>Enter Your Payment Information</h2>
                         <br> <br>
                        
                   <table>
        <td></td><td></td><td></td>
        <tr><td class="top" colspan="4"></td></tr>
                        <tr>
            <td><br>Credit Card Type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><br>&nbsp;&nbsp;  <select name="type" id="select" required>
                        <option selected="" value="default">Select Card Type</option>
		      <option>Visa</option>
		      <option>Master Card</option>
		      <option>Mastero</option>
	        </select></td>
        <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
          <tr>
            <td><br>Card Number</td>
            <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><br>&nbsp;&nbsp;<input type="text" value="" name="" required></td>
        <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
          <tr>
            <td><br>Expiration Date (MM/YY)</td>
            <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><br>&nbsp;&nbsp;  <select name="expire" id="select">
                        <option selected="" value="default">MM</option>
		      <option>01</option>
		      <option>02</option>
		      <option>03</option>
                      <option>04</option>
		      <option>05</option>
		      <option>06</option>
                      <option>07</option>
		      <option>08</option>
		      <option>09</option>
                      <option>10</option>
		      <option>11</option>
		      <option>12</option>
	        </select><select name="expire" id="select">
                        <option selected="" value="default">YY</option>
		      <option>15</option>
		      <option>16</option>
		      <option>17</option>
                       <option>18</option>
		      <option>19</option>
		      <option>20</option>
                       <option>21</option>
		      <option>22</option>
		      <option>23</option>
                       <option>24</option>
		      <option>25</option>
		      <option>26</option>
                       <option>27</option>
		      <option>28</option>
		      <option>29</option>
	        </select></td>
        <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
         <tr>
            <td><br>CVV (3 digit)</td>
            <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><br>&nbsp;&nbsp;<input type="text" value="" name="" maxlength="3" required></td>
        <td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
       <td></td><td></td><td></td>
      
	<tr><td class="bottom" colspan="4"></td></tr>
        <tr>
            <td><br>Your Card will be charged with a total of</td><td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$<c:out value="${theShoppingCart.getsubTotal()}"/> </td>
	</tr>
        <td></td>
	 <tr>
            <td></td><td></td><td><br><b></b></td><td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="one" type="submit" name="action"  value="Confirm Payment"></td>
         </tr>
                           </table>
          
          
          
          
      </div>
      
      
      
      
      
  </div>
      </nav>
    
        
    </body>
</html>
