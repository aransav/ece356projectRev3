<%-- 
    Document   : dashboard-base
    Created on : Mar 30, 2014, 5:24:54 AM
    Author     : Aran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <style type="text/css"> @import url("resources/css/main.css"); </style>
    </head>
    <body>

    <c:set var="role" scope="session" value="finance" />
    
    <c:set var="finance" scope="session" value="finance" />
    <c:set var="legal" scope="session" value="legal" />
    <c:set var="patient" scope="session" value="patient" />
    <c:set var="staff" scope="session" value="staff" />
    <c:set var="super" scope="session" value="super" />
    <c:set var="doctor" scope="session" value="doctor" />
    
    <c:if test="${role == finance}" >
        <jsp:include page="header-finance.jsp" />
    </c:if>

    <c:if test="${role == legal}" >
        <jsp:include page="header-legal.jsp" />
    </c:if> 
    
    <c:if test="${role == patient}" >
        <jsp:include page="header-patient.jsp" />
    </c:if> 
    
    <c:if test="${role == doctor}" >
        <jsp:include page="header-doctor.jsp" />
    </c:if> 
    
    <c:if test="${role == staff}" >
        <jsp:include page="header-staff.jsp" />
    </c:if> 
    
    <c:if test="${role == super}" >
        <jsp:include page="header-super.jsp" />
    </c:if> 
    
    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.metisMenu.js"></script>
    <script src="resources/js/sb-admin.js"></script>    

</body>
</html>

