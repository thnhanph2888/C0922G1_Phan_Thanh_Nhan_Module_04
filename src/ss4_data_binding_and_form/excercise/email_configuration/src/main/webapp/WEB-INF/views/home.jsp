<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 2/2/2023
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
</head>
<body>
    <table>
        <tr>
            <td>Id</td>
            <td>Languages</td>
            <td>Page</td>
            <td>Signature</td>
        </tr>
        <c:forEach items="${listConfig}" var="subConfig">
            <tr>
                <td>${subConfig.getId()}</td>
                <td>${subConfig.getLanguages()}</td>
                <td>${subConfig.getPageSize()}</td>
                <td>${subConfig.getSignature()}</td>
                <td>
                       <button type="submit">
                           <a href="/update?id=${subConfig.id}">Edit</a>
                       </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
