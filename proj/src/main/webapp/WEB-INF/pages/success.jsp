<%-- 
    Document   : success
    Created on : 28-Mar-2014, 8:34:03 PM
    Author     : siva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>
    <body>
        <h1>SUCCESS</h1>
         <p>name: ${user1.username} and ${user1.password} </p>
         <p>role: ${role} </p>
    </body>
    <!-- Core Scripts -->
    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.metisMenu.js"></script>
    <script src="resources/js/sb-admin.js"></script>    
</html>
