<%-- 
    Document   : start-app-select-details-form
    Created on : Mar 30, 2014, 11:02:55 AM
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
    <pd>${patient.user.lname},${patient.user.fname}</pd>

    <form:form role="form" method="post" commandName="startAppSelectDetails" action = "submitStartAppForm.html" >
        <div class ="row" > <!--Names -->
            <div class="col-lg-3" style="padding-top: 5px;">
                <div style="text-align: left;">
                    <label>Doctor First Name</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="" class="form-control" value="${doctor2.user.fname}" />
                </div>
                <div style="text-align: left;">
                    <label>Doctor Last Name</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="" class="form-control" value="${doctor2.user.lname}" />
                </div>
                <div style="text-align: left;">
                    <label>Doctor Id</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="" class="form-control" value="${doctor2.user.id}" />
                </div>
            </div>
            <div class="col-lg-4" style="padding-top: 5px;">
                <div style="text-align: left;">
                    <label>Patient First Name</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="patient.user.fname" class="form-control" value="${patient2.user.fname}" />
                </div>
                <div style="text-align: left;">
                    <label>Patient Last Name</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="patient.user.lname" class="form-control" value="${patient2.user.lname}" />
                </div>
                <div style="text-align: left;">
                    <label>Patient Health Card No</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="patient.healthCardNo" class="form-control" value="${patient2.healthCardNo}" />
                </div> 
                <div style="text-align: left;">
                    <label>Patient social Ins No</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="patient.socialInsNo" class="form-control" value="${patient2.socialInsNo}" />
                </div> 
            </div>              
            <div class="col-lg-5" style="padding-top: 5px;">
                <div style="text-align: left;">
                    <label>DateOfApp</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="date" path="appointment.dateOfApp" class="form-control" value="${appointment2.dateOfApp}" />
                </div> 
                <div style="text-align: left;">
                    <label>Comments</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="appointment.comments" class="form-control" value="${appointment2.comments}" />
                </div>
                <div style="text-align: left;">
                    <label>Status</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="appointment.status" class="form-control" value="${appointment2.status}" />
                </div>
                <div style="text-align: left;">
                    <label>schedLength</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="number" path="appointment.schedLength" class="form-control" value="${appointment2.schedLength}" />
                </div>
                <div style="text-align: left;">
                    <label>Procedure Description</label>
                </div>
                <div class="input-group">
                    <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                        <form:input type="text" path="appointment.procedureDesc" class="form-control" value="${appointment2.procedureDesc}" />
                </div>
            </div>
        </div>
    </form:form>
</body>
</html>
