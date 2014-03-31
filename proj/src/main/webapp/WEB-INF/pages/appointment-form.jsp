<%-- 
    Document   : appointment-form
    Created on : Mar 30, 2014, 8:56:19 AM
    Author     : siva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Appointment Form</title>
    </head>
    <body>
        <form action = "appointmentSubmit.html" method="POST">
            Doctor username: <input type="text" name="doctor"> <br />
            Patient username: <input type="text" name="patient"> <br />
            DateOfApp: <input type="date" name="dateOfApp"> <br />
            Comments: <input type="text" name="comments"> <br />
            schedlength:  <input type="text" name="schedlength"> <br />
            procedureDesc:  <input type="text" name="procedureDesc">
            status:  <input type="text" name="status">

            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
