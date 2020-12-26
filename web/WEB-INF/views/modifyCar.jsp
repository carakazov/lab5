<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify car</title>
</head>
<body>
<h1>Modify car</h1>
<form method="post" action="${pageContext.request.contextPath}/sedan/modify">
    <p>
        <label>Mark: </label>
        <input type="text" name="mark" value="${item.mark}">
    </p>
    <p>
        <label>Model: </label>
        <input type="text" name="model" value="${item.model}">
    </p>
    <p>
        <label>Weight: </label>
        <input type="text" name="weight" value="${item.weight}">
    </p>
    <p>
        <label>Max speed: </label>
        <input type="text" name="maxSpeed" value="${item.maxSpeed}">
    </p>
    <p>
        <input type="hidden" name="id" value="${item.id}">
        <input type="submit" value="Update">
    </p>
</form>
</body>
</html>
