<%-- 
    Document   : list-patients-for-doctor
    Created on : Mar 30, 2014, 3:09:21 PM
    Author     : siva
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <c:forEach items="${patients}" var="i">
            <p>${i.user.username}</p>
        </c:forEach>
    </body>
</html>
