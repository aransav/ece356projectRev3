<%-- 
    Document   : header
    Created on : Mar 30, 2014, 5:55:46 AM
    Author     : Aran
--%>


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
                <ul class="nav navbar-top-links navbar-right"> 
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                    <c:choose>
                        <c:when test="${role == "patient"}">
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="userProf.html"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Patient Info</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Appointments</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Visitation Records</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                        </c:when>
                        <c:when test="${role == "doctor"}">
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="userProf.html"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Patient Info</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Prescription Info</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Appointments</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Visitation Records</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                        </c:when>
                        <c:when test="${role == "legal"}">
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="userProf.html"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Patient Info</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Appointments</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Visitation Records</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                        </c:when>
                        <c:when test="${role == "finance"}">
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="userProf.html"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Patient Info</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Appointments</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Visitation Records</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="logoutRefresh.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                    </li>                
                </ul>            
            </nav>
        <script src="resources/js/jquery-1.10.2.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.metisMenu.js"></script>
        <script src="resources/js/sb-admin.js"></script>   