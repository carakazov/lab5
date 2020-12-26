<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>Car information</h1>
<ul>
    <li>
        <label>Id: </label>
        <c:out value="${item.id}"/>
    </li>
    <li>
        <label>Mark: </label>
        <c:out value="${item.mark}"/>
    </li>
    <li>
        <label>Model: </label>
        <c:out value="${item.model}"/>
    </li>
    <li>
        <label>Weight: </label>
        <c:out value="${item.weight}"/>
    </li>
    <li>
        <label>Max speed: </label>
        <c:out value="${item.maxSpeed}"/>
    </li>
</ul>
<a href="/laba5_war_exploded/sedan/delete/${item.id}">Delete user</a>
</body>
</html>
