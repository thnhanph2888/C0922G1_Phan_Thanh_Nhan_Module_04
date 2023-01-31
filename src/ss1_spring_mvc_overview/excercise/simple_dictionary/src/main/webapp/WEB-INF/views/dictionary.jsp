<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 1/31/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="search" method="post">
    <table>
        <tr>
            <td>
                <input name="vocabulary" type="text"/>
            </td>
            <td>
                <input type="submit" value="Search">
            </td>
        </tr>
        <tr>
            <td>
                Result:
            </td>
            <td>
                ${word}
            </td>
        </tr>
    </table>
</form>
</body>
</html>
