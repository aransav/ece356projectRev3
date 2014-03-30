<%-- 
    Document   : patient-vr-view
    Created on : Mar 30, 2014, 8:16:33 AM
    Author     : siva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <p>Hello</p>
        <p>${size}</p>

    <c:forEach items="${vrList}" var = "v" >
        <tr>
            <td>anything?</td>
            <td>${v.id}</td>
            <td>${v.doctorPatient.patient.user.username}</td>
        </tr>
    </c:forEach>
</body>
</html>
