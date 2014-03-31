<%-- 
    Document   : user-info-view
    Created on : Mar 30, 2014, 8:42:44 AM
    Author     : siva
--%>

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
                <h1 class="page-header text-center">User Information Page</h1>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-defaut">
                <div class="panel-body">
                    <form role="form" method="post" action="displayUserUpdateForm.html"> <!-- Start of form for patient info -->                                      
                        <div class ="row" > <!--Names -->
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Last Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="lname" class="form-control" placeholder="${user.lname}" disabled>
                                </div>
                            </div>              
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>First Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="fname" class="form-control" placeholder="${user.fname}" disabled>
                                </div>   
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Middle Name</label>
                                </div>              
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="mname" class="form-control" placeholder="${user.mname}" disabled>
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
                                    <input type="text" name="add_streetno" class="form-control" placeholder="${user.streetno}" disabled>
                                </div>
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Apartment Number</label>
                                </div>                             
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_aptno" class="form-control" placeholder="${user.aptno}" disabled>
                                </div>
                            </div>                                                
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Street Name</label>
                                </div>
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_street" class="form-control" placeholder="${user.streetname}" disabled>
                                </div>                               
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>City</label>
                                </div>                            
                                <div class="input-group">
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_city" class="form-control" placeholder="${user.city}" disabled>
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
                                    <input type="text" name="add_prov" class="form-control" placeholder="${user.prov}" disabled>
                                </div>                            
                            </div>                        
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Zip Code</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="add_zip" class="form-control" placeholder="${user.zip}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-4" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Birth Date</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="text" name="dob" class="form-control" placeholder="${user.dob}" disabled>
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
                                    <input type="tel" name="phone_no_home" class="form-control" placeholder="${user.hphone}" disabled>
                                </div>                  
                            </div>                        
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Cell Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_cell" class="form-control" placeholder="${user.cphone}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Work Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_work" class="form-control" placeholder="${user.wphone}" disabled>
                                </div>                  
                            </div>
                            <div class="col-lg-3" style="padding-top: 5px;">
                                <div style="text-align: left;">
                                    <label>Emergency Phone Number</label>
                                </div>                         
                                <div class="input-group">                                
                                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                    <input type="tel" name="phone_no_emerg" class="form-control" placeholder="${user.ephone}" disabled>
                                </div>                  
                            </div>                                              

                        </div>
                        <div style="padding-top: 15px">                
                            <button class="btn btn-lg btn-primary btn-block" type="submit" >Edit Personal Info</button> 
                        </div>
                    </form> <!-- End of form for patient info -->                    
                </div>
            </div>
        </div>


        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>    


    </body>
</html>
