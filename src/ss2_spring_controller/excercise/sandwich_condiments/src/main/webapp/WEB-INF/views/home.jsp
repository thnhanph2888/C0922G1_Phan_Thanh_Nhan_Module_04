<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 2/1/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiment</title>
    <style>
        td {
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="choose" method="post">
  <span>
     <input type="checkbox" name="condiment" value="Lettuce">
     Lettuce
  </span>
    <span>
     <input type="checkbox" name="condiment" value="Tomato">
     Tomato
  </span>
    <span>
     <input type="checkbox" name="condiment" value="Mustard">
     Mustard
    </span>
    <span>
     <input type="checkbox" name="condiment" value="Sprouts">
     Sprouts
</span>
    <hr>
    <button type="submit">Save</button>
</form>
<table>
    <tr>
        <td>STT</td>
        <td>Condiment</td>
    </tr>
    <c:forEach varStatus="stt" var="condiment" items="${condimentList}">
      <tr>
          <td>${stt.count}</td>
          <td>${condiment}</td>
      </tr>
    </c:forEach>
</table>
</body>
</html>
