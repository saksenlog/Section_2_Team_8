<%-- 
    Document   : Logout
    Created on : 27 Oct, 2015, 4:29:04 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>Hello World!</h1> <%
session.setAttribute("UserName", null);
session.removeAttribute("name");
session.removeAttribute("userName");
session.invalidate();
response.sendRedirect("home.jsp");
%>
    </body>
</html>
