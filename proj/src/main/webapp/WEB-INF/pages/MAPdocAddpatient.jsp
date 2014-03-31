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
        <title>Assign Patient to Doctor</title>
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
                <h1 class="page-header text-center">Assign Patient to Doctor</h1>
            </div>
        </div>   

        <div class="container" id="patientinfobodyCenter">
            <div class="col-lg-12">
                <div class="panel panel-defaut">
                    <div class="panel-body">

                        <form:form role="form" method="post" commandName="patientAddDoc" action = "viewpatientdocviewADDP2.html" >
                            <div class ="row" > <!--Names -->
                                <div class="col-lg-12" style="padding-top: 5px;">
                                    <div class="input-group">
                                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <span class ="input-group-addon"> <div style="width: 250px; text-align: left; font-weight: bold">Patient Username</div></span>
                                        <form:input type="text" path="patient.user.username" class="form-control" value="${patient2.user.username}" readonly="true"/>
                                    </div>
                                </div>    
                            </div>
                            <div class="row"> 
                                <div class="col-lg-12" style="padding-top: 5px;">
                                    <div class="input-group">
                                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <span class ="input-group-addon"><div style="width: 250px; text-align: left; font-weight: bold;">Doctor Username</div></span>
                                        <form:input type="text" path="doctor.user.username" class="form-control" />
                                    </div>   
                                </div>
                            </div>
                            <div class="col-lg-12" style="padding-top: 15px">                
                                <button class="btn btn-lg btn-primary btn-block" type="submit" >Allow Doctor Access</button> 
                            </div>
                        </div>
                    </form:form>                        
                        
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
