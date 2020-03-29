<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Timetable Page</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
        TABLE {
            width: 100%;
            border-collapse: collapse;
            border: 0.1px solid;
        }
        TD, TH {
            padding: 3px;
            border: 0.1px solid black;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Manage Schedule</h1>


<br>
<a href="${pageContext.request.contextPath}/StationManagement">Manage Stations</a>
<br>
<a href="${pageContext.request.contextPath}/TrainManagement">Manage Trains</a>
<br>
<a href="${pageContext.request.contextPath}/ScheduleManagement">Manage Schedules</a>
<br>
<br>
<table>
    <tr>
        <th>id</th>
        <th>train number</th>
        <th>station</th>
        <th>arrival time</th>
        <th>departure time</th>
    </tr>
    <c:forEach var="scheduleDto" items="${scheduleDtosList}">
        <tr>
            <td>${scheduleDto.id}</td>
            <td>${scheduleDto.trainNumber}</td>
            <td>${scheduleDto.stationName}</td>
            <td>${scheduleDto.arrivalTimeFormat}</td>
            <td>${scheduleDto.departureTimeFormat}</td>
            <td><a href="/ScheduleUpdate/${scheduleDto.id}">Update</a></td>
            <td><a href="/deleteSchedule/${scheduleDto.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<h2>Add New Schedule</h2>
<sf:form action="/ScheduleManagement" method="post" modelAttribute="schedule">
    <div>
        <sf:label path="trainNumber">Train Number</sf:label>
        <sf:select path="trainNumber">
            <c:forEach items="${scheduleTrainsList}" var="scheduleTrain">
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
<%--        <sf:input type="datetime-local" path="departureTime"/>--%>
        <sf:input type="datetime-local" path="departureTime"/>--%>
        <sf:errors path="departureTime"/>
    </div>
    <input type="submit" value="Add Schedule">
</sf:form>
</body>
</html>