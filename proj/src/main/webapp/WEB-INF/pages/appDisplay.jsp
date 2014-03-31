<%-- 
    Document   : appDisplay
    Created on : Mar 31, 2014, 4:34:36 AM
    Author     : Aran
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <style type="text/css"> @import url("resources/css/main.css"); </style>
        <title>Appointment Display</title>
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
                <h1 class="page-header text-center">Appointment Display</h1>
            </div>
        </div>   

        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Status</th>
                                    <th>Doctor Name</th>
                                    <th>Doctor Username</th>
                                    <th>Scheduled Length</th>
                                    <th>Procedure Description</th>
                                    <th>Comments</th>
                                    <c:if test="${role == staffV}" >
                                        <th>Actions</th>
                                    </c:if>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${apps}" var = "a" varStatus="loop">
                                    <tr>
                                        <td width="10%">${a.dateOfApp}</td>
                                        <td width="10%">${a.status}</td>                                        
                                        <td width="10%">${a.doctorPatient.doctor.user.fname}</td>
                                        <td width="10%">${a.doctorPatient.doctor.user.username}</td>
                                        <td width="10%">${a.schedLength}</td>
                                        <td width="20%">${a.procedureDesc}</td>
                                        <td width="20%">${a.comments}</td>
                                        <c:if test="${role == staffV}" >
                                            <td width="10%">
                                                <form method="post" action = "appointmentInfoUpdate.html" >
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="count" value="${a.id}">Edit Appointment</button> 
                                                </form>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>                            
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${role == staffV}" >
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-defaut">
                        <div class="panel-body">
                            <form role="form" method="post" action = "startAppSelectPatient.html" >
                                <button class="btn btn-lg btn-primary btn-block" type="submit" >Add New Appointment</button> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>        
        </c:if>
        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>               
    </body>
</html>
