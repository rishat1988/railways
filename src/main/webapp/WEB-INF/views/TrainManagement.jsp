<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Manage Trains Page</title>
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
<h1>Manage Trains Page</h1>


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
        <th>Train Number</th>
        <th>capacity</th>
    </tr>
    <c:forEach var="train" items="${trainsList}">
        <tr>
            <td>${train.number}</td>
            <td>${train.capacityTrain}</td>
            <td>${train.capacityTrain}</td>
            <td><a href="/TrainUpdate/${train.id}">Update</a></td>
            <td><a href="/deleteTrain/${train.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<h2>Add New Train</h2>
<sf:form action="/TrainManagement" method="post" modelAttribute="train">
    <div>
        <sf:label path="number">Train Number</sf:label>
        <sf:input path="number"/>
        <sf:errors path="number"/>
    </div>
    <div>
        <sf:label path="capacityTrain">Train capacity</sf:label>
        <sf:input path="capacityTrain"/>
        <sf:errors path="capacityTrain"/>
    </div>
    <input type="submit" value="Add Train">
</sf:form>
<br>
</body>
</html>