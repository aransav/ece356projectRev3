<%-- 
    Document   : index
    Created on : Mar 24, 2014, 11:20:16 PM
    Author     : Aran
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    
    </head>

    <body>

        <div class="container" id="signbodyCenter">
            <form:form class="form-horizontal" role="form" commandName = "login-entity" action="/proj/process-user.html" method="post">
                <h2 class="form-signin-heading">Please Sign In</h2>

                <div class ="form-group has-error"> 
                    <div class="input-group" style="padding-top: 5px;">
                        <span class ="input-group-addon"><i class="fa fa-user"></i></span>
                        <form:input type="text" path="username" class="form-control" placeholder="${user1.username}" />
                        <span class ="input-group-addon"><i class="fa fa-times"></i></span>
                    </div>
                </div>

                <div class ="form-group has-error">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <form:input type="password" path="password" class="form-control" value="" />
                        <span class ="input-group-addon"><i class="fa fa-times"></i></span>
                    </div>
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button> 
                <div class="form-group">
                    <div class="col-md-12 control">
                        <div style="padding-top:15px; font-size:85%" >
                            Don't have an account! 
                            <a href="signupPage.jsp" >
                                Sign Up Here
                            </a>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12 control">
                        <div style="font-size:85%" >
                            Forgot Password? 
                            <a href="resetpassPage.jsp" >
                                Reset it Here
                            </a>
                        </div>
                    </div>
                </div>
            </form:form>

        </div> <!-- /container --> 

        <!-- Core Scripts -->
        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>

    </body>
</html>


