<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <table>
      <tr>
        <th>Id:</th>
        <th>Mark:</th>
        <th>Model:</th>
        <th>Weight:</th>
        <th>Max speed:</th>
        <th>Show details:</th>
        <th>Modify:</th>
      </tr>
      <c:forEach items="${list}" var="car">
        <tr>
          <td>${car.id}</td>
          <td>${car.mark}</td>
          <td>${car.model}</td>
          <td>${car.weight}</td>
          <td>${car.maxSpeed}</td>
          <td><a href="/laba5_war_exploded/sedan/getOne/${car.id}">Show details</a> </td>
          <td><a href="/laba5_war_exploded/sedan/modifyForm/${car.id}">Modify</a> </td>
        </tr>
      </c:forEach>
    </table>
  <a href="/laba5_war_exploded/sedan/addNewForm">Add new</a>
  </body>
</html>
