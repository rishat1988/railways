<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Manage Stations Page</title>
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
<h1>Manage Stations Page</h1>


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
        <th>Station name</th>
    </tr>
    <c:forEach var="station" items="${stationsList}">
        <tr>
            <td>${station.id}</td>
            <td>${station.name}</td>
            <td><a href="/StationUpdate/${station.id}">Update</a></td>
            <td><a href="/deleteStation/${station.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<h2>Add New Station</h2>
<sf:form action="/StationManagement" method="post" modelAttribute="station">
    <div>
        <sf:label path="name">Station Name</sf:label>
        <sf:input path="name"/>
        <sf:errors path="name"/>
    </div>
    <input type="submit" value="Add Station">
</sf:form>
</body>
</html>