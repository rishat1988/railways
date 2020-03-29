<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome, deer client</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
        </style>
</head>
<body>
<h1>The first hyperloop raylway say you- Welcome!</h1>

<br>
<a href="${pageContext.request.contextPath}/StationManagement">Manage Stations</a>
<br>
<a href="${pageContext.request.contextPath}/TrainManagement">Manage Trains</a>
<br>
<a href="${pageContext.request.contextPath}/ScheduleManagement">Manage Schedules</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>
