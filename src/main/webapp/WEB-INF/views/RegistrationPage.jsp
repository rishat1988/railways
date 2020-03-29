<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign Up</title>
    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
    </style>
</head>
<body>
<sf:form action="/RegistrationPage" method="post" modelAttribute="user">
    <div>
        <sf:label path="username">Username</sf:label>
        <sf:input path="username" />
        <sf:errors path="username" />
    </div>
    <div>
        <sf:label path="name">First Name</sf:label>
        <sf:input path="name" />
        <sf:errors path="name" />
    </div>
    <div>
        <sf:label path="surname">Surname</sf:label>
        <sf:input path="surname" />
        <sf:errors path="surname" />
    </div>
    <div>


        <sf:label path="dateOfBirth">Date your birth</sf:label>
        <sf:input type="date" path="dateOfBirth" />
        <sf:errors path="dateOfBirth" />
    </div>

    <div>
        <sf:label path="password">Password</sf:label>
        <sf:input  path="password" />
        <sf:errors path="password" />
    </div>
    <div>
        <sf:label path="passwordConfirm">Confirm Password</sf:label>
        <sf:input path="passwordConfirm" />
        <sf:errors path="passwordConfirm" />
    </div>
    <input type="submit" value="Register">
</sf:form>

<br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>