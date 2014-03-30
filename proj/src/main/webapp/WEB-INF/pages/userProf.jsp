<%-- 
    Document   : userProf
    Created on : Mar 26, 2014, 1:45:05 AM
    Author     : Aran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Core CSS - Include with every page -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="css/plugins/timeline/timeline.css" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <style type="text/css"> @import url("resources/css/main.css"); </style>
    
  </head>

  <body>
       <div id="wrapper">

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="frontPage.jsp">Super Cool New Program</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="userProf.jsp"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

        </nav>
        <!-- /.navbar-static-top -->

        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Random Chart 1</a>
                            </li>
                            <li>
                                <a href="#">Random Chart 2</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i> Tables</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> Forms</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i>Settings<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Personal Settings</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Item</a>
                            </li>
                            <li>
                                <a href="#">Third Level <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Item</a>
                                    </li>
                                </ul>
                                <!-- /.nav-third-level -->
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li class="active">
                        <a href="#"><i class="fa fa-files-o fa-fw"></i>Other Pages<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="logoutRefresh.html">Login Page</a>
                            </li>
                            <li>
                                <a href="userProf.jsp">User Profile</a>
                            </li>                            
                            <li>
                                <a href="makeAppointment.jsp">Make New Appointment</a>
                            </li>                            
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
                <!-- /#side-menu -->
            </div>
            <!-- /.sidebar-collapse -->
        </nav>
        <!-- /.navbar-static-side -->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">User Profile</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form role="form"> <!-- Start of form for patient info -->                                      
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
                                    <div class="col-lg-3" style="padding-top: 5px;">
                                        <div style="text-align: left;">
                                            <label>Middle Name</label>
                                        </div>              
                                        <div class="input-group">
                                            <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                            <input type="text" name="mname" class="form-control" placeholder="${user.mname}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-lg-1" style="padding-top: 5px;">
                                        <div class="checkbox" style="text-align: left;">
                                          <label>
                                            <input name="male" type="checkbox" disabled>Male
                                          </label>
                                        </div>                 
                                        <div class="checkbox" style="text-align: left;">
                                          <label>
                                            <input name="female" type="checkbox" disabled>Female
                                          </label>
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
                                            <input type="text" name="add_streetno" class="form-control" placeholder="${user.streetname}" disabled>
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
                                            <input type="text" name="add_street" class="form-control" placeholder="${user.streetno}" disabled>
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
                                    <div class="col-lg-2" style="padding-top: 5px;">
                                        <div style="text-align: left;">
                                            <label>Province</label>
                                        </div>                                 
                                        <div class="input-group">
                                            <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                            <input type="text" name="add_prov" class="form-control" placeholder="${user.prov}" disabled>
                                        </div>                            
                                    </div>                        
                                    <div class="col-lg-2" style="padding-top: 5px;">
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
                                            <label>Health Card Number</label>
                                        </div>                         
                                        <div class="input-group">                                
                                            <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                            <input type="text" name="hcard" class="form-control" placeholder="${patient.healthCardNo}" disabled>
                                        </div>                  
                                    </div>                            
                                   <div class="col-lg-4" style="padding-top: 5px;">
                                        <div style="text-align: left;">
                                            <label>Social Insurance Number</label>
                                        </div>                         
                                        <div class="input-group">                                
                                            <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                            <input type="text" name="scard" class="form-control" placeholder="${patient.socialInsNo}" disabled>
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
                                            <label>Birth Date</label>
                                        </div>                         
                                        <div class="input-group">                                
                                            <span class ="input-group-addon"><i class="fa fa-user" style="width: 10px;"></i></span>
                                            <input type="text" name="dob" class="form-control" placeholder="${user.dob}" disabled>
                                        </div>                  
                                    </div>                           
                                </div>                                                          
                            </form> <!-- End of form for patient info -->
                        </div>
                        <div class="panel-body">
                            <div class ="col-lg-4">
                                <form METHOD="LINK" ACTION="userProfEdit.html">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Update Personal Info</button> 
                                </form>
                            </div>
                        </div>                           
                    </div>
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