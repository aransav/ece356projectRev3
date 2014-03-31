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
        <title>Legal</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
        <style type="text/css"> @import url("resources/css/dataTables.bootstrap.css"); </style> 
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
                <h1 class="page-header text-center">Legal</h1>
            </div>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div class="panel panel-defaut">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Doctor Username</th>
                                        <th>Patient Username</th>
                                        <th>Appointment ID</th>
                                        <th>Date of Appointment</th>
                                        <th>Status</th>
                                        <th>Scheduled Length</th>
                                        <th>Procedure Description</th>
                                        <th>Comment</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_appointment}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.doctorPatient.doctor.user.username}</td>
                                            <td width="10%">${v.doctorPatient.patient.user.username}</td>
                                            <td width="10%">${v.id}</td>
                                            <td width="10%">${v.dateOfApp}</td>
                                            <td width="10%">${v.status}</td>
                                            <td width="10%">${v.schedLength}</td>
                                            <td width="10%">${v.procedureDesc}</td>
                                            <td width="20%">${v.comments}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Patient Username</th>
                                        <th>Primary Doctor</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_doctorPatient}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.doctor.user.username}</td>
                                            <td width="10%">${v.patient.user.username}</td>
                                            <td width="10%">${v.primaryDoctor}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Staff Username</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_doctorStaff}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.doctor.user.username}</td>
                                            <td width="10%">${v.staff.user.username}</td>
                                        </tr>
                                    </c:forEach>                          
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Patient Username</th>
                                        <th>Patient First Name</th>
                                        <th>Patient Last Name</th>
                                        <th>Health Card No</th>
                                        <th>Social Ins No</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_patient}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.user.username}</td>
                                            <td width="10%">${v.user.fname}</td>
                                            <td width="10%">${v.user.lname}</td>
                                            <td width="10%">${v.healthCardNo}</td>
                                            <td width="10%">${v.socialInsNo}</td>
                                        </tr>
                                    </c:forEach>                                
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Prescription ID</th>
                                        <th>Prescription Name</th>
                                        <th>Prescription Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_prescription}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.id}</td>
                                            <td width="10%">${v.name}</td>
                                            <td width="10%">${v.description}</td>
                                        </tr>
                                    </c:forEach>                  
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Staff Username</th>
                                        <th>Role</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_staff}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.user.username}</td>
                                            <td width="10%">${v.role}</td>

                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>User Username</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Middle Name</th>
                                        <th>Street No</th>
                                        <th>Street Name</th>
                                        <th>Apt No</th>
                                        <th>City</th>
                                        <th>Province</th>
                                        <th>Zip</th>
                                        <th>Home Phone Number</th>
                                        <th>Cell Phone Number</th>
                                        <th>Work Phone Number</th>
                                        <th>Emergency Phone Number</th>
                                        <th>Date of Birth</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_user}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.username}</td>
                                            <td width="10%">${v.fname}</td>
                                            <td width="10%">${v.lname}</td>
                                            <td width="10%">${v.mname}</td>
                                            <td width="10%">${v.streetno}</td>
                                            <td width="10%">${v.streetname}</td>
                                            <td width="10%">${v.aptno}</td>
                                            <td width="10%">${v.city}</td>
                                            <td width="10%">${v.province}</td>
                                            <td width="10%">${v.zip}</td>
                                            <td width="10%">${v.hphone}</td>
                                            <td width="10%">${v.cphone}</td>
                                            <td width="10%">${v.wphone}</td>
                                            <td width="10%">${v.ephone}</td>
                                            <td width="10%">${v.dob}</td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Username</th>
                                        <th>Login Time</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_userLoginLog}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.user.username}</td>
                                            <td width="10%">${v.login_time}</td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
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
                                        <th>Patient Username</th>
                                        <th>Visitation Date</th>
                                        <th>Revision Number</th>
                                        <th>Start Time</th>
                                        <th>End Time</th>
                                        <th>Diagnosis</th>
                                        <th>Surgery Performed</th>
                                        <th>comments</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${l_visitationRecord}" var = "v" >
                                        <tr>
                                            <td width="10%">${v.doctorPatient.doctor.user.username}</td>
                                            <td width="10%">${v.doctorPatient.patient.user.username}</td>
                                            <td width="10%">${v.visitDate}</td>
                                            <td width="10%">${v.revNo}</td>
                                            <td width="10%">${v.startTime}</td>
                                            <td width="10%">${v.endTime}</td>
                                            <td width="10%">${v.diagnosis}</td>
                                            <td width="10%">${v.surgeryPerformed}</td>
                                            <td width="10%">${v.comments}</td>
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
        <script src="resources/js/dataTables.bootstrap.js"></script>
    </body>
</html>
