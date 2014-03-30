<%-- 
    Document   : patient-prescrip-view
    Created on : Mar 30, 2014, 7:51:13 AM
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

    <c:forEach items="${precripList}" var = "p" >
        <tr>
            <td>anything?</td>
            <td>${p.id}</td>
            <td>${p.prescription.name}</td>
            <td>${p.startDate}</td>
            <td>${p.expiryDate}</td>
        </tr>
    </c:forEach>
</body>
</html>
