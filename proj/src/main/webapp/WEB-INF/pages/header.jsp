        <c:set var="finance" scope="session" value="finance" />
        <c:set var="legal" scope="session" value="legal" />
        <c:set var="patient" scope="session" value="patient" />
        <c:set var="staff" scope="session" value="staff" />
        <c:set var="super" scope="session" value="super" />
        <c:set var="doctor" scope="session" value="doctor" />

        <c:if test="${role == finance}" >
            <jsp:include page="header-finance.jsp" />
        </c:if>

        <c:if test="${role == legal}" >
            <jsp:include page="header-legal.jsp" />
        </c:if> 

        <c:if test="${role == patient}" >
            <jsp:include page="header-patient.jsp" />
        </c:if> 

        <c:if test="${role == doctor}" >
            <jsp:include page="header-doctor.jsp" />
        </c:if> 

        <c:if test="${role == staff}" >
            <jsp:include page="header-staff.jsp" />
        </c:if> 

        <c:if test="${role == super}" >
            <jsp:include page="header-super.jsp" />
        </c:if> 