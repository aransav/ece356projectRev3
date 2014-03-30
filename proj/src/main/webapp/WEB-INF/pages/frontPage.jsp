<%-- 
    Document   : frontPage
    Created on : Mar 29, 2014, 4:58:42 PM
    Author     : Aran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css"> @import url("resources/css/main.css"); </style> 
    </head>



    <!-- Body of the Page -->
    <body>
        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>   

        <div id="wrapper">  
            <jsp:include page="header.jsp" />

            <!-- Actual Page Panel -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Dashboard</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <h3> add current appointment list here </h3>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form:form role="form">

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    


    </body>

</html>
