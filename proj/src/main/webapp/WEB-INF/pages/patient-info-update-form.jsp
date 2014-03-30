<%-- 
    Document   : patient-info-update-form
    Created on : Mar 30, 2014, 10:18:40 AM
    Author     : siva
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>
    <body>
        <form:form role="form" method="post" commandName="patientUpdateInfoView" action = "submitpatientUpdateInfoForm.html" >
            <div class ="row" > <!--Names -->
                <div class="col-lg-4" style="padding-top: 5px;">
                    <div style="text-align: left;">
                        <label>Health Card Number</label>
                    </div>
                    <div class="input-group">
                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                            <form:input type="text" path="healthCardNo" class="form-control" value="${patient.healthCardNo}" />
                    </div>
                </div>              
                <div class="col-lg-4" style="padding-top: 5px;">
                    <div style="text-align: left;">
                        <label>Social Insurance Number</label>
                    </div>
                    <div class="input-group">
                        <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                            <form:input type="number" path="socialInsNo" class="form-control" value="${patient.socialInsNo}" />
                    </div>   
                </div>
                <div style="padding-top: 15px">                
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Save</button> 
                </div>
            </div>
        </form:form>
    </body>
</html>
