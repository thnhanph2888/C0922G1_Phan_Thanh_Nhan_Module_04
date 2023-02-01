<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 2/1/2023
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
      td {
        height: 20px;
        width: 20px;
        padding: 0px;
        margin: 0px;
      }
    </style>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
<table>
  <tr>
    <td colspan="4">
      <input name="firstNumber">
    </td>
  </tr>
  <tr>
    <td colspan="4">
      <input name="secondNumber">
    </td>
  </tr>
  <tr>
    <th>
       <button type="submit" name="calculation" value="+">+</button>
    </th>
    <th>
       <button type="submit" name="calculation" value="-">-</button>
    </th>
    <th>
       <button type="submit" name="calculation" value="*">x</button>
    </th>
    <th>
       <button type="submit" name="calculation" value="/">/</button>
    </th>
  </tr>
  <tr>
    <td>Result: </td>
    <td>${result}</td>
  </tr>
</table>
</form>
</body>
</html>
