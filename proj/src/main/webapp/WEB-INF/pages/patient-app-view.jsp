<%-- 
    Document   : patient-app-view
    Created on : Mar 30, 2014, 7:28:29 AM
    Author     : siva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>
    <body>
        <!-- add script and header here -->
        <p>Hello</p>
        <p>${size}</p>

        <c:forEach items="${appList}" var = "app" >
        <tr>
            <td>${app.doctorPatient.patient.user.username}</td>
            <td>${app.dateOfApp}</td>
            <td>${app.comments}</td>
            <td>${app.status}</td>
            <td>${app.schedLength}</td>
            <td>${app.procedureDesc}</td>
        </tr>
    </c:forEach>


</body>
</html>
