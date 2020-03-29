<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Station</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
    </style>
</head>
<body>
<c:url value="/StationUpdate" var="var"/>

<sf:form action="/StationUpdate" method="post" modelAttribute="station">
    <div>
        <sf:input type="hidden" path="id"/>
        <sf:errors type="hidden" path="id"/>
    </div>
    <div>
        <sf:label path="name">Station Name</sf:label>
        <sf:input path="name"/>
        <sf:errors path="name"/>
    </div>
    <input type="submit" value="Station Update">
</sf:form>
</body>
</html>
