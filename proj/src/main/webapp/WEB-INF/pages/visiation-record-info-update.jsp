<%-- 
    Document   : financial-info-view
    Created on : Mar 30, 2014, 8:50:22 AM
    Author     : siva
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Visitation Records</title>
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
                <h1 class="page-header text-center">Update Visitation Records</h1>
            </div>
        </div>




        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <form:form role="form" method="post" commandName="visiationRecordInfoUpdate" action = "submitVRUpdate.html" >
                        <div class ="row" > <!--Names -->
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Doctor Username</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="doctorPatient.doctor.user.username" class="form-control" value="${v.doctorPatient.doctor.user.username}" />
                                </div>
                            </div>              
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Patient Username</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="doctorPatient.patient.user.username" class="form-control" value="${v.doctorPatient.patient.user.username}" />
                                </div>   
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Visit Date</label>
                                </div>              
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="visitDate" class="form-control" value="${v.visitDate}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Revision Number</label>
                                </div>              
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="revNo" class="form-control" value="${v.revNo}" />
                                </div>
                            </div>                                
                        </div>
                        <div class="row"> <!--Address -->
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Start Time</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="startTime" class="form-control" value="${v.startTime}" />
                                </div>
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>End Time</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="endTime" class="form-control" value="${v.endTime}" />
                                </div>
                            </div>                                                
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Visit Prescription ID</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="visitPrescription.id" class="form-control" value="${v.visitPrescription.id}" />
                                </div>                               
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-lg-6" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Diagnosis</label>
                                </div>                                 
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="diagnosis" class="form-control" value="${v.diagnosis}" />
                                </div>                            
                            </div>                        
                            <div class="col-lg-6" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Surgery Performed</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <form:input type="text" path="surgeryPerformed" class="form-control" value="${v.surgeryPerformed}" />
                                </div>                  
                            </div>
                        </div>   
                        <div class="col-lg-12" style="padding-top: 5px;">
                            <div style="text-align: left;">
                                <label>Comments</label>
                            </div>                         
                            <div class="input-group">                                
                                <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                <form:input type="text" path="comments" class="form-control" value="${v.comments}" />
                                <form:input type="hidden" path="id" class="form-control" value="${v.id}" />
                            </div>                  
                        </div>                             
                </div>                                
                <div style="padding-top: 15px">                
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Save Visitation Record</button> 
                </div>
                </form:form>
            </div>
        </div>
      


    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.metisMenu.js"></script>
    <script src="resources/js/sb-admin.js"></script>
</body>
</html>
