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
        <title>Staff-Doctors List</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>
    <body>

        <c:set var="financeV" scope="session" value="finance" />
        <c:set var="legalV" scope="session" value="legal" />
        <c:set var="patientV" scope="session" value="patient" />
        <c:set var="staffV" scope="session" value="staff" />
        <c:set var="superV" scope="session" value="super" />
        <c:set var="doctorV" scope="session" value="doctor" />

        <c:if test="${role == financeV}" >
            <jsp:include page="header-finance.jsp" />
        </c:if>

        <c:if test="${role == legalV}" >
            <jsp:include page="header-legal.jsp" />
        </c:if> 

        <c:if test="${role == patientV}" >
            <jsp:include page="header-patient.jsp" />
        </c:if> 

        <c:if test="${role == doctorV}" >
            <jsp:include page="header-doctor.jsp" />
        </c:if> 

        <c:if test="${role == staffV}" >
            <jsp:include page="header-staff.jsp" />
        </c:if> 

        <c:if test="${role == superV}" >
            <jsp:include page="header-super.jsp" />
        </c:if> 

        <c:if test="${role == null}" >
            <jsp:include page="header-null.jsp" />
        </c:if>        

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header text-center">Staff Doctor List</h1>
            </div>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div class="panel panel-defaut">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Doctor Username</th>
                                        <th>Doctor First Name</th>
                                        <th>Doctor Last Name</th>
                                        <th>Role</th>
                                        <th>Appointments</th>
                                        <th>Visitation Records</th>
                                        <th>Doctors Patients</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${doctors}" var="i" varStatus="loop">
                                        <tr>
                                            <td width="20%">${i.user.username}</td>
                                            <td width="20%">${i.user.fname}</td>
                                            <td width="20%">${i.user.lname}</td>
                                            <td width="20%">${i.role}</td>
                                            <td width="10%">
                                                <form method="post" action = "listAppointmentsForDoctor.html" >
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="count" value="${i.user.id}">View Doctors Appointments</button> 
                                                </form>                                                    
                                            </td>
                                            <td width="10%">
                                                <form method="post" action = "listVRForDoctor.html" >
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="count" value="${i.user.id}">View Doctors Visitation Records</button> 
                                                </form>                                                    
                                            </td>                                            
                                            <td width="10%">
                                                <form method="post" action = "listPatients.html" >
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="doctorID" value="${i.user.id}">View Doctors Patients</button> 
                                                </form>                                                    
                                            </td>                                            
                                        </tr>
                                    </c:forEach>                                   
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>    


    </body>
</html>
