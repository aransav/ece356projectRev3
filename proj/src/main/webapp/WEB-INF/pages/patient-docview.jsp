<%-- 
    Document   : user-info-view
    Created on : Mar 30, 2014, 8:42:44 AM
    Author     : siva
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information Page</title>
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
        ${errMessage1}
        ${errMessage2}
        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <form role="form"> <!-- Start of form for patient info -->                                      
                        <div class ="row" > <!--Names -->
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Last Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="lname" class="form-control" placeholder="${patient2.user.lname}" disabled>
                                </div>
                            </div>              
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>First Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="fname" class="form-control" placeholder="${patient2.user.fname}" disabled>
                                </div>   
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Middle Name</label>
                                </div>              
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="mname" class="form-control" placeholder="${patient2.user.mname}" disabled>
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
                                    <input type="text" name="add_streetno" class="form-control" placeholder="${patient2.user.streetno}" disabled>
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Apartment Number</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_aptno" class="form-control" placeholder="${patient2.user.aptno}" disabled>
                                </div>
                            </div>                                                
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Street Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_street" class="form-control" placeholder="${patient2.user.streetname}" disabled>
                                </div>                               
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>City</label>
                                </div>                            
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_city" class="form-control" placeholder="${patient2.user.city}" disabled>
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
                                    <input type="text" name="add_prov" class="form-control" placeholder="${patient2.user.prov}" disabled>
                                </div>                            
                            </div>                        
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Zip Code</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_zip" class="form-control" placeholder="${patient2.user.zip}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Birth Date</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="dob" class="form-control" placeholder="${patient2.user.dob}" disabled>
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
                                    <input type="tel" name="phone_no_home" class="form-control" placeholder="${patient2.user.hphone}" disabled>
                                </div>                  
                            </div>                        
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Cell Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_cell" class="form-control" placeholder="${patient2.user.cphone}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Work Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_work" class="form-control" placeholder="${patient2.user.wphone}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Emergency Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_emerg" class="form-control" placeholder="${patient2.user.ephone}" disabled>
                                </div>                  
                            </div>                                              

                        </div>
                        <div class="row">
                            <div class="col-lg-6" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Health Card Number</label>
                                </div>                                 
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="healthCardNo" class="form-control" placeholder="${patient2.healthCardNo}" disabled>
                                </div>                            
                            </div>                        
                            <div class="col-lg-6" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Social Insurance Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="socialInsNo" class="form-control" placeholder="${patient2.socialInsNo}" disabled>
                                </div>                  
                            </div>
                        </div>        
                    </form> <!-- End of form for patient info -->                    
                </div>
            </div>
        </div>
        <div class="col-lg-7">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Doctor Doctor Name</th>
                                    <th>Patient Patient Name</th>
                                    <th>Primary Doctor</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="i" >
                                    <tr>
                                        <td width="40%">${i.doctor.user.username}</td>
                                        <td width="40%">${i.patient.user.username}</td>
                                        <c:if test="${i.primaryDoctor == true}">
                                            <td width="20%" class="success">Yes</td> 
                                        </c:if>
                                        <c:if test="${i.primaryDoctor == false}">
                                            <td width="20%" class="danger">No</td>
                                        </c:if>
                                    </tr>
                                </c:forEach>                                   
                            </tbody>
                        </table>                            
                    </div>
                </div>
            </div>            
        </div>
        <c:if test="${dp2.isPrimaryDoctor() == true}">                        
            <div class="col-lg-5">
                <form method="post" action = "viewpatientdocviewADD.html" >
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="count" value="${dp2.patient.user.username}">Add Doctor to Patient</button> 
                </form>  
            </div>
        </c:if>
        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>    


    </body>
</html>
