<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign In Page</title>

    <style type="text/css">
        BODY {
            background: rgba(0, 0, 0, 0.24);
        }
        </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginPage/process" method="post">
    <div>
        Username:
        <label>
            <input name="username" type="text">
        </label>
    </div>
    <div>
        Password:
        <label>
            <input name="password" type="password">
        </label>
    </div>
    <p></p>
    <input type="submit" value="Submit">
</form>
<c:if test="${error != null}">
    <p>${error}</p>
</c:if>
<br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>