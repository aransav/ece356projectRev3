<%-- 
    Document   : user-update-form
    Created on : Mar 30, 2014, 9:45:19 AM
    Author     : siva
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update Form</title>
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
                <h1 class="page-header text-center">User Update Form</h1>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <form:form role="form" method="post" commandName="user_update_form" action = "submitUserUpdateForm.html" >
                        <div class ="row" > <!--Names -->
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Last Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="lname" class="form-control" value="${user.lname}" />
                                </div>
                            </div>              
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>First Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="fname" class="form-control" value="${user.fname}" />
                                </div>   
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Middle Name</label>
                                </div>              
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="mname" class="form-control" value="${user.mname}" />
                                </div>
                            </div>
                        </div>
                        <div class="row"> <!--Address -->
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Street Number</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="streetno" class="form-control" value="${user.streetno}" />
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Apartment Number</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="aptno" class="form-control" value="${user.aptno}" />
                                </div>
                            </div>                                                
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Street Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="streetname" class="form-control" value="${user.streetname}" />
                                </div>                               
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>City</label>
                                </div>                            
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="city" class="form-control" value="${user.city}" />
                                </div>                            
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Province</label>
                                </div>                                 
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="prov" class="form-control" value="${user.prov}" />
                                </div>                            
                            </div>                        
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Zip Code</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="zip" class="form-control" value="${user.zip}" />
                                </div>                  
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Birth Date</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="text" path="dob" class="form-control" value="${user.dob}" />
                                </div>                  
                            </div>  

                        </div>                    
                        <div class="row"> <!--Contact Numbers -->
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Home Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="tel" path="hphone" class="form-control" value="${user.hphone}" />
                                </div>                  
                            </div>                        
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Cell Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="tel" path="cphone" class="form-control" value="${user.cphone}" />
                                </div>                  
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Work Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="tel" path="wphone" class="form-control" value="${user.wphone}" />
                                </div>                  
                            </div> 
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Emergency Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                        <form:input type="tel" path="ephone" class="form-control" value="${user.ephone}" />
                                </div>                  
                            </div>                             
                        </div>                                
                        <div style="padding-top: 15px">                
                            <button class="btn btn-lg btn-primary btn-block" type="submit" >Save Personal Info</button> 
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
