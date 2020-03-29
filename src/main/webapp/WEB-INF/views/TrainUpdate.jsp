<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Train</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
    </style>
</head>
<body>
<sf:form action="/TrainUpdate" method="post" modelAttribute="train">
    <div>
        <sf:input type="hidden" path="id"/>
        <sf:errors type="hidden" path="id"/>
    </div>
    <div>
        <sf:label path="number">Number</sf:label>
        <sf:input path="number"/>
        <sf:errors path="number"/>
    </div>
    <div>
        <sf:label path="capacityTrain">Train capacity</sf:label>
        <sf:input path="capacityTrain"/>
        <sf:errors path="capacityTrain"/>
    </div>

    <input type="submit" value="Train Update">
</sf:form>
</body>
</html>
