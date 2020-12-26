<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
</head>
<body>
    <h1>Add new car</h1>
<form method="post" action="${pageContext.request.contextPath}/sedan/addNew">
    <p>
        <label>Mark: </label>
        <input type="text" name="mark">
    </p>
    <p>
        <label>Model: </label>
        <input type="text" name="model">
    </p>
    <p>
        <label>Weight: </label>
        <input type="text" name="weight">
    </p>
    <p>
        <label>Max speed: </label>
        <input type="text" name="maxSpeed">
    </p>
    <p>
        <input type="submit" value="Add">
    </p>
</form>
</body>
</html>
