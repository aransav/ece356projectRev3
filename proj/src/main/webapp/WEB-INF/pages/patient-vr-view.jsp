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
        <title>Patient Visitation Records</title>
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
                <h1 class="page-header text-center">Visitation Record View</h1>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            
                            <thead>
                                <tr>
                                    <th>Visitation Record ID</th>
                                    <th>Patient Username</th>
                                    <th>Doctor Username</th>
                                    <th>Visit Date</th>
                                    <th>Start Time</th>
                                    <th>End Time</th>
                                    <th>Diagnosis</th>
                                    <th>Surgery Performed</th>
                                    <th>Comments</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${vrList}" var = "v" >
                                    <tr>
                                        <td width="10%">${v.id}</td>
                                        <td width="10%">${v.doctorPatient.patient.user.username}</td>
                                        <td width="10%">${v.doctorPatient.doctor.user.username}</td>
                                        <td width="10%">${v.visitDate}</td>
                                        <td width="10%">${v.startTime}</td>
                                        <td width="10%">${v.endTime}</td>
                                        <td width="10%">${v.diagnosis}</td>
                                        <td width="10%">${v.surgeryPerformed}</td>
                                        <td width="20%">${v.comments}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>                            
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
