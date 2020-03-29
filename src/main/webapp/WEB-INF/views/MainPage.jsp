<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hyperloop Railway</title>
</head>
<body>
<style type="text/css">
    BODY {
        background: rgba(0, 0, 0, 0.24);
    }

    @-webkit-keyframes blink6 {
        10% { transform: scale(1, 1) rotate(80deg); }
        20% { transform: scale(0, 0) rotate(160deg); }
        100% { transform: scale(0, 0) rotate(0deg); }
    }
    @keyframes blink6 {
        10% { transform: scale(1, 1) rotate(80deg); }
        20% { transform: scale(0, 0) rotate(160deg); }
        100% { transform: scale(0, 0) rotate(0deg); }
    }
    #blink6 {
        position: relative;
        display: inline-block;
        color: #fff;
        text-shadow: 0 0 10px #d3d474;
        background: rgba(120, 34, 36, 0.33);
    }
    #blink6:after, #blink6:before {
        content: "";
        position: absolute; top: 0; left: 0;
        display: block;
        width: 100px;
        height: 100px;
        background-image:
                radial-gradient(rgba(255,255,255,1), rgba(255,255,255,0) 30%),
                linear-gradient(45deg, rgba(0,0,0,0) 49%, rgba(255,255,255,.4) 50%, rgba(0,0,0,0) 51%),
                linear-gradient(135deg, rgba(0,0,0,0) 49%, rgba(255,255,255,.4) 50%, rgba(0,0,0,0) 51%);
        -webkit-animation: blink6 10s linear infinite;
        animation: blink6 10s linear infinite;
        transform: scale(0, 0) rotate(0deg);
    }
    #blink6:before {
        top: -30%;
        right: 0; left: auto;
        -webkit-animation-delay: 5s;
        animation-delay: 5s;
    }
    </style>

<h2><div id="blink6">Welcome to Hyperloop Railway, future is HERE!</div></h2>
<p> </p>
<p> </p>
<a href="${pageContext.request.contextPath}/LoginPage">Login!</a>
<p></p>
<p>Only registered clients can see information, have time to buy the ticket!</p>
<p></p>
<a href="${pageContext.request.contextPath}/RegistrationPage">Register!</a>
<br>
<p></p>
<img src="src/main/webapp/WEB-INF/views/hyperloop.jpg" alt="here is picture about hyperloop, see in wiki $)"/>

<div class="img_wrapper">
    <img src="${pageContext.request.contextPath}src/main/webapp/WEB-INF/views/hyperloop.jpg" alt="here is picture about hyperloop"/>
</div>

<link href="${pageContext.request.contextPath}src/main/webapp/WEB-INF/views/img/hyperloop.jpg" rel="icon" type="image/x-icon" />

<%--<script>--%>
<%--    var heroArray = [--%>
<%--        '/views/hyperloop.jpg'--%>
<%--    ]--%>
<%--</script>--%>
</body>
</html>