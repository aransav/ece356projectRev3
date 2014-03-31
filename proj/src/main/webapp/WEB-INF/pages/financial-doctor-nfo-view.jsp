<%-- 
    Document   : financial-info-view
    Created on : Mar 30, 2014, 8:50:22 AM
    Author     : siva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Prescription View</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>
    <body>
        <c:forEach items = "${summaryList}" var ="s">
        <tr>
            <td>${s.doctor.user.fname}</td>
            <td>${s.doctor.user.lname}</td>
            <td>${s.totalAppointments}</td>
            <td>${s.totalPatients}</td>
            <br/>
        </tr>
        </c:forEach>
    </body>
</html>
