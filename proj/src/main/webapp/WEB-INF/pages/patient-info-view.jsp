<%-- 
    Document   : patient-info-view
    Created on : Mar 30, 2014, 10:14:51 AM
    Author     : siva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Information Page</title>
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
                <h1 class="page-header text-center">Patient Information Page</h1>
            </div>
        </div>
        <div class="container" id="patientinfobodyCenter">
            <div class="col-lg-12">
                <div class="panel panel-defaut">
                    <div class="panel-body">
                        <form role="form" method="post" action="patientUpdateInfoView.html"> <!-- Start of form for patient info -->                                      
                            <div class ="row" > <!--Names -->
                                <div class="col-lg-12" style="padding-top: 5px;">
                                    <div class="input-group" >
                                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <span class ="input-group-addon"> <div style="width: 250px; text-align: left; font-weight: bold">Patient Health Card Number</div></span>
                                        <input type="text" name="healthCardNo" class="form-control" placeholder="${patient.healthCardNo}" disabled>
                                    </div>
                                </div>  
                            </div>
                            <div class="row" >
                                <div class="col-lg-12" style="padding-top: 5px;">
                                    <div class="input-group">
                                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <span class ="input-group-addon"><div style="width: 250px; text-align: left; font-weight: bold;">Patient Social Insurance Number</div></span>
                                        <input type="text" name="socialInsNo" class="form-control" placeholder="${patient.socialInsNo}" disabled>
                                    </div>   
                                </div>
                            </div>
                            <div class="col-lg-12" style="padding-top: 15px">                
                                <button class="btn btn-lg btn-primary btn-block" type="submit" >Edit Patient Info</button> 
                            </div>
                        </form>
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
