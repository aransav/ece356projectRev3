<%-- 
    Document   : start-app-select-patient-form
    Created on : Mar 30, 2014, 10:44:55 AM
    Author     : siva
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment Update</title>
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
                <h1 class="page-header text-center">Update Appointment</h1>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <div style="text-align: left;">
                        <label>${errMessage}</label>
                    </div>
                    <form:form role="form" method="post" commandName="appointmentInfoUpdate" action = "submitAppUpdatePatient.html" >
                        <div class ="row" > 
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Doctor's First Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="doctor.user.fname" class="form-control" value="${dpA.doctor.user.fname}" />
                                </div>
                            </div>                    
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Doctor's Last Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="doctor.user.lname" class="form-control" value="${dpA.doctor.user.lname}" />
                                </div>
                            </div>                    
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Doctor's Id</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="doctor.user.id" class="form-control" value="${dpA.doctor.user.id}" />
                                </div>
                            </div>
                        </div>
                        <div class ="row" > 
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Patient's First Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="patient.user.fname" class="form-control" value="${dpA.patient.user.fname}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Patient's Last Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="patient.user.lname" class="form-control" value="${dpA.patient.user.lname}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Patient's Health Card No</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="patient.healthCardNo" class="form-control" value="${dpA.patient.healthCardNo}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Patient's Social Ins No</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="patient.socialInsNo" class="form-control" value="${dpA.patient.socialInsNo}" />
                                </div>
                            </div>
                        </div>
                        <div class ="row" > 
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Date Of Appointment</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="dateOfApp" class="form-control" value="${dpA.appointment.dateOfApp}" />
                                </div> 
                            </div> 
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Status</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="appointment.status" class="form-control" value="${dpA.appointment.status}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Scheduled Length</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="number" path="appointment.schedLength" class="form-control" value="${dpA.appointment.schedLength}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Procedure Description</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="appointment.procedureDesc" class="form-control" value="${dpA.appointment.procedureDesc}" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12" style="padding-top: 5px;">    
                                <div style="text-align: left;">
                                    <label>Comments</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="appointment.comments" class="form-control" value="${dpA.appointment.comments}" />
                                </div>                    
                            </div>
                        </div>
                        <div class="row">
                            <div style="padding-top: 15px">                
                                <form:input type="hidden" path="appointment.id" class="form-control" value="${dpA.appointment.id}" />
                                <button class="btn btn-lg btn-primary btn-block" type="submit" >Update Appointment</button> 
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>


    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.metisMenu.js"></script>
    <script src="resources/js/sb-admin.js"></script>            
</body>
</html>
