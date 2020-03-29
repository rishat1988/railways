<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>Update Schedule</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
        </style>
</head>
<body>
<c:url value="/ScheduleUpdate/" var="var"/>
<sf:form action="/ScheduleUpdate" method="post" modelAttribute="schedule">

    <br>
    <a href="${pageContext.request.contextPath}/StationManagement">Manage Stations</a>
    <br>
    <a href="${pageContext.request.contextPath}/TrainManagement">Manage Trains</a>
    <br>
    <a href="${pageContext.request.contextPath}/ScheduleManagement">Manage Schedules</a>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>

    <div>
        <sf:input type="hidden" path="id"/>
        <sf:errors type="hidden" path="id"/>
    </div>
    <div>
        <sf:label path="trainNumber">Train Number</sf:label>
        <sf:select path="trainNumber">
            <c:forEach items="${scheduleStationsList}" var="scheduleTrain">
                <sf:option value="${scheduleTrain}"/>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <sf:label path="stationName">Station Name</sf:label>
        <sf:select path="stationName">
            <c:forEach items="${scheduleStationsList}" var="scheduleStation">
                <sf:option value="${scheduleStation}"/>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <sf:label path="arrivalTime">Arrival Time</sf:label>
        <sf:input type="datetime-local" path="arrivalTime"/>
        <sf:errors path="arrivalTime"/>
    </div>
    <div>
        <sf:label path="departureTime">Departure Time</sf:label>
        <sf:input type="datetime-local" path="departureTime"/>
        <sf:errors path="departureTime"/>
    </div>
    <input type="submit" value="Schedule update">
</sf:form>
</body>
</html>